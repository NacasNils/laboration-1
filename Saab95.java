import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;
    
    public Saab95() {
        super("Saab95", Color.red, 125, 2);
        turboOn = false;
    }

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

    public void setTurboOn() {
	    turboOn = true;
    }

    public void setTurboOff() {
	    turboOn = false;
    }
}
