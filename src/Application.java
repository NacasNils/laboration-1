public class Application {
    public static void main(String[] args) {
        Model m = new Model();
        CarController cc = new CarController(m);
        CarView v = new CarView("CarSim 1.0", cc);

        m.addObserver(v);
    }
}
