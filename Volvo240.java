import java.awt.*;

/**
* A specific car Volvo 240, inherits from the class Car
*/
public class Volvo240 extends Car {
    /** An instance variable descibing the trim factor */
    public final static double trimFactor = 1.25;
    
    public Volvo240() {
        super("Volvo240", Color.black, 100, 4);
    }
    
    /**
    * Returns the speed factor
    * @return a double
    */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount) {
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
