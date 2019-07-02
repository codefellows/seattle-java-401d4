# Steps in Writing Code for Bitmap

Again, please take this as one good idea of how to make progress, not gospel truth. If you have a different workflow that you like, use it.

1) Generate a Java application. Ensure that I can run it on the command line with `./gradlew run` and print a hello world.
2) Write code to read in a bitmap file, and then write out that bitmap (unchanged) into a file with a different name. (Both file paths are hardcoded Strings in my code, and at this point, I'm still working in the main method.) Run the application, and make sure that I can read and then write that bitmap file.
3) Create the `Bitmap` class, with a constructor and an instance method to write out image data. Move code from my main method into that class, and create a `Bitmap` object in my main method and write it out to a different filename (still with hardcoded strings). Run the application, and make sure that I can still read and then write the file now that my code is abstracted.
4) Write a single transform method. (I would pick something easy, like, "set every pixel to purple", or if I want to get fancy, "set every white pixel to purple".) Call that method in my main method, and ensure that I can read in a bitmap and get written out a bitmap file that is the same size, but everything is purple now.
5) Start working with command line arguments. Start by making the output file path a command line argument, and ensure that that works; then add the input file as a command line argument, and ensure that that works.
6) Add a second transform, maybe getting fancier. Make sure my second transform works.
7) Add the command line argument for which transform should be run. Make sure that works.
8) Think about testing my transform methods with actual tests.
9) Continue writing transforms and tests.
10) victory
