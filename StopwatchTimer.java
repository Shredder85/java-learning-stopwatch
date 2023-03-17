
import java.util.Timer;

/**
 * Skapad av Erik Riklund 
 * VT23 Örebro Universitet
 * 
 * Denna klass hanterar själva timer-funktionen.
 */

public class StopwatchTimer
{
    // Lagrar vårt Timer-objekt:
    private Timer timer;
    
    // Lagrar våra TimerCounter-objekt:
    public StopwatchTimerCounter minutes;
    public StopwatchTimerCounter seconds;
    public StopwatchTimerCounter centiseconds;
    
    /*
     * Initierar timern och skapar våra counters.
     */
    
    public StopwatchTimer() {
        this.minutes = new StopwatchTimerCounter(999,null);
        this.seconds = new StopwatchTimerCounter(59,this.minutes);
        this.centiseconds = new StopwatchTimerCounter(999,this.seconds);
    }
    
    /*
     * Startar timern.
     */
    
    public void start() {
        // Skapa ett nytt Timer-objekt:
        this.timer = new Timer();
        
        // Starta en bakgrundstråd som uppdateras @100ms:
        this.timer.scheduleAtFixedRate(new StopwatchTimerTask(),0,100);
    }
    
    /*
     * Uppdaterar timern, triggas av StopwatchTimerTask ovan.
     */
    
    public void update() {
        // Kontrollera att timern är igång:
        if(Stopwatch.isRunning == true) {
            // Uppdatera och lägg på 100ms:
            this.centiseconds.increment(100);
        }
    }
    
    /*
     * Stoppar timern och avbryter bakgrundstråden.
     */
    
    public void stop() {
        this.timer.cancel();
    }
    
    /*
     * Nollställer alla counters.
     */
    
    public void reset() {
        this.minutes.reset();
        this.seconds.reset();
        this.centiseconds.reset();
    }
}
