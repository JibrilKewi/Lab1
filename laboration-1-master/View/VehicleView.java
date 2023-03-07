package View;

import Control.*;
import model.*;

import javax.swing.*;
import java.awt.*;

public class VehicleView extends JPanel {
    private static final int X = 800;
    private static final int Y = 800;

    private ControlPanel controlPanel;

    private DrawPanel drawPanel;
    private final CarModel carModel;

    // Constructor
    public VehicleView(CarModel carModel) {
        this.carModel = carModel;
        initComponents();
    }

    // Sets everything in place and fits everything
    private void initComponents() {
        drawPanel = new DrawPanel(X, Y - 240);
        this.controlPanel = new ControlPanel(X, Y);
        AddRemovePanel addRemovePanel = new AddRemovePanel(carModel, drawPanel);
        this.setLayout(new BorderLayout());
        this.add(drawPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.PAGE_END);
        this.add(addRemovePanel.getAddRemovePanel(), BorderLayout.PAGE_START);
    }

    public void addControlListener(ViewListener listener) {
        controlPanel.addListener(listener);
    }

    public void updateCarPosition(int x, int y, int index) {
        drawPanel.updateCarPosition(x, y, index);
    }
}