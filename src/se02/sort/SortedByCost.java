package se02.sort;

import se02.Stationery;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class SortedByCost implements Comparator<Stationery> {

    @Override
    public int compare(Stationery first, Stationery second) {

        int cost1 = first.getCost();
        int cost2 = second.getCost();

        if (cost1 > cost2) {
            return 1;
        } else if (cost1 < cost2) {
            return -1;
        } else {
            return 0;
        }
    }
}
