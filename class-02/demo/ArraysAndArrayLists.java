import java.util.Arrays;
import java.util.ArrayList;

// when I run this code, what is going to happen?
public class ArraysAndArrayLists {
  public static void main(String[] args) {
    // int[] randomArray = getRandomIntArray(20);
    // System.out.println(Arrays.toString(randomArray));

    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("Hello");
    arrayList.add("world");
    arrayList.add("32");
    for (String s : arrayList) {
      System.out.println(s);
    }
    arrayList.remove(arrayList.size() - 1);
    arrayList.add(0, "wow");
    // System.out.println(arrayList);

    // errors
    // ArrayList<int> nums = new ArrayList<>();
    ArrayList<Integer> nums = new ArrayList<>();

  }

  public static int[] getRandomIntArray(int length) {
    int[] ans = new int[length];
    for(int i = 0; i < length; i++) {
      ans[i] = (int) (Math.random() * 10.0);
    }
    return ans;
  }

  public static char[] getRandomCharArray(int length) {
    char[] ans = new char[length];
    ans[0] = 'a';
    for(int i = 1; i < length; i++) {
      ans[i] = (char) Math.floor(97 + Math.random() * 26.0);
    }
    return ans;
  }
}
