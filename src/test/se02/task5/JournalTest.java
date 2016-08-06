package se02.task5;

import org.junit.*;

public class JournalTest {

    Journal journal;
    @Before
    public void setUp() throws Exception {
        journal = new Journal(
                new Student("student1", new Group(Subject.ENGLISH, 4.2), new Group(Subject.GEOGRAPHY, 3)),
                new Student("student2", new Group(Subject.HISTORY, 4), new Group(Subject.GEOGRAPHY, 4)),
                new Student("student3", new Group(Subject.MATH, 4.7), new Group(Subject.HISTORY, 5),
                        new Group(Subject.GEOGRAPHY, 4), new Group(Subject.ENGLISH, 4.4)),
                new Student("student4", new Group(Subject.MATH, 3.4), new Group(Subject.ENGLISH, 3.6)),
                new Student("student5", new Group(Subject.ENGLISH, 4.2), new Group(Subject.GEOGRAPHY, 3))
        );
    }

    @Test
    public void getStudents() throws Exception {

    }

    @Test
    public void getGroups() throws Exception {
        System.out.println(journal.getGroups("student1"));
    }

    @Test
    public void printStudents() throws Exception {

    }

}