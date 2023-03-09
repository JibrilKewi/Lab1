package Control;

import java.util.function.Consumer;
import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's carModel in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class ControlPanel extends JPanel{
    private final List<ViewListener> listeners = new ArrayList<>();
    private int gasAmount = 0;
    private JButton gasButton;
    private JButton brakeButton;
    private JButton startButton;
    private JButton stopButton;
    private JButton turboOnButton;
    private JButton turboOffButton;
    private JButton liftBedButton;
    private JButton lowerBedButton;
    private JSpinner gasSpinner;
    private final int width;
    private final int height;

    public ControlPanel(int width, int height) {
        this.setSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        initComponents();
        addActionListeners();
    }

    private void initComponents() {
        JPanel buttonPanel = new JPanel();
        JPanel gasPanel = new JPanel();
        gasButton = new JButton("Gas");
        brakeButton = new JButton("Brake");
        turboOnButton = new JButton("Saab Turbo on");
        turboOffButton = new JButton("Saab Turbo off");
        liftBedButton = new JButton("Scania Lift Bed");
        lowerBedButton = new JButton("Lower Lift Bed");
        startButton = new JButton("Start Engine");
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        stopButton = new JButton("Stop Engine");
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        gasSpinner = new JSpinner();

        gasSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 5));
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(new JLabel("Amount of Gas"), BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        buttonPanel.setLayout(new GridLayout(2, 5));
        buttonPanel.setPreferredSize(new Dimension(width - gasPanel.getPreferredSize().width - 100, height-600));
        buttonPanel.add(gasButton, 0);
        buttonPanel.add(turboOnButton, 1);
        buttonPanel.add(liftBedButton, 2);
        buttonPanel.add(startButton, 3);
        buttonPanel.add(brakeButton, 4);
        buttonPanel.add(turboOffButton, 5);
        buttonPanel.add(lowerBedButton, 6);
        buttonPanel.add(stopButton, 7);

        this.add(gasPanel);
        this.add(buttonPanel);
    }

    private void addActionListeners() {
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());
        turboOnButton.addActionListener(e -> engageListeners(ViewListener::turboOnPerformed));
        turboOffButton.addActionListener(e -> engageListeners(ViewListener::turboOffPerformed));
        liftBedButton.addActionListener(e -> engageListeners(ViewListener::liftBedPerformed));
        lowerBedButton.addActionListener(e -> engageListeners(ViewListener::lowerBedPerformed));
        startButton.addActionListener(e -> engageListeners(ViewListener::startPerformed));
        stopButton.addActionListener(e -> engageListeners(ViewListener::stopPerformed));
        gasButton.addActionListener(e -> listeners.forEach(l -> l.gasPerformed(gasAmount)));
        brakeButton.addActionListener(e -> listeners.forEach(l -> l.brakePerformed(gasAmount)));
    }

    private void engageListeners(Consumer<ViewListener> consumer) {
        listeners.forEach(consumer);
    }

    public void addListener(ViewListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ViewListener listener) {
        listeners.remove(listener);
    }


}