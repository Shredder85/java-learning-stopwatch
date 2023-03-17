
import java.util.TimerTask;

/**
 * Skapad av Erik Riklund 
 * VT23 �rebro Universitet
 * 
 * Denna klass hanterar bakgrundsuppdateringen av timern.
 */

public class StopwatchTimerTask extends TimerTask
{
    /*
     * Skickar en uppdatering till k�rnan vid varje aktivering.
     */
    
    public void run() {
        Stopwatch.update();
    }
}
