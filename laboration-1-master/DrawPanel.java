import model.MotorizedVehicle;
import model.Saab95;
import model.Scania;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    // TODO: Make this general for all cars
    private final ArrayList<MotorizedVehicle> cars = new ArrayList<>();
    private final ArrayList<BufferedImage> images = new ArrayList<>();
    private final ArrayList<Point> positions = new ArrayList<>();

    public DrawPanel(int x, int y) {
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(x, y));
        setBackground(Color.darkGray);
    }

    public void addCar(MotorizedVehicle car) {
        if(cars.size() < 10) {
            cars.add(car);
            positions.add(new Point());
            try {
                if (car instanceof Scania) {
                    images.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("model/pics/Scania.jpg"))));
                } else if (car instanceof Saab95) {
                    images.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("model/pics/Saab95.jpg"))));
                } else {
                    images.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("model/pics/Volvo240.jpg"))));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void removeCar(){
        if(cars.size() > 0){
            images.remove(cars.size()-1);
            positions.remove(cars.size()-1);
            cars.remove(cars.size()-1);
        }
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Some fun map Graphics
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.orange);
        for(int i = 0; i < 4; i++){
        g2.fillRect(60 + i * 200, 280, 80, 20);
        }

        // Drawing the vehicles
        for(int i = 0; i < images.size(); i++){
            Point p = positions.get(i);
            g.drawImage(images.get(i), p.x, p.y , null);
        }
    }


    public void updateCarPosition(int x, int y, int index) {
        positions.set(index, new Point(x, y));
        repaint();
    }

}
