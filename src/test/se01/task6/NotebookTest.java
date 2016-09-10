package se01.task6;

import main.java.se01.task6.Notebook;
import org.junit.Before;



public class NotebookTest {

    private Notebook nb;

    @Before
    public void setUp() throws Exception {

        nb = new Notebook(10);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }


    @org.junit.Test
    public void testAddNote() throws Exception {
        nb = new Notebook(10);

/*		nb.addNote("first string");
        nb.addNote("second string");
		nb.addNote("third string");

//
		assertSame("id = " + 0 + " note = " + 0", nb.viewNote(0).toString());*/

        for (int i = 0; i < 12; i++) {
            nb.addNote(Integer.toString(i));
        }

        nb.viewNote(2);

//		assertSame("id = " + 2 + " note = " + 2+"",nb.viewNote(2));
//		assertEquals(40, nb.getCountOfElements());
//		assertEquals(12, nb.getCountOfNonEmptyCell());

    }


    @org.junit.Test
    public void testRemoveNote() throws Exception {

//		nb.removeNote(2);

    }

    @org.junit.Test
    public void testEditNote() throws Exception {

    }

    @org.junit.Test
    public void testViewAll() throws Exception {

    }

    @org.junit.Test
    public void testFirstEmpty() throws Exception {

    }

    @org.junit.Test
    public void testExpandArray() throws Exception {

    }
}
