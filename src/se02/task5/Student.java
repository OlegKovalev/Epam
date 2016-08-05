package se02.task5;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String nameOfStudent;
    private ArrayList<Group> groups;

    public Student(String name){
        this(name, new ArrayList<>());
    }

    public Student(String nameOfStudent, ArrayList<Group> groups) {
        this.nameOfStudent = nameOfStudent;
        this.groups = groups;
    }

    public Student(String nameOfStudent, Group ... groups) {
        this(nameOfStudent, new ArrayList<Group>(Arrays.asList(groups)));
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public void addSubject(Group subject){
        if(!groups.contains(subject)) {
            groups.add(subject);
        }
    }
}
