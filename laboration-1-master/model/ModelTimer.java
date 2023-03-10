package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class ModelTimer implements ActionListener {
    private final World nvm;
    private final Timer timer;

    public ModelTimer(World nvm) {
        this.timer = new Timer();
        this.nvm = nvm;
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                actionPerformed(null);
            }
        }, 10, 5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nvm.moveVehicles();
    }

}
