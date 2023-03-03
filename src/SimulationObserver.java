import General.Drawable;

public interface SimulationObserver {
    void refreshState(); // each tick of the simulation
    void queueDraw(Drawable obj); // queue an object to be drawn
}
