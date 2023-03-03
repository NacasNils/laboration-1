import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import General.TurboEnabled;
import Vehicles.*;

public class Model {
    private Random random = new Random();
    private ArrayList<Vehicle> cars = new ArrayList<>();

    // A list of observers observing the state of the model
    private ArrayList<SimulationObserver> obs = new ArrayList<>();

    // The delay (50 ms) corresponds to 20 updates a sec (hz)
    private final int delay = 16;

    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, e -> {
        for (Vehicle car : cars) {
            car.move();
            car.clampPosition(0, CarView.X);
            for (SimulationObserver ob : obs) ob.queueDraw(car);
        }
        for (SimulationObserver ob : obs) ob.refreshState();
    });

    public void addObserver(CarView v) { obs.add(v); }
    public void removeObserver(CarView v) { obs.remove(v); }

    public Model() {
        cars.add(new Volvo240(Color.BLACK));
        cars.add(new Scania(Color.RED));
        cars.add(new Saab95(Color.GRAY));

        // Start the timer
        timer.start();
    }


    void gasAll(int amount) { cars.forEach(car -> car.gas((double) amount/100)); }

    void brakeAll(int amount) { cars.forEach(car -> car.brake((double) amount/100)); }

    void turboOn() {
        cars.forEach(car -> {if (car instanceof TurboEnabled) ((TurboEnabled) car).setTurboOn();});
    }

    void turboOff() {
        cars.forEach(car -> {if (car instanceof TurboEnabled) ((TurboEnabled) car).setTurboOff();});
    }

    void stopAllCars() { cars.forEach(car -> { car.stopEngine(); }); }
    void startAllCars() { cars.forEach(car -> { car.startEngine(); }); }

    void raiseBed() { cars.forEach(car -> {if (car instanceof Truck)  ((Truck) car).raiseBed();});}
    void lowerBed() { cars.forEach(car -> {if (car instanceof Truck)  ((Truck) car).lowerBed();});}

    void addCar() {
        Vehicle[] haystack = new Vehicle[] {
                new Saab95(Color.RED),
                new Volvo240(Color.RED),
                new Scania(Color.RED),
                new Zis150(Color.BLACK)
        };
        int x = random.nextInt(4);
        cars.add(haystack[x]);
    }

    void removeCar() {
        int x = random.nextInt(cars.size());
        cars.remove(x);
    }
}
