import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.List;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.Duration;

public class AddAllTheNumbers {
  public static void main(String[] args) {
    System.out.println("starting out strong");
    // int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    int[] numbers = makeGiantArray();
    System.out.println("Running normally");
    LocalDateTime then = LocalDateTime.now();
    int ans = 0;
    for (int i = 0; i < numbers.length; i++) {
      ans += numbers[i];
    }
    System.out.println(ans);
    long timeTaken = Duration.between(then, LocalDateTime.now()).getNano();//LocalDateTimeTime.now().toEpochSecond(zone) - then.toEpochSecond(zone);
    System.out.println("Boring way took " + timeTaken);

    System.out.println("Forking time");
    then = LocalDateTime.now();
    ForkJoinPool commonPool = ForkJoinPool.commonPool();
    MyCoolTask taskOfAllNumbers = new MyCoolTask(numbers, 0, numbers.length);
    commonPool.execute(taskOfAllNumbers);
    System.out.println(taskOfAllNumbers.join());
    long secondTimeTaken = Duration.between(then, LocalDateTime.now()).getNano();
    System.out.println("Fun way took " + secondTimeTaken);
    System.out.println(timeTaken);
    System.out.println(secondTimeTaken);
  }

  public static int[] makeGiantArray() {
    int[] ans = new int[1000000];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = 1;
    }
    return ans;
  }
}

class MyCoolTask extends RecursiveTask<Integer> {

  int[] myNumbers;
  int start;
  int end;

  public MyCoolTask(int[] nums, int start, int end) {
    this.myNumbers = nums;
    this.start = start;
    this.end = end;
  }

  @Override
  public Integer compute() {
    if (end - start < 20000) {
      return calculateSum();
    } else {
      List<MyCoolTask> newTasks = new LinkedList<>();
      newTasks.add(new MyCoolTask(myNumbers, start, (start + end) / 2));
      newTasks.add(new MyCoolTask(myNumbers, (start + end) / 2, end));
      return ForkJoinTask.invokeAll(newTasks)
        .stream()
        .mapToInt(ForkJoinTask::join)
        .sum();
    }
  }

  public Integer calculateSum() {
    int sum = 0;
    for (int i = start; i < end; i++) {
      sum += myNumbers[i];
    }
    return sum;
  }
}