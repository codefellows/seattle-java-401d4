import java.util.Calendar;

public class DemoJavaFile {
  // main method is the code that will be run when we compile/run this code
  public static void main(String [] args) {
    System.out.println("Hello world!");
    System.out.println("" + (getTwo() + getTwo()));

    if(shouldIHaveAnotherCupOfCoffee(4, 1, true, 10)) {
      System.out.println("drinking coffee");
    }

    loopALot();

  }

  // primitive types:
  // byte, short, int, long
  // float, double
  // boolean
  // char

  // object types:
  // String
  public static int getTwo() {
    return 2;
  }

  public static boolean shouldIHaveAnotherCupOfCoffee(int cupsOfCoffeeSoFar, int tirednessLevel, boolean isCoffeeFree, float hoursOfWorkRemaining) {
    if (cupsOfCoffeeSoFar > 3 || cupsOfCoffeeSoFar == 3) {
      // if you've had 4 cups, you're done
      return false;
    } else if (hoursOfWorkRemaining < 1 && tirednessLevel < 2) {
      return false;
    } else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 12) {
      return false;
    } else {
      // we get coffee
      return true;
    }
  }

  public static void loopALot() {
    int numberOfLoops = 0;
    while (numberOfLoops < 1000000) {
      numberOfLoops++;
      if(numberOfLoops % 100000 == 0) {
        System.out.println("We've looped " + numberOfLoops + " times.");
      }
    }
  }
}
