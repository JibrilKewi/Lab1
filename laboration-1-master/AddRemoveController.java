import model.CarModel;
import model.MotorizedVehicle;
import model.VehicleFactory;
import model.VehicleType;
import javax.swing.*;
import java.awt.*;

public class AddRemoveController {
    private DrawPanel drawPanel;
    private CarModel carModel;
    private JPanel addRemovePanel;

    public AddRemoveController(CarModel carModel, DrawPanel drawPanel){
        this.drawPanel = drawPanel;
        this.carModel = carModel;
        initComponents();
    }

    public JPanel getAddRemovePanel(){
        return addRemovePanel;
    }

    private void initComponents() {
        addRemovePanel = new JPanel();
        addRemovePanel.setPreferredSize(new Dimension(40,140));
        JButton addSaabButton = new JButton("Add Saab");
        JButton addVolvoButton = new JButton("Add Volvo");
        JButton addScaniaButton = new JButton("Add Scania");
        JButton removeButton = new JButton("Remove vehicle");
        removeButton.addActionListener(e -> removeCar());
        addSaabButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.SAAB95)));
        addScaniaButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.SCANIA)));
        addVolvoButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.VOLVO240)));


        addRemovePanel.setLayout(new GridLayout(2,2));
        addRemovePanel.add(addSaabButton);
        addRemovePanel.add(addVolvoButton);
        addRemovePanel.add(addScaniaButton);
        addRemovePanel.add(removeButton);
    }

    public void addCar(MotorizedVehicle car) {
        drawPanel.addCar(car);
        carModel.addCar(car);
    }

    public void removeCar(){
        drawPanel.removeCar();
        carModel.removeCar();
    }
}
