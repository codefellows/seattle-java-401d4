public class Stars {
  public static void main(String[] args) {
    System.out.println("Hello from the Stars class!");
    System.out.println("stars(0): " + stars(0));
    System.out.println("stars(5): " + stars(5));

    System.out.println("pyramid(5):");
    pyramid(5);

    System.out.println("upsideDownPyramid(5):");
    upsideDownPyramid(5);

    System.out.println("sharkMouth(5):");
    sharkMouth(5);

    System.out.println("triangle(5):");
    triangle(5);
  }

  public static void pyramid(int n) {
    if (n < 1) {
      System.out.println("");
    } else {
      System.out.println(stars(n));
      pyramid(n-1);
    }
  }

  public static void upsideDownPyramid(int n) {
    if (n < 1) {
      System.out.println("");
    } else {
      upsideDownPyramid(n-1);
      System.out.println(stars(n));
    }
  }

  /*

  ****   <-- current
  ***
  **
  *


  *
  **
  ***
  ****   <-- current

*/

// function doStuff() {
//   doOtherStuff();
//   console.log("stuff");
// }

// function doOtherStuff() {
//   console.log("other stuff");
// }

// doStuff()

// *
// **
// ***
// ***
// **
// *


// *
// **
// **
// *

  public static void triangle(int n) {
    upsideDownPyramid(n);
    pyramid(n);
  }
  public static void sharkMouth(int n) {
    if (n < 1) {
      // do nothing
    } else {
      System.out.println(stars(n));
      sharkMouth(n-1);
      System.out.println(stars(n)); // current work 2
      
    }

  }

  // public static void sharkMouthV2(int n) {
  //   pyramid(n);
  //   upsideDownPyramid(n);
  // }

  public static String stars(int n) {
    if (n < 1) {
      return "";
    } else {
      return "*"       + stars(n-1);
      //  right now
      //                   recursive work
      // how to put those together (+)
    }
  }
}