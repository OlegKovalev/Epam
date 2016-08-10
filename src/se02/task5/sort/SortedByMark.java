package se02.task5.sort;

import se02.task5.Group;

import java.util.Comparator;

public class SortedByMark implements Comparator<Group> {

    @Override
    public int compare(Group first, Group second){

        double mark1 = compareValues(first.getMark());
        double mark2 = compareValues(first.getMark());

        if (mark1 > mark2) {
            return 1;
        } else if (mark1 < mark2) {
            return -1;
        } else {
            return 0;
        }
    }

    public double compareValues(Number number){
        if(number.getClass() == Double.class){
            return number.doubleValue();
        } else {
            if(number.getClass() == Integer.class){
                return (double) number.intValue();
            } else {
                throw new TypeNotPresentException("Incorrect type of mark!", new Throwable());
            }
        }

    }
}
