import java.awt.*;
/**
* Class Car is an abstract class that a specific car should inherit and use
*/
public abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Point pos;
    private Dir direction;

    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);

    Car(String name, Color col, int power, int nDoors) {
        this.modelName = name;
        this.color = col;
        this.enginePower = power;
        this.nrDoors = nDoors;
        this.enginePower = 0;
    }

    /**
    * Moves the car depending on the instance variable currentSpeed,
    * towards the current direction that the car is facing.
    * @throws Error if direction is unknown
    */
    public void move() {
        switch (direction) {
            case UP: pos.y-=currentSpeed; break;
            case DOWN: pos.y+=currentSpeed; break;
            case LEFT: pos.x-=currentSpeed; break;
            case RIGHT: pos.x+=currentSpeed; break;
            default:
                throw new Error("Unknown direction!");
        }
    }

    /**
    * Turns the car depending on the instance variable direction,
    * towards a direction that is the natural left of the former one.
    * @throws Error if direction is unknown
    */
    public void turnLeft() {
        switch (direction) {
            case UP: direction = Dir.LEFT; break;
            case DOWN: direction = Dir.RIGHT; break;
            case LEFT: direction = Dir.DOWN; break;
            case RIGHT: direction = Dir.UP; break;
            default:
                throw new Error("Unknown direction!");
        }
    }

    /**
    * Turns the car depending on the instance variable direction,
    * towards a direction that is the natural right of the former one.
    * @throws Error if direction is unknown
    */
    public void turnRight() {
        switch (direction) {
            case UP: direction = Dir.RIGHT; break;
            case DOWN: direction = Dir.LEFT; break;
            case LEFT: direction = Dir.UP; break;
            case RIGHT: direction = Dir.DOWN; break;
            default:
                throw new Error("Unknown direction!");
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

    /**
    * Starts the engine and sets the speed to 0.1
    */
    public void startEngine() {
	    currentSpeed = 0.1;
    }

    /**
    * Starts the engine and sets the speed to 0
    */
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
