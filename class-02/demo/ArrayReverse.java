import java.util.Arrays;

public class ArrayReverse {
  public static void main(String[] args) {
   // create the array to test your code on later
   int[] startArr = new int[] {1,2,3,4,5,10};
   // print it out, nicely
   System.out.println(Arrays.toString(startArr));
   // call your reverseArray method and save the result in a variable
   int[] endArr = reverse(startArr);
   // print out the result, nicely
   System.out.println(Arrays.toString(endArr));
  }

  public static int[] reverse(int[] inputArr) {
    for (int i = 0; i < inputArr.length / 2; i++) {
      int temp = inputArr[i];
      inputArr[i] = inputArr[inputArr.length - i - 1];
      inputArr[inputArr.length - i - 1] = temp;
    }
    return inputArr;
  }

}