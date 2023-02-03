import java.awt.*;

/**
 * Zis150 class that extends Truck
 */
public class Zis150 extends Truck {
    /**
     * Storage that follows lifo structure, meant to represent the car carrying bed.
     */
    private Storage<Vehicle> bed = new Storage<>(4);


    /**
     * constructor for Zis150 class vehicle
     * @param color
     */
    public Zis150(Color color) {
        super("Zis 150", color, 960);
    }

    /**
     * simple getter for the size of Zis150
     * @return size of Zis150
     */
    public int getSize() { return 5; }

    /**
     * method for loading a vehicle with parameters set. will push the vehicle on stack and add to currentload
     * @param v
    */
    public void loadVehicle(Vehicle v) {
        if (isBedRaised()) throw new Error("Cannot load to a raised bed!");
        bed.load(v);
    }

    /**
     * method for unloading a vehicle with parameters set. will pop the vehicle from stack and decrease currentload correctly
     * @return
    */
    public Vehicle unloadVehicle() {
        if (currentSpeed != 0) throw new Error("Cannot unload when travelling!");
        if (isBedRaised()) throw new Error("Cannot unload from a raised bed!");
        return bed.unload();
    }



    @Override
    /**
     * special case of move that changes the position of the vehicles loaded on the truck to the trucks position.
     * (updates the position)
     */
    public void move() {
        switch (currentDir) {
            case UP: currentpos.y-=currentSpeed; break;
            case DOWN: currentpos.y+=currentSpeed; break;
            case LEFT: currentpos.x-=currentSpeed; break;
            case RIGHT: currentpos.x+=currentSpeed; break;
        }

        for (Vehicle vehicle : bed) {
            vehicle.currentpos = currentpos;
        }
    }
}