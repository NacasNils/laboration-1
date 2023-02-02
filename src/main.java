import java.awt.Color;

public class main {
    public static void main(String[] args) {
        new main().program();        
    }

    void program() {
        Workshop<Saab95> shop = new Workshop<>(0);
        Saab95 car = new Saab95(Color.BLACK);
        
        shop.parkVehicle(car);
    }
}
