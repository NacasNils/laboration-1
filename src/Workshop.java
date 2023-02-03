import java.util.*;

/**
 * class workshop
 * @param <T> can only take in vehicle or classes that extend vehicle or its subclasses.
 */
public class Workshop<T extends Vehicle> {

    /**
     * Represents the space inside the workshop
     */
    private Storage<T> parkingBay;


    /**
     * constructor for workshop
     * @param maxCapacity
     */
    public Workshop(int maxCapacity) {
        parkingBay = new Storage<>(maxCapacity);
    }

    /**
     * method that parks vehicle of workshop choice
     * @param v
     */
    public void parkVehicle(T v) {
        parkingBay.load(v);
    }

    /**
     * given the int ID it will return the vehicle associated with that id
     * @param id
     * @return vehicle of type T
     */
    public T unparkVehicle() {
        return parkingBay.unload();
    }
}