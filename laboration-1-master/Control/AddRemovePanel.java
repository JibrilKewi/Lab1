package Control;

import View.*;
import model.*;

import javax.swing.*;
import java.awt.*;

public class AddRemovePanel {
    private final DrawPanel drawPanel;
    private final CarModel carModel;
    private JPanel addRemovePanel;

    public AddRemovePanel(CarModel carModel, DrawPanel drawPanel){
        this.drawPanel = drawPanel;
        this.carModel = carModel;
        initComponents();
    }

    public JPanel getAddRemovePanel(){
        return addRemovePanel;
    }

    private void initComponents() {
        // Panel init
        addRemovePanel = new JPanel();
        addRemovePanel.setPreferredSize(new Dimension(40,140));

        // Button init
        JButton addSaabButton = new JButton("Add Saab");
        JButton addVolvoButton = new JButton("Add Volvo");
        JButton addScaniaButton = new JButton("Add Scania");
        JButton removeButton = new JButton("Remove vehicle");

        // Action listeners
        removeButton.addActionListener(e -> removeCar());
        addSaabButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.SAAB95)));
        addScaniaButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.SCANIA)));
        addVolvoButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.VOLVO240)));

        // Panel setup
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
