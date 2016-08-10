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
        System.out.println("----------------------------");
        System.out.println("student1: \n"+ journal.getGroups("student1"));
        System.out.println("student3: \n"+ journal.getGroups("student3"));

    }

    @Test
    public void printStudents() throws Exception {
        System.out.println("----------------------------");
        journal.printStudents();

    }

    @Test
    public void getSortedGroups(){
        System.out.println("----------------------------");
        System.out.println("student3 after sort: \n" + journal.getSortedGroups("student3"));
    }

}

/*
        ----------------------------
        student1:
        [English: 4.2, Geography: 3]
        student3:
        [Math: 4.7, History: 5, Geography: 4, English: 4.4]
        ----------------------------
        student1:
        [English: 4.2, Geography: 3]
        student2:
        [History: 4, Geography: 4]
        student3:
        [Math: 4.7, History: 5, Geography: 4, English: 4.4]
        student4:
        [Math: 3.4, English: 3.6]
        student5:
        [English: 4.2, Geography: 3]
        ----------------------------
        student3 after sort:
        [Geography: 4, English: 4.4, Math: 4.7, History: 5]
*/
