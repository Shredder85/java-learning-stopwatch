
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Skapad av Erik Riklund 
 * VT23 Örebro Universitet
 * 
 * Denna klass registrerar knapptryck och skickar detta till kärnan.
 */

public class StopwatchButtonPress implements ActionListener
{
    
    // Lagrar namnet på knappen:
    private String label;
    
    /*
     * Sparar namnet på knappen.
     */
    
    public StopwatchButtonPress(String label) {
        this.label = label;
    }
    
    /*
     * Notifiera kärnan om vilken knapptryck som registrerats:
     */
    
    public void actionPerformed(ActionEvent e) {
        Stopwatch.press(this.label);
    }
}
