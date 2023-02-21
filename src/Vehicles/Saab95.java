package Vehicles;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import General.Drawable;

import java.io.IOException;
import java.awt.*;

/**
 * A specific car Saab 95, inherits from the class Car
 */
public class Saab95 extends Vehicle implements Drawable {
    /**
     * variable that is true if Turbo is on, otherwise false.
     */
    private boolean turboOn;
    private BufferedImage image;

    /**
     * constructor for Saab95 Class
     */
    public Saab95(Color color) {
        super("Saab95", color, 125, 2);
        turboOn = false;
        try {
            image = ImageIO.read(Saab95.class.getResourceAsStream("../pics/Saab95.jpg"));
        } catch (IOException ex) {ex.printStackTrace();}
    }

    public int getSize() { return 1; }

    /**
     * Returns the speed factor
     * @return a double
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /** Turn on turbo */
    public void setTurboOn() {
        turboOn = true;
    }

    /** Turn off turbo */
    public void setTurboOff() {
        turboOn = false;
    }

    public boolean getTurbo() {
        return turboOn;
    }

    public BufferedImage getImage() {
        return image;
    }

}