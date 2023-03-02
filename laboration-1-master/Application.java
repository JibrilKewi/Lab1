import model.CarModel;
import javax.swing.*;
public class Application {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Carsim");
        CarModel carModel = new CarModel();
        VehicleView view = new VehicleView(carModel);
        VehicleController vc = new VehicleController(carModel, view);
        frame.add(view);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Timer(50, vc).start();
    }
}