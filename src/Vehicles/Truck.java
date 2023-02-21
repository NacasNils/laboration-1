package Vehicles;
import java.awt.*;

/**
 * Truck class which extends Vehicle class
 */
public abstract class Truck extends Vehicle {
    /**
     * int that gives us the angle of the bed
     */
    private int bedAngle = 0;

    /**
     * constructor for volvo class
     */
    public Truck(String modelName, Color color, int power) {
        super(modelName, color, power, 2);
    }

    /**
     * simple boolean function which tells us if the bed is raised
     * @return boolean true if bed is raised, false otherwise
     */
    public boolean isBedRaised() { return bedAngle != 0; }

    /**
     * Returns the speed factor
     * @return a double
     */
    public double speedFactor() {
        return enginePower * 0.001; // 0.66
    }

    /**
     * if the current speed of the vehicle is 0 then the bed can be raised
     */
    public void raiseBed() {
        if (currentSpeed != 0) return;
        bedAngle = (int) clamp(bedAngle+1, 0, 70);
    }

    /**
     * if the current speed of the vehicle is 0 then the bed can be lowered
     */
    public void lowerBed() {
        if (currentSpeed != 0) return;
        bedAngle = (int) clamp(bedAngle-1, 0, 70);
    }

    /**
     * increases the speed accoring the argument amount which needs to be in the interval [0, 1]
     * @param  amount  a number between 0-1
     */
    @Override
    public void gas(double amount) {
        if (bedAngle != 0) return;
        amount = clamp(amount, 0, 1);
        incrementSpeed(amount);
    }
}
