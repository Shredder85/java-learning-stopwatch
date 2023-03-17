
import javax.swing.*;
import java.awt.*;

/**
 * Skapad av Erik Riklund 
 * VT23 Örebro Universitet
 * 
 * Denna klass hanterar användargränssnittet.
 */

public class StopwatchFrame extends JFrame {
    
    // Lagrar rutan där timerns text syns:
    public JTextArea timer;
    
    // Lagrar knapparna:
    public JButton startButton;
    public JButton stopButton;
    public JButton resetButton;
    
    /*
     * Initierar skapandet av gränssnittet.
     */
    
    public StopwatchFrame() {
        // Anropa JPanel's konstruktor för att ange fönstrets titel:
        super("Stopwatch");
        
        // Ange nödvändiga inställningar:
        this.setVisible(true);
        this.setSize(250,110);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Skapa komponenter:
        this.addTimer();
        this.addButtons();
    }
    
    /*
     * Hanterar skapandet av knapparna.
     */
    
    private void addButtons() {
        // Skapa en panel som ska hålla knapparna på plats:
        JPanel buttonHolder = new JPanel();
        
        // Skapa knapparna:
        this.startButton = this.addButton(buttonHolder,"Start",true);
        this.stopButton = this.addButton(buttonHolder,"Stop",false);
        this.resetButton = this.addButton(buttonHolder,"Reset",false);
        
        // Fäst panelen i vårt fönster:
        this.getContentPane().add(buttonHolder,BorderLayout.SOUTH);
    }
    
    /*
     * Hanterar skapandet av en knapp.
     */
    
    private JButton addButton(JPanel holder,String label,boolean isEnabled) {
        // Skapa en ny knapp:
        JButton button = new JButton(label);
        button.setEnabled(isEnabled);
        
        // Fäst en instans av vår hanterare för att registrera tryck:
        button.addActionListener(new StopwatchButtonPress(label));
        
        // Fäst knappen i vår panel:
        holder.add(button);
        
        return button;
    }
    
    /*
     * Skapar textområdet där timern syns.
     */
    
    private void addTimer() {
        // Skapa textområdet:
        this.timer = new JTextArea("00:00.0");
        
        // Ändra textens storlek:
        this.timer.setFont(this.timer.getFont().deriveFont(18f));
        
        // Ange att texten inte kan ändras av användaren:
        this.timer.setEditable(false);
        
        // Skapa en ny panel:
        JPanel timerArea = new JPanel();
        
        // Ändra bakgrundsfärgen:
        timerArea.setBackground(Color.white);
        
        // Fäst området i panelen:
        timerArea.add(this.timer);
        
        // Fäst panelen i vårt fönster:
        this.getContentPane().add(timerArea,BorderLayout.CENTER);
    }
}
