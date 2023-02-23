import javax.swing.*;
import General.TurboEnabled;

import java.awt.*;
import java.util.ArrayList;

import Vehicles.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, the primary model holder
    ArrayList<Vehicle> cars = new ArrayList<>();

    // The delay (50 ms) corresponds to 20 updates a sec (hz)
    private final int delay = 16;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, e -> {
        for (Vehicle car : cars) {
            car.move();
            car.clampPosition(0, 800);
            frame.addDrawable(car);
            frame.refresh();
        }
    });

    public static void main(String[] args) { new CarController().init(); }

    void init() {
        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", this);

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

    void stopAllCars() {
        cars.forEach(car -> { car.stopEngine(); });
    }

    void startAllCars() {
        cars.forEach(car -> { car.startEngine(); });
    }
}
