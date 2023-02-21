import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
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

    public CarView(String title, CarController controller) {
        super(title);
        this.controller = controller;
        this.drawPanel = new DrawPanel(X, Y - 240);
        this.controlPanel = new JPanel();
        this.gasButton = new JButton("Gas");
        this.brakeButton = new JButton("Brake");
        this.startButton = new JButton("Start all cars");
        this.stopButton = new JButton("Stop all cars");
        this.turboOnButton = new JButton("Saab Turbo on");
        this.turboOffButton = new JButton("Saab Turbo off");
        this.liftBedButton = new JButton("Scania Lift Bed");
        this.lowerBedButton = new JButton("Lower Lift Bed");
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

        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(gasButton);
        controlPanel.add(turboOnButton);
        controlPanel.add(liftBedButton);
        controlPanel.add(brakeButton);
        controlPanel.add(turboOffButton);
        controlPanel.add(lowerBedButton);
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

    public void update() {
        drawPanel.repaint();
    }
    public void addCar(Vehicle car) {
        drawPanel.addCar(car);
    }


    public void updateCarPosition(int x, int y, int index) {
        drawPanel.updateCarPosition(x, y, index);
    }

}