import javax.swing.*;

import java.awt.*;
import java.util.Random;
/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    Random rand = new Random();
    private static final int X = 800;
    private static final int Y = 800;

    private CarController controller;
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


    public CarView(String title, CarController controller) {
        super(title);
        this.controller = controller;
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
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(X, Y));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        add(drawPanel);

        gasButton.addActionListener(e -> controller.gas((int) gasSpinner.getValue()));
        startButton.addActionListener(e -> controller.startEngine());
        stopButton.addActionListener(e -> controller.stopEngine());
        turboOnButton.addActionListener(e -> controller.turboOn());
        turboOffButton.addActionListener(e -> controller.turboOff());
        liftBedButton.addActionListener(e -> controller.liftBed());
        lowerBedButton.addActionListener(e -> controller.lowerBed());

        removeButton.addActionListener(e -> controller.removeCar());
        addSaabButton.addActionListener(e -> controller.addCar(new Saab95(rand.nextInt(700), rand.nextInt(400), Direction.EAST)));
        addScaniaButton.addActionListener(e -> controller.addCar(new Scania(rand.nextInt(700), rand.nextInt(400), Direction.EAST)));
        addVolvoButton.addActionListener(e -> controller.addCar(new Volvo240(rand.nextInt(700), rand.nextInt(400), Direction.EAST)));


        controlPanel.setLayout(new GridLayout(3, 4));
        controlPanel.add(gasButton);
        controlPanel.add(turboOnButton);
        controlPanel.add(liftBedButton);
        controlPanel.add(brakeButton);
        controlPanel.add(turboOffButton);
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

    public void addCar(Vehicle car) {
        drawPanel.addCar(car);
    }

    public void removeCar(){
        drawPanel.removeCar();
    }


    public void updateCarPosition(int x, int y, int index) {
        drawPanel.updateCarPosition(x, y, index);
    }

}