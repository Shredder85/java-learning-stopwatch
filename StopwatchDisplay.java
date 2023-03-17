
/**
 * Skapad av Erik Riklund 
 * VT23 �rebro Universitet
 * 
 * Denna klass hanterar inneh�llet i displayrutan.
 */

class StopwatchDisplay
{
    /*
     * Genererar och returnerar det nuvarande v�rde som ska visas.
     */
    
    public String getCurrentValue() {
        String currentValue = 
            this.formatValue(Stopwatch.timer.minutes.getValue(),false) + ":"
            + this.formatValue(Stopwatch.timer.seconds.getValue(),false) + "."
            + this.formatValue((Stopwatch.timer.centiseconds.getValue()/10),true);
        
        return currentValue;
    }
    
    /*
     * Formaterar ett nummer innan det presenteras.
     */
    
    private String formatValue(int value,boolean trim) {
        // L�gg till en nolla innan om det beh�vs:
        String currentValue = ((value < 10) ? "0" : "") + value;
        
        // Ta bort sista nollan om det angetts:
        if(trim == true) {
            currentValue = currentValue.substring(0,currentValue.length()-1);
        }
        
        return currentValue;
    }
}
