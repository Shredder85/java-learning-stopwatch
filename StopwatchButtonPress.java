
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Skapad av Erik Riklund 
 * VT23 �rebro Universitet
 * 
 * Denna klass registrerar knapptryck och skickar detta till k�rnan.
 */

public class StopwatchButtonPress implements ActionListener
{
    
    // Lagrar namnet p� knappen:
    private String label;
    
    /*
     * Sparar namnet p� knappen.
     */
    
    public StopwatchButtonPress(String label) {
        this.label = label;
    }
    
    /*
     * Notifiera k�rnan om vilken knapptryck som registrerats:
     */
    
    public void actionPerformed(ActionEvent e) {
        Stopwatch.press(this.label);
    }
}
