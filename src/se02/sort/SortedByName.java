package se02.sort;

import se02.Stationery;

import java.util.Comparator;

public class SortedByName implements Comparator<Stationery> {

    @Override
    public int compare(Stationery first, Stationery second) {

        String name1 = first.getClass().getSimpleName();
        String name2 = second.getClass().getSimpleName();

        return name1.compareTo(name2);
    }
}
