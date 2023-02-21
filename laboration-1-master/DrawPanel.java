import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    // TODO: Make this general for all cars
    private ArrayList<Vehicle> cars = new ArrayList<>();
    private ArrayList<BufferedImage> images = new ArrayList<>();
    private ArrayList<Point> positions = new ArrayList<>();

    public DrawPanel(int x, int y) {
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(x, y));
        setBackground(Color.blue);

        try {
            images.add(ImageIO.read(getClass().getResourceAsStream("pics/Saab95.jpg")));
            images.add(ImageIO.read(getClass().getResourceAsStream("pics/Scania.jpg")));
            images.add(ImageIO.read(getClass().getResourceAsStream("pics/Volvo240.jpg")));
            positions.add(new Point());
            positions.add(new Point());
            positions.add(new Point());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addCar(Vehicle car) {
        cars.add(car);
        positions.add(new Point());
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < images.size(); i++){
            Point p = positions.get(i);
            g.drawImage(images.get(i), p.x, p.y + i*100, null);
        }


    }

    public void updateCarPosition(int x, int y, int index) {
       positions.set(index, new Point(x, y));
        repaint();
    }

}
