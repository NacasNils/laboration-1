import java.awt.*;
import java.util.Stack;

public class Zis150 extends Truck {
    public static final int maxCapacity = 3;
    private int currentLoad = 0;
    private Stack<Vehicle> bed = new Stack<>();

    public Zis150(Color color) {
        super("Zis 150", color, 960);
    }

    public int getSize() { return 4; }

    public boolean isHoldingLoad() {
        return currentLoad > 0;
    }

    public void loadVehicle(Vehicle v) {
        if (currentSpeed != 0) throw new Error("Cannot load when travelling!");
        if (currentLoad == maxCapacity) throw new Error("Cannot load to a full bed!");
        if (isBedRaised()) throw new Error("Cannot load to a raised bed!");
        if (v.getSize()+currentLoad < maxCapacity) {
            bed.push(v);
            currentLoad += v.getSize();
        }
    }

    public Vehicle unloadVehicle() {
        if (currentSpeed != 0) throw new Error("Cannot unload when travelling!");
        if (currentLoad == 0) throw new Error("Cannot unload from empty bed!");
        if (isBedRaised()) throw new Error("Cannot unload from a raised bed!");
        Vehicle v = bed.pop();
        currentLoad -= v.getSize();
        return v;
    }

    @Override
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