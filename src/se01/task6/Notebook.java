package se01.task6;

public class Notebook {

	private Note[] notes;
	private static final int DEFAULT_CAPACITY = 30;

	public Notebook(int capacity){
		notes = new Note[capacity];
	}

	public Notebook(){
		this(DEFAULT_CAPACITY);
	}

	public void addNote(String note){

		int indexOfFirstEmptyInArray = firstEmpty();

		if(indexOfFirstEmptyInArray == -1){
			expandArray();
		}
		notes[indexOfFirstEmptyInArray] = new Note(indexOfFirstEmptyInArray, note);
	}

	public void removeNote(int id){

		Note[] tmp = new Note[notes.length];

		if(id > notes.length) new ArrayIndexOutOfBoundsException();
		int index = 0;

		if(notes[0] == null) index = 1;

		//Сдвиг элементов после удаления
		for(int i=0; i < tmp.length-1; i++){
			if(index == id){
				index++;
			}
			if(notes[index] != null){
				tmp[i] = notes[index];
				tmp[i].setId(i);
				index++;
			}
		}
		notes = tmp;
	}

	public void editNote(int id, String note){
		notes[id].setNote(note);
	}

	public Note[] viewAll(){

		int index=0;

		Note[] tempNote = new Note[getCountOfNonEmptyCell()];

		for(int i=0; i < notes.length; i++){
			if(notes[i] != null){
				tempNote[index] = notes[i];
				index++;
			}
		}
		return tempNote;
	}

	public Note viewNote(int ind){

		if(ind > notes.length){
			new ArrayIndexOutOfBoundsException();
		}
		return notes[ind];
	}

	public int firstEmpty(){

		if(notes.length==0){
			return -1;
		}
		else {
			for(int i=0; i < notes.length; i++){
				if(notes[i]==null){
					return i;
				}
			}
		}
		return -1;
	}

	public void expandArray(){

		Note[] tmp = new Note[notes.length+30];

		System.arraycopy(notes, 0, tmp, 0, notes.length);
		notes = tmp;
	}

	public int getCountOfNonEmptyCell(){

		int count=0;

		for(int i=0; i < notes.length; i++){
			if((notes[i]) != null){
				count++;
			}
		}
		return count;
	}

//	Used to JUnit
/*	public int getCountOfElements(){
		return notes.length;
	}*/
}
