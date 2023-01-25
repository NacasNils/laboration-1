import java.awt.*;

public class Volvo240 extends Car {
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
