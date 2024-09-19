package com.mycompany.irrigationsystem;
import java.util.Timer;
import java.util.TimerTask;

public class IrrigationSystem {

    private boolean isSystemOn;
    private int duration; // Duration in seconds
    private Timer timer;

    // Constructor
    public IrrigationSystem(int duration) {
        this.duration = duration; // Duration of watering in seconds
        this.isSystemOn = false;
        this.timer = new Timer();
    }

    // Method to start irrigation
    public void startIrrigation() {
        if (!isSystemOn) {
            isSystemOn = true;
            System.out.println("Irrigation system started.");
            
            // Schedule the system to stop after the specified duration
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    stopIrrigation();
                }
            }, duration * 1000); // convert to milliseconds
        } else {
            System.out.println("Irrigation system is already running.");
        }
    }

    // Method to stop irrigation
    public void stopIrrigation() {
        if (isSystemOn) {
            isSystemOn = false;
            System.out.println("Irrigation system stopped.");
        } else {
            System.out.println("Irrigation system is not running.");
        }
    }

    // Schedule the irrigation at intervals (e.g., every 6 hours)
    public void scheduleIrrigation(int intervalInHours) {
        long interval = intervalInHours * 60 * 60 * 1000; // convert hours to milliseconds
        Timer irrigationScheduler = new Timer();

        irrigationScheduler.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                startIrrigation();
            }
        }, 0, interval);
    }

    public static void main(String[] args) {
        // Example: Start watering for 10 seconds and repeat every 6 hours
        int wateringDuration = 15; // Duration in seconds
        int wateringInterval = 5; // Interval in hours

        IrrigationSystem system = new IrrigationSystem(wateringDuration);
        system.scheduleIrrigation(wateringInterval);
    }
}

        
    

