package bitmapTransform;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    BufferedImage imageData;

    public Bitmap(BufferedImage imageData) {
        this.imageData = imageData;
    }

    // Create black-and-white (not grayscale) version of image
    public void makeBlackAndWhite() {
        for (int i = 0; i < imageData.getWidth(); i++) {
            for (int j = 0; j < imageData.getHeight(); j++) {
                int currentPixel = imageData.getRGB(i, j);
//                if (i < 3 && j < 3) {
//                    System.out.println(currentPixel);
//                }
//                if (currentPixel != -1) {
//                    System.out.println(currentPixel);
//                }
                if(currentPixel != -1) {
                    imageData.setRGB(i, j, 0);
                }
            }
        }
    }

    public void outputToFile(String fileName) throws IOException {
        ImageIO.write(this.imageData, "bmp", new File(fileName));
    }
}
