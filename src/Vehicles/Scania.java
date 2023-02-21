package Vehicles;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import General.Drawable;
import java.io.IOException;
import java.awt.*;


/**
 * Scania class truck which has the standard functions of a Truck
 */
public class Scania extends Truck implements Drawable {
    private BufferedImage image;

    public Scania(Color color) {
        super("Scania", color, 660);
        try {
            image = ImageIO.read(Scania.class.getResourceAsStream("../pics/Scania.jpg"));
        } catch (IOException ex) {ex.printStackTrace();}
    }

    /**
     * simple getter which gives size
     * @return size of vehicle
     */
    public int getSize() { return 3; }

    public BufferedImage getImage() {
        return image;
    }
}
