import java.awt.Color;

/**
 * test to prove static error with workshop and wrong type of vehicle
 */
public class main {
    public static void main(String[] args) {
        new main().program();        
    }


    /**
     * the test in question
     */
    void program() {
        Workshop<Saab95> shop = new Workshop<>(0);
        Saab95 car = new Saab95(Color.BLACK);
        
        shop.parkVehicle(car);
    }
}
