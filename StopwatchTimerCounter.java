
/**
 * Skapad av Erik Riklund 
 * VT23 Örebro Universitet
 * 
 * Hanterar en typ av counter, t.ex. sekunder.
 */

class StopwatchTimerCounter
{
    // Lagrar det aktuella värdet:
    private int value;
    
    // Gränsen för nollställning:
    private int limit;
    
    // Lagrar ett parent-objekt, om sådant finns:
    private StopwatchTimerCounter parent;
    
    /*
     * Initierar räknaren och lagrar de angivna parametrarna.
     */
    
    public StopwatchTimerCounter(int rollover, StopwatchTimerCounter parent) {
        this.limit = rollover;
        this.parent = parent;
    }
    
    /*
     * Returnerar det nuvarande värdet.
     */
    
    public int getValue() {
        return this.value;
    }
    
    /*
     * Hanterar ökning av värdet.
     */
    
    public void increment(int value) {
        // Öka nuvarande värdet med det angivna värdet:
        this.value += value;
        
        // Om värdet överstiger rollover-limit ska det nollställas:
        if(this.value >= this.limit) {
            this.rollover();
        }
    }
    
    /*
     * Hanterar en rollover då gränsen uppnåtts.
     */
    
    public void rollover() {
        // Nollställ värdet:
        this.reset();
        
        // Om en parent finns, öka på värdet för denna:
        if(this.parent != null) {
            this.parent.increment(1);
        }
    }
    
    /*
     * Nollställer värdet.
     */
    
    public void reset() {
        this.value = 0;
    }
}
