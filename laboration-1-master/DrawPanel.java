import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize

    ArrayList<BufferedImage> images = new ArrayList<>();
    BufferedImage saabImage;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    // To keep track of a singel cars position


    ArrayList<Point> positions = new ArrayList<>();

    // TODO: Make this general for all cars

    void moveit(int x, int y, int index){
        if(index >= 0 && index < images.size()){
            positions.set(index, new Point(x, y));
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            images.add(saabImage);
            images.add(scaniaImage);
            images.add(volvoImage);
            positions.add(new Point());
            positions.add(new Point());
            positions.add(new Point());

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

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

}
