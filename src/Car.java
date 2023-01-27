import java.awt.*;
/**
* Class Car is an abstract class that a specific car should inherit from
*/
public abstract class Car implements Movable {
    /** Number of doors on the car */
    protected int nrDoors;
    /** Engine power of the car */
    protected double enginePower;
    /** The current speed of the car */
    protected double currentSpeed;
    /** Color of the car */
    protected Color color;
    /** The car model name */
    protected String modelName;

    /** enum for different directions the car can go */
    enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /** gives current position of the car */
    private Point currentpos;

    /**
     * gives current position of car in the form of a java point
     * @see Dir
     */
    private Dir currentDir;

    /**
    * Increments the speed
    * @param  amount  the amount to increment the speed with
    */
    public abstract void incrementSpeed(double amount);
    /**
    * Decrements the speed
    * @param  amount  the amount to decrement the speed with
    */
    public abstract void decrementSpeed(double amount);

    /** Sets the proper instance variables for the car */
    Car(String name, Color col, int power, int nDoors) {
        this.modelName = name;
        this.color = col;
        this.enginePower = power;
        this.nrDoors = nDoors;
        this.currentSpeed = 0;
    }

    /**
    * Moves the car depending on the instance variable currentSpeed,
    * towards the current currentDir that the car is facing.
    * @throws Error if currentDir is unknown
    */
    public void move() {
        switch (currentDir) {
            case UP: currentpos.y-=currentSpeed; break;
            case DOWN: currentpos.y+=currentSpeed; break;
            case LEFT: currentpos.x-=currentSpeed; break;
            case RIGHT: currentpos.x+=currentSpeed; break;
            default:
                throw new Error("Unknown currentDir!");
        }
    }

    /**
    * Turns the car depending on the instance variable currentDir,
    * towards a currentDir that is the natural left of the former one.
    * @throws Error if currentDir is unknown
    */
    public void turnLeft() {
        switch (currentDir) {
            case UP: currentDir = Dir.LEFT; break;
            case DOWN: currentDir = Dir.RIGHT; break;
            case LEFT: currentDir = Dir.DOWN; break;
            case RIGHT: currentDir = Dir.UP; break;
            default:
                throw new Error("Unknown currentDir!");
        }
    }

    /**
    * Turns the car depending on the instance variable currentDir,
    * towards a currentDir that is the natural right of the former one.
    * @throws Error if currentDir is unknown
    */
    public void turnRight() {
        switch (currentDir) {
            case UP: currentDir = Dir.RIGHT; break;
            case DOWN: currentDir = Dir.LEFT; break;
            case LEFT: currentDir = Dir.UP; break;
            case RIGHT: currentDir = Dir.DOWN; break;
            default:
                throw new Error("Unknown currentDir!");
        }
    }

    /**
    * Returns an int describing the number of doors on the car 
    * @return an int
    */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
    * Returns a double describing the amount of engine power this car has
    * @return a double
    */
    public double getEnginePower() {
        return enginePower;
    }

    /**
    * Returns a double describing the current speed this car has
    * @return a double
    */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
    * Returns the color this car has
    * @return      the color of this car
    * @see         Color
    */
    public Color getColor() {
        return color;
    }

    /**
    * Returns the color this car has
    * @param  clr  the new color
    * @see         Color
    */
    public void setColor(Color clr) {
	    color = clr;
    }

    /** Starts the engine and sets the speed to 0.1 */
    public void startEngine() {
	    currentSpeed = 0.1;
    }

    /** Starts the engine and sets the speed to 0 */
    public void stopEngine() {
	    currentSpeed = 0;
    }
    
    /**
    * increases the speed accoring the the argument amount which needs to be in the interval [0, 1]
    * @param  amount  a number between 0-1
    */
    public void gas(double amount) {
        amount = clamp(amount, 0, 1);
        incrementSpeed(amount);
    }

    /**
    * decreases the speed accoring the argument amount which needs to be in the interval [0, 1]
    * @param  amount  a number between 0 and 1
    */
    public void brake(double amount) {
        amount = clamp(amount, 0, 1);
    }

    /**
     * method makes sure that we never input a value outside the boundries.
     * if higher than max value then it will return the max value, same for lower value.
     * @param val input Value.
     * @param min minimum Value the method is supposed to take.
     * @param max maximum Value the method is supposed to take.
     * @return
     */
    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }
}
