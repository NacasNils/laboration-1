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

    enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Point currentpos;
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
        this.enginePower = 0;
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
    
    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }
}
