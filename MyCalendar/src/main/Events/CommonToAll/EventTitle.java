package main.Events.CommonToAll;

import java.util.Objects;

public class EventTitle {

    private final String title;

    public EventTitle(String titre) {
        if (titre == null || titre.trim().isEmpty()) {
            throw new IllegalArgumentException("Title has to be not empty");
        }
        this.title = titre;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTitle that = (EventTitle) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

     @Override
     public String toString() {
         return title;
     }
}




