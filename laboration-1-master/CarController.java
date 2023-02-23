import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    private final int delay = 50;
    private final Timer timer = new Timer(delay, new TimerListener());
    private static final CarModel model = new CarModel();
    private static final CarView view = new CarView("CarSim 2.0", model);

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.updateCars();
            updateCars();
            }
        }


    public static void updateCars(){
        view.repaint();
        for(Vehicle vehicle : model.getCars()){
            int x = (int) Math.round(vehicle.getxPos());
            int y = (int) Math.round(vehicle.getyPos());
            int index = model.getCars().indexOf(vehicle);
            view.updateCarPosition(x, y, index);
        }
    }

    public void start() {
        timer.start();
    }

}

