import model.CarModel;

import javax.swing.*;
import java.awt.*;

public class VehicleView extends JPanel {
    private static final int X = 800;
    private static final int Y = 800;

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
        ControlPanel controlPanel = new ControlPanel(carModel, X, Y);
        AddRemoveController addRemoveController = new AddRemoveController(carModel, drawPanel);
        this.setLayout(new BorderLayout());
        this.add(drawPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.PAGE_END);
        this.add(addRemoveController.getAddRemovePanel(), BorderLayout.PAGE_START);
    }

    public void updateCarPosition(int x, int y, int index) {
        drawPanel.updateCarPosition(x, y, index);
    }
}