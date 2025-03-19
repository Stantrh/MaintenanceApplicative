package main.Events.CommonToAll;

import java.util.Objects;

public class EventOwner {

    private String owner;

    public EventOwner(String owner){
        this.owner = owner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventOwner eventOwner1 = (EventOwner) o;
        return Objects.equals(owner, eventOwner1.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(owner);
    }
}
