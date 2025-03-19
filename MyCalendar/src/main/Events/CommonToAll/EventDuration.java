package main.Events.CommonToAll;

import java.util.Objects;

public class EventDuration {

    private int dureeMinutes;

    public EventDuration(int dureeMinutes) {
        if(dureeMinutes <= 0){
            throw new IllegalArgumentException("La durée en minutes doit être supérieure à 0");
        }
        this.dureeMinutes = dureeMinutes;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDuration that = (EventDuration) o;
        return dureeMinutes == that.dureeMinutes;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dureeMinutes);
    }


    @Override
    public String toString(){
        return String.valueOf(dureeMinutes);
    }


}
