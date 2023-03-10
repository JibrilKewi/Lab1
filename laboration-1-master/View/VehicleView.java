package View;

import Control.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VehicleView extends JPanel implements WorldListener {
    private static final int X = 800;
    private static final int Y = 800;

    private ControlPanel controlPanel;

    private DrawPanel drawPanel;
    private World v;

    // Constructor
    public VehicleView(World v) {
        this.v = v;
        initComponents();
    }

    // Sets everything in place and fits everything
    private void initComponents() {
        drawPanel = new DrawPanel(X, Y - 240);
        this.controlPanel = new ControlPanel(X, Y);
        AddRemovePanel addRemovePanel = new AddRemovePanel(v, drawPanel);
        this.setLayout(new BorderLayout());
        this.add(drawPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.PAGE_END);
        this.add(addRemovePanel.getAddRemovePanel(), BorderLayout.PAGE_START);
    }

    public void addControlListener(ViewListener listener) {
        controlPanel.addListener(listener);
    }


    @Override
    public void actOnChange(List<MotorizedVehicle> vehicles) {
        drawPanel.actOnChange(vehicles);
    }
}