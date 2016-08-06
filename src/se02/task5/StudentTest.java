package se02.task5;

public class StudentTest {

    /*Subject subject = new Subject();

    Group[] group = new Group[5];
    group[0] = new Group(Subject.MATH, 4.6);*/

    public static void main(String[] args){


        Student student1 = new Student("First student");
//        student1.addSubject(new Group(Subject.MATH, 4.6), new Group(Subject.ENGLISH, 3.7));
        student1.addSubject(new Group(Subject.ENGLISH, 3.8));
        student1.addSubject(new Group(Subject.GEOGRAPHY, 4));


    }

}
