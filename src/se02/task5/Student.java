package se02.task5;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String name;
    private ArrayList<Group> groups;

    public Student(String name){
        this(name, new ArrayList<>());
    }

    public Student(String name, ArrayList<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public Student(String name, Group ... groups) {
        this(name, new ArrayList<>(Arrays.asList(groups)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString(){
        return name + ":\n" + groups;
    }
}
