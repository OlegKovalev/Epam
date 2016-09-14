package se04.task4;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;

public class Film implements Serializable {

    private String title;
    private HashSet<Actor> actors;

    public Film(String title, Actor ... actors) {
        this.title = title;
        this.actors = new HashSet<Actor>(Arrays.asList(actors));
    }

    public String getTitle() {
        return title;
    }

    public HashSet<Actor> getActors() {
        return actors;
    }
    
    public void addActor(Actor actor) {
        actors.add(actor);
    }
}
