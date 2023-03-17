
import javax.swing.*;
import java.awt.*;

/**
 * Skapad av Erik Riklund 
 * VT23 �rebro Universitet
 * 
 * Denna klass hanterar anv�ndargr�nssnittet.
 */

public class StopwatchFrame extends JFrame {
    
    // Lagrar rutan d�r timerns text syns:
    public JTextArea timer;
    
    // Lagrar knapparna:
    public JButton startButton;
    public JButton stopButton;
    public JButton resetButton;
    
    /*
     * Initierar skapandet av gr�nssnittet.
     */
    
    public StopwatchFrame() {
        // Anropa JPanel's konstruktor f�r att ange f�nstrets titel:
        super("Stopwatch");
        
        // Ange n�dv�ndiga inst�llningar:
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
        // Skapa en panel som ska h�lla knapparna p� plats:
        JPanel buttonHolder = new JPanel();
        
        // Skapa knapparna:
        this.startButton = this.addButton(buttonHolder,"Start",true);
        this.stopButton = this.addButton(buttonHolder,"Stop",false);
        this.resetButton = this.addButton(buttonHolder,"Reset",false);
        
        // F�st panelen i v�rt f�nster:
        this.getContentPane().add(buttonHolder,BorderLayout.SOUTH);
    }
    
    /*
     * Hanterar skapandet av en knapp.
     */
    
    private JButton addButton(JPanel holder,String label,boolean isEnabled) {
        // Skapa en ny knapp:
        JButton button = new JButton(label);
        button.setEnabled(isEnabled);
        
        // F�st en instans av v�r hanterare f�r att registrera tryck:
        button.addActionListener(new StopwatchButtonPress(label));
        
        // F�st knappen i v�r panel:
        holder.add(button);
        
        return button;
    }
    
    /*
     * Skapar textomr�det d�r timern syns.
     */
    
    private void addTimer() {
        // Skapa textomr�det:
        this.timer = new JTextArea("00:00.0");
        
        // �ndra textens storlek:
        this.timer.setFont(this.timer.getFont().deriveFont(18f));
        
        // Ange att texten inte kan �ndras av anv�ndaren:
        this.timer.setEditable(false);
        
        // Skapa en ny panel:
        JPanel timerArea = new JPanel();
        
        // �ndra bakgrundsf�rgen:
        timerArea.setBackground(Color.white);
        
        // F�st omr�det i panelen:
        timerArea.add(this.timer);
        
        // F�st panelen i v�rt f�nster:
        this.getContentPane().add(timerArea,BorderLayout.CENTER);
    }
}
