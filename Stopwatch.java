//import javax.swing.*;

/**
 * Skapad av Erik Riklund 
 * VT23 Örebro Universitet
 * 
 * Denna klass är själva programmets kärna och koordinerar alla funktioner.
 */

public class Stopwatch {
    
    // Används för att hålla reda på om timern är igång:
    public static boolean isRunning;
    
    // Lagrar instansen av vårt fönster:
    public static StopwatchFrame frame;
    
    // Lagrar instansen av vår timer:
    public static StopwatchTimer timer;
    
    // Lagrar instansen av vår display:
    public static StopwatchDisplay display;
    
    /*
     * Här startar programmet och komponenter initieras.
     */
    
    public static void main(String[] args) {
        // Skapa fönstret:
        frame = new StopwatchFrame();
        
        // Skapa timern:
        timer = new StopwatchTimer();
        
        // Skapa displayen:
        display = new StopwatchDisplay();
        
        // Ange att timern står stilla:
        Stopwatch.isRunning = false;
    }
    
    /*
     * Denna funktion kallas från StopwatchTimerTask och uppdaterar timern,
     * både funktionsmässigt och displayen.
     */
    
    public static void update() {
        // Uppdaterar timer-funktionen:
        Stopwatch.timer.update();
        
        // Uppdaterar displayen:
        Stopwatch.frame.timer.setText(Stopwatch.display.getCurrentValue());
    }
    
    /*
     * Starta timern.
     */
    
    public static void start() {
        // Starta timer-funktionen:
        Stopwatch.timer.start();
        
        // Ange att timern körs:
        Stopwatch.isRunning = true;
        
        // Ändra knapparnas "state":
        frame.startButton.setEnabled(false);
        frame.stopButton.setEnabled(true);
        frame.resetButton.setEnabled(false);
    }
    
    /*
     * Stoppa timern.
     */
    
    public static void stop() {
        // Stoppa timer-funktionen:
        Stopwatch.timer.stop();
        
        // Ange att timern står still:
        Stopwatch.isRunning = false;
        
        // Ändra knapparnas "state":
        frame.startButton.setEnabled(true);
        frame.stopButton.setEnabled(false);
        frame.resetButton.setEnabled(true);
    }
    
    /*
     * Nollställ timern.
     */
    
    public static void reset() {
        // Nollställ timer-funktionen:
        Stopwatch.timer.reset();
        
        // Nollställ displayen:
        frame.timer.setText("00:00.0");
        
        // Ändra knapparnas "state":
        frame.startButton.setEnabled(true);
        frame.stopButton.setEnabled(false);
        frame.resetButton.setEnabled(false);
    }
    
    /*
     * Hantera ett rapporterat knapptryck.
     */
    
    public static void press(String button) {
        if(button == "Start") { Stopwatch.start(); }
        else if(button == "Stop") { Stopwatch.stop(); }
        else if(button == "Reset") { Stopwatch.reset(); }
    }
}
