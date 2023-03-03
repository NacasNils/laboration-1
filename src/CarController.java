/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // The model part of the MVC pattern
    Model model;
    CarController(Model m) { model = m; }

    void gasAll(int amount) { model.gasAll(amount); }
    void brakeAll(int amount) { model.brakeAll(amount); }

    void turboOn() { model.turboOn(); }
    void turboOff() { model.turboOff(); }

    void stopAllCars() { model.stopAllCars(); }
    void startAllCars() { model.startAllCars(); }

    void raiseBed() { model.raiseBed(); }
    void lowerBed() { model.lowerBed(); }

    void addCar() { model.addCar(); }
    void removeCar() { model.removeCar(); }
}
