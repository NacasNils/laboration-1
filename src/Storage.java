import java.util.Iterator;
import java.util.Stack;

public class Storage <T extends Loadable> implements Iterable<T> {
    /** int that gives us the max load the truck can take */
    public final int maxCapacity;
    /** int that gives us the current load on the truck */
    private int currentLoad = 0;

    private Stack<T> holder = new Stack<>();


    public Storage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * simple method for checking if the truck is carrying anything
     * @return true if load is present, false otherwise
     */
    public boolean isHoldingLoad() {
        return currentLoad > 0;
    }

    public boolean hasSpaceFor(T v) {
        return (v.getSize()+currentLoad <= maxCapacity);
    }

    /**
     * method for loading with parameters set. will push the vehicle on stack and add to currentload
     * @param v
    */
    public void load(T v) {
        if (!v.satisfiesConditionsForLoading()) throw new Error("Item does not satisfy conditions for loading!");
        if (currentLoad == maxCapacity) throw new Error("Cannot load to full storage!");
        if (v.getSize()+currentLoad <= maxCapacity) {
            holder.push(v);
            currentLoad += v.getSize();
        }
    }

    /**
     * method for unloading  with parameters set. will pop the vehicle from stack and decrease currentload correctly
     * @return
    */
    public T unload() {
        if (currentLoad == 0) throw new Error("Cannot unload from empty storage!");
        T v = holder.pop();
        currentLoad -= v.getSize();
        return v;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int index = 0;

        public boolean hasNext() {
            return index < holder.size();
        }

        public T next() {
            return holder.get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
   }
}
