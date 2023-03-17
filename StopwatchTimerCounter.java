
/**
 * Skapad av Erik Riklund 
 * VT23 �rebro Universitet
 * 
 * Hanterar en typ av counter, t.ex. sekunder.
 */

class StopwatchTimerCounter
{
    // Lagrar det aktuella v�rdet:
    private int value;
    
    // Gr�nsen f�r nollst�llning:
    private int limit;
    
    // Lagrar ett parent-objekt, om s�dant finns:
    private StopwatchTimerCounter parent;
    
    /*
     * Initierar r�knaren och lagrar de angivna parametrarna.
     */
    
    public StopwatchTimerCounter(int rollover, StopwatchTimerCounter parent) {
        this.limit = rollover;
        this.parent = parent;
    }
    
    /*
     * Returnerar det nuvarande v�rdet.
     */
    
    public int getValue() {
        return this.value;
    }
    
    /*
     * Hanterar �kning av v�rdet.
     */
    
    public void increment(int value) {
        // �ka nuvarande v�rdet med det angivna v�rdet:
        this.value += value;
        
        // Om v�rdet �verstiger rollover-limit ska det nollst�llas:
        if(this.value >= this.limit) {
            this.rollover();
        }
    }
    
    /*
     * Hanterar en rollover d� gr�nsen uppn�tts.
     */
    
    public void rollover() {
        // Nollst�ll v�rdet:
        this.reset();
        
        // Om en parent finns, �ka p� v�rdet f�r denna:
        if(this.parent != null) {
            this.parent.increment(1);
        }
    }
    
    /*
     * Nollst�ller v�rdet.
     */
    
    public void reset() {
        this.value = 0;
    }
}
