package se02.task5;

public class Group<T extends Number> {


    private Subject subject;
    private T mark;


    public Group(Subject subject, T mark) {
        this.subject = subject;

        if(mark.getClass() != subject.getClassType()){
            throw new ClassCastException("Incorrect type of mark!");
        }
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public T getMark() {
        return mark;
    }

    @Override
    public String toString(){
        return subject.getNameOfSubject() + ": " + getMark();
    }
}
