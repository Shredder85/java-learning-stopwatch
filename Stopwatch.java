//import javax.swing.*;

/**
 * Skapad av Erik Riklund 
 * VT23 �rebro Universitet
 * 
 * Denna klass �r sj�lva programmets k�rna och koordinerar alla funktioner.
 */

public class Stopwatch {
    
    // Anv�nds f�r att h�lla reda p� om timern �r ig�ng:
    public static boolean isRunning;
    
    // Lagrar instansen av v�rt f�nster:
    public static StopwatchFrame frame;
    
    // Lagrar instansen av v�r timer:
    public static StopwatchTimer timer;
    
    // Lagrar instansen av v�r display:
    public static StopwatchDisplay display;
    
    /*
     * H�r startar programmet och komponenter initieras.
     */
    
    public static void main(String[] args) {
        // Skapa f�nstret:
        frame = new StopwatchFrame();
        
        // Skapa timern:
        timer = new StopwatchTimer();
        
        // Skapa displayen:
        display = new StopwatchDisplay();
        
        // Ange att timern st�r stilla:
        Stopwatch.isRunning = false;
    }
    
    /*
     * Denna funktion kallas fr�n StopwatchTimerTask och uppdaterar timern,
     * b�de funktionsm�ssigt och displayen.
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
        
        // Ange att timern k�rs:
        Stopwatch.isRunning = true;
        
        // �ndra knapparnas "state":
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
        
        // Ange att timern st�r still:
        Stopwatch.isRunning = false;
        
        // �ndra knapparnas "state":
        frame.startButton.setEnabled(true);
        frame.stopButton.setEnabled(false);
        frame.resetButton.setEnabled(true);
    }
    
    /*
     * Nollst�ll timern.
     */
    
    public static void reset() {
        // Nollst�ll timer-funktionen:
        Stopwatch.timer.reset();
        
        // Nollst�ll displayen:
        frame.timer.setText("00:00.0");
        
        // �ndra knapparnas "state":
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
