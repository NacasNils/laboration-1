import java.awt.*;

/**
* A specific car Saab 95, inherits from the class Car
*/
public class Saab95 extends Car {
    /**
     * variable that is true if Turbo is on, otherwise false.
     */
    private boolean turboOn;

    /**
     * constructor for Saab95 Class
     */
    public Saab95() {
        super("Saab95", Color.RED, 125, 2);
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

    /**
     * method that increases the current speed of the car
     * @param amount  the amount to increment the speed with
     */
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Method that decreases the speed. But will not deacrease past 0.
     * @param amount  the amount to decrement the speed with
     */
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
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
}
