package bitmapTransform;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

import static org.junit.Assert.*;

public class BitmapTest {

    @Test
    public void makeBlackAndWhite() {
        BufferedImage imageForTesting = new BufferedImage(1, 3, BufferedImage.TYPE_3BYTE_BGR);
        imageForTesting.setRGB(0,0, -1);
        imageForTesting.setRGB(0,1, -3745);
        imageForTesting.setRGB(0,2,-1);

        Bitmap bitmap = new Bitmap(imageForTesting);
        bitmap.makeBlackAndWhite();
        assertEquals("white values should remain unchanged",
                -1,
                bitmap.imageData.getRGB(0,0));
        assertEquals("white values should remain unchanged",
                -1,
                bitmap.imageData.getRGB(0,2));
        assertNotEquals("Pixel with other colors should be modified",
                0,
                bitmap.imageData.getRGB(0,1));
    }
}