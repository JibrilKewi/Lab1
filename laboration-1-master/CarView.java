import javax.swing.*;

import java.awt.*;
import java.util.Random;
/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's carModel in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{

    private static final int X = 800;
    private static final int Y = 800;
    private CarModel carModel;
    private DrawPanel drawPanel;
    private JPanel controlPanel;
    private JButton gasButton;
    private JButton brakeButton;
    private JButton startButton;
    private JButton stopButton;
    private JButton turboOnButton;
    private JButton turboOffButton;
    private JButton liftBedButton;
    private JButton lowerBedButton;
    private JSpinner gasSpinner;
    private JButton addSaabButton;
    private JButton addScaniaButton;
    private JButton addVolvoButton;
    private JButton removeButton;


    public CarView(String title, CarModel carModel) {
        super(title);
        this.carModel = carModel;
        this.drawPanel = new DrawPanel(X, Y - 240);
        this.controlPanel = new JPanel();
        this.gasButton = new JButton("Gas");
        this.brakeButton = new JButton("Brake");
        this.startButton = new JButton("Start all cars");
        this.stopButton = new JButton("Stop all cars");
        this.turboOnButton = new JButton("Turbo-on");
        this.turboOffButton = new JButton("Turbo-off");
        this.liftBedButton = new JButton("Lift");
        this.lowerBedButton = new JButton("Lower");
        this.addSaabButton = new JButton("Saab");
        this.addScaniaButton = new JButton("Scania");
        this.addVolvoButton = new JButton("Volvo");
        this.removeButton = new JButton("Remove");
        this.gasSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        initComponents();
        addActionListeners();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(X, Y));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        add(drawPanel);

        controlPanel.setLayout(new GridLayout(3, 4));
        controlPanel.add(gasButton);
        controlPanel.add(brakeButton);
        controlPanel.add(turboOnButton);
        controlPanel.add(turboOffButton);

        controlPanel.add(liftBedButton);
        controlPanel.add(lowerBedButton);
        controlPanel.add(addSaabButton);
        controlPanel.add(addScaniaButton);

        controlPanel.add(addVolvoButton);
        controlPanel.add(removeButton);


        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        controlPanel.setBackground(Color.CYAN);
        add(controlPanel);

        JPanel gasPanel = new JPanel();
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(new JLabel("Amount of gas"), BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        add(gasPanel);

        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        add(startButton);

        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        add(stopButton);

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addActionListeners(){
        gasButton.addActionListener(e -> carModel.gas((int) gasSpinner.getValue()));
        startButton.addActionListener(e -> carModel.startEngine());
        stopButton.addActionListener(e -> carModel.stopEngine());
        turboOnButton.addActionListener(e -> carModel.turboOn());
        turboOffButton.addActionListener(e -> carModel.turboOff());
        liftBedButton.addActionListener(e -> carModel.liftBed());
        lowerBedButton.addActionListener(e -> carModel.lowerBed());

        removeButton.addActionListener(e -> removeCar());
        addSaabButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.SAAB95)));
        addScaniaButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.SCANIA)));
        addVolvoButton.addActionListener(e -> addCar(VehicleFactory.addVehicle(VehicleType.VOLVO240)));
    }

    public void addCar(Vehicle car) {
        drawPanel.addCar(car);
        carModel.addCar(car);
    }

    public void removeCar(){
        drawPanel.removeCar();
        carModel.removeCar();
    }


    public void updateCarPosition(int x, int y, int index) {
        drawPanel.updateCarPosition(x, y, index);
    }

}