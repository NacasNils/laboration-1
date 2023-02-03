import java.awt.*;

/**
 * Scania class truck which has the standard functions of a Truck
 */
public class Scania extends Truck {
    public Scania(Color color) {
        super("Scania", color, 660);
    }

    /**
     * simple getter which gives size
     * @return size of vehicle
     */
    public int getSize() { return 3; }
}
