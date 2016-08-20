package se04.task4;

public class Actor {

    private String name;
    private String surname;

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    @Override
    public String toString(){
        return name + " " + surname;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Actor pen = (Actor) obj;
        if (name != pen.name) {
            return false;
        }
        if (!surname.equals(pen.surname)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return 31 * name.hashCode() + ((null == surname) ? 0 : surname.hashCode());
    }
}
