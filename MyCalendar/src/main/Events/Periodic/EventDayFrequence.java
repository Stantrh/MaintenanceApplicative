package main.Events.Periodic;

/**
 * Uniquement pour périodique
 */
public class EventDayFrequence {

    private int dayFrequence;

    public EventDayFrequence(int dayFrequence) {
        if(dayFrequence <= 0){
            throw new IllegalArgumentException("Frequence de jours doit être supérieure à 0");
        }
        this.dayFrequence = dayFrequence;
    }

    public int getDayFrequence() {
        return dayFrequence;
    }

    @Override
    public String toString() {
        return String.valueOf(dayFrequence);
    }

}
