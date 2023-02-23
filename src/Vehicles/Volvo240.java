package Vehicles;
import java.awt.*;


/**
 * A specific car Volvo 240, inherits from the class Car
 */
public class Volvo240 extends Vehicle {
    /** An instance variable descibing the trim factor */
    public final static double trimFactor = 1.25;

    /**
     * constructor for volvo class
     */
    public Volvo240(Color color) {
        super("Volvo240", color, 100, 4);
        image = loadImage("Volvo240.jpg");
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
}