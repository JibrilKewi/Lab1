import model.CarModel;
import model.Vehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeListener implements ActionListener {

    private static CarModel model = new CarModel();

    private static final CarView view = new CarView("CarSim 2.0", model);


    public void actionPerformed(ActionEvent e) {
        model.updatePos();
        updateCars();
    }


    public static void updateCars() {
        view.repaint();
        for (Vehicle vehicle : model.getCars()) {
            int x = (int) Math.round(vehicle.getxPos());
            int y = (int) Math.round(vehicle.getyPos());
            int index = model.getCars().indexOf(vehicle);
            view.updateCarPosition(x, y, index);
        }
    }



}

