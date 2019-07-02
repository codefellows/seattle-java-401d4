# Bitmap Resources

My recommendation is that you use small pieces of this file as necessary, and try to do your own research instead of relying on mine, but these resources will help ensure that you have some path to follow.

I've put in here the way that I worked through this problem to solve it. **Your code does not need to use exactly these classes to solve the problem.** If your research led you down a different path, *that's wonderful*.

## From searching "java read in bitmap"
* https://blog.idrsolutions.com/2017/03/how-to-read-bmp-images-in-java/
* https://javaconceptoftheday.com/read-and-write-images-in-java/
* From those, I get the idea that ImageIO is going to be a useful class for my purposes.

## From searching "java imageio"
* https://docs.oracle.com/javase/7/docs/api/javax/imageio/ImageIO.html
    * tells me that calling `read` returns a `BufferedImage`

## From searching "java bufferedimage"
* https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
    * tells me that `getRGB(x,y)` returns an int in RGB
    * and `setRGB(x,y,rgb)` sets the pixel value at a location

## Thinking about structure of classes
I know I want a Bitmap class. A Bitmap instance should probably contain data about the image data that it represents.

So, a Bitmap might have a BufferedImage that represents its image data.

And then I could call transform methods on it to be able to perform my image transforms.

Here's my dream code sample:
```java
BufferedImage imageData = /*reading from file*/;
Bitmap b = new Bitmap(imageData);
b.flipHorizontally(); // flips the image data within that bitmap instance
b.writeToFile("path/to/output.bmp"); // in that location, there is now a file with the original bitmap flipped horizontally
```

So that tells me my `Bitmap` class should probably have an `imageData` instance variable that is a `BufferedImage` instance, and then can have an instance method like `flipHorizontally` that will modify that image data. I'll also want a `writeToFile` instance method that writes the `imageData` out to a file somewhere.

Now that I know the structure of that class, I can think about how to implement the code within each of those methods.
