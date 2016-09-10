package main.java.se01.task6;

public class Note {

    private int id;
    private String note;

    public Note(int id, String note) {
        this.id = id;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String nt) {
        note = nt;
    }

    @Override
    public String toString() {
        return "id = " + id + " note = " + note;
    }

}
