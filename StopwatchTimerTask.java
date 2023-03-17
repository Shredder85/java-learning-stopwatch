
import java.util.TimerTask;

/**
 * Skapad av Erik Riklund 
 * VT23 Örebro Universitet
 * 
 * Denna klass hanterar bakgrundsuppdateringen av timern.
 */

public class StopwatchTimerTask extends TimerTask
{
    /*
     * Skickar en uppdatering till kärnan vid varje aktivering.
     */
    
    public void run() {
        Stopwatch.update();
    }
}
