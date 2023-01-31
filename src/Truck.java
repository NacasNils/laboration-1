import java.awt.*;

public abstract class Truck extends Vehicle {
    private int bedAngle = 0;

    /**
     * constructor for volvo class
     */
    public Truck(String modelName, Color color, int power) {
        super(modelName, color, power, 2);
    }

    /**
     * Returns the speed factor
     * @return a double
     */
    public double speedFactor() {
        return enginePower * 0.01;
    }

    public void raiseBed() {
        if (currentSpeed != 0) return;
        bedAngle = (int) clamp(bedAngle+1, 0, 70);
    }

    public void lowerBed() {
        if (currentSpeed != 0) return;
        bedAngle = (int) clamp(bedAngle-1, 0, 70);
    }

    /**
     * increases the speed accoring the the argument amount which needs to be in the interval [0, 1]
     * @param  amount  a number between 0-1
     */
    @Override
    public void gas(double amount) {
        if (bedAngle != 0) return;
        amount = clamp(amount, 0, 1);
        incrementSpeed(amount);
    }
}
