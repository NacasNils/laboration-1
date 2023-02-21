package Vehicles;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import General.Drawable;
import java.io.IOException;
import java.awt.*;


/**
 * A specific car Volvo 240, inherits from the class Car
 */
public class Volvo240 extends Vehicle implements Drawable {
    /** An instance variable descibing the trim factor */
    public final static double trimFactor = 1.25;

    private BufferedImage image;

    /**
     * constructor for volvo class
     */
    public Volvo240(Color color) {
        super("Volvo240", color, 100, 4);
        try {
            image = ImageIO.read(Volvo240.class.getResourceAsStream("../pics/Volvo240.jpg"));
        } catch (IOException ex) {ex.printStackTrace();}
    }

    /**
     * simple getter for size of volvo 240
     * @return size of Volvo240
     */
    public int getSize() { return 1; }

    /**
     * Returns the speed factor
     * @return a double
     */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    public BufferedImage getImage() {
        return image;
    }

}