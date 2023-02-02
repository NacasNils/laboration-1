import java.util.*;

public class Workshop<T extends Vehicle> {
    List<T> storage = new ArrayList<>();
    private final int maxCapacity;
    private int currentLoad = 0;

    public Workshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int parkVehicle(T v) {
        if (currentLoad == maxCapacity) throw new Error("Cannot park into a full workshop!");
        if (v.getSize()+currentLoad < maxCapacity) {
            storage.add(v);
            currentLoad += v.getSize();
            return storage.size()-1;
        }
        return -1;
    }

    public T unparkVehicle(int id) {
        if (currentLoad == 0) throw new Error("Cannot unpark from an empty workshop!");
        T v = storage.remove(id);
        currentLoad -= v.getSize();
        return v;
    }
}