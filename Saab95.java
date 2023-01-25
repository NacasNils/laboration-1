import java.awt.*;

/**
* A specific car Saab 95, inherits from the class Car
*/
public class Saab95 extends Car {
    private boolean turboOn;
    
    public Saab95() {
        super("Saab95", Color.red, 125, 2);
        turboOn = false;
    }

    /**
    * Returns the speed factor
    * @return a double
    */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /** Turn on turbo */
    public void setTurboOn() {
	    turboOn = true;
    }

    /** Turn off turbo */
    public void setTurboOff() {
	    turboOn = false;
    }
}
