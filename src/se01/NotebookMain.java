package se01;

public class NotebookMain {

	public static void main(String[] args){

		Notebook nb = new Notebook(3);

		for(int i=0; i < 8; i++){
			nb.addNote("Note " + i);
		}

		for(Note note : nb.viewAll()){
			System.out.println(note);
		}

		System.out.println("--------------------");

		nb.removeNote(4);
		nb.removeNote(5);
		nb.removeNote(6);

		for(Note note : nb.viewAll()){
			System.out.println(note);
		}

		System.out.println("--------------------");

		System.out.println(nb.viewNote(5));

		System.out.println("--------------------");

		nb.editNote(1, "modified string");

		System.out.println(nb.viewNote(1));
	}
}
