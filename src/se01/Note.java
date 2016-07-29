package se01;

public class Note {

	private int id;
	private String note;

	public Note(int id, String note){
		this.id = id;
		this.note = note;
	}

	public void setId(int i){
		id = i;
	}

	public int getId() {
		return id;
	}

	public void setNote(String nt) {
		note = nt;
	}

	public String getNote() {
		return note;
	}

	@Override
	public String toString(){
		return "id = " + id + " note = " + note;
	}

}
