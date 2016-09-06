package se02.task5;

import se02.task5.sort.SortedByMark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Journal {

    private ArrayList<Student> students;

    public Journal() {
        students = new ArrayList<>();
    }

    public Journal(ArrayList<Student> students) {
        this.students = students;
    }

    public Journal(Student... students) {
        this(new ArrayList<>(Arrays.asList(students)));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Group> getGroups(String nameOfStudent) {
        for (Student student : students) {
            if (student.getName().equals(nameOfStudent)) {
                return student.getGroups();
            }
        }
        return new ArrayList<>();
    }

    public ArrayList<Group> getSortedGroups(String name) {
        ArrayList<Group> temp = this.getGroups(name);
        Collections.sort(temp, new SortedByMark());
        return temp;
    }

    public void printStudents() {
        this.students.forEach(System.out::println);
    }
}
