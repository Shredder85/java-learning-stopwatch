
import java.util.Timer;

/**
 * Skapad av Erik Riklund 
 * VT23 �rebro Universitet
 * 
 * Denna klass hanterar sj�lva timer-funktionen.
 */

public class StopwatchTimer
{
    // Lagrar v�rt Timer-objekt:
    private Timer timer;
    
    // Lagrar v�ra TimerCounter-objekt:
    public StopwatchTimerCounter minutes;
    public StopwatchTimerCounter seconds;
    public StopwatchTimerCounter centiseconds;
    
    /*
     * Initierar timern och skapar v�ra counters.
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
        
        // Starta en bakgrundstr�d som uppdateras @100ms:
        this.timer.scheduleAtFixedRate(new StopwatchTimerTask(),0,100);
    }
    
    /*
     * Uppdaterar timern, triggas av StopwatchTimerTask ovan.
     */
    
    public void update() {
        // Kontrollera att timern �r ig�ng:
        if(Stopwatch.isRunning == true) {
            // Uppdatera och l�gg p� 100ms:
            this.centiseconds.increment(100);
        }
    }
    
    /*
     * Stoppar timern och avbryter bakgrundstr�den.
     */
    
    public void stop() {
        this.timer.cancel();
    }
    
    /*
     * Nollst�ller alla counters.
     */
    
    public void reset() {
        this.minutes.reset();
        this.seconds.reset();
        this.centiseconds.reset();
    }
}
