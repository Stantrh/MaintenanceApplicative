package main.Events.Meeting;

import java.util.ArrayList;

public class ListeParticipants extends ArrayList<String> {


    @Override
    public String toString(){
        return String.join(", ", this);
    }

}
