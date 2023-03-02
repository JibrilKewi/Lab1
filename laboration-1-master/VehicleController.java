import model.CarModel;
import model.Vehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleController implements ActionListener {

    private static CarModel model;
    private static VehicleView view;

    public VehicleController(CarModel model, VehicleView view) {
        VehicleController.model = model;
        VehicleController.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        model.updatePos();
        updateCars();
    }

    public static void updateCars() {
        view.repaint();
        for (Vehicle vehicle : model.getVehicles()) {
            int x = (int) Math.round(vehicle.getxPos());
            int y = (int) Math.round(vehicle.getyPos());
            int index = model.getVehicles().indexOf(vehicle);
            view.updateCarPosition(x, y, index);
        }
    }

}

