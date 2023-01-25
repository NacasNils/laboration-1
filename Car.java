import java.awt.*;

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

    public void move() {
        switch (direction) {
            case UP: pos.y--; break;
            case DOWN: pos.y++; break;
            case LEFT: pos.x--; break;
            case RIGHT: pos.x++; break;
            default:
                throw new Error("Unknown direction!");
        }
    }

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

    
    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
	    color = clr;
    }

    public void startEngine() {
	    currentSpeed = 0.1;
    }

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
