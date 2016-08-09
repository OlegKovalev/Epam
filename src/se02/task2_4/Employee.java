package se02.task2_4;

import java.util.ArrayList;
import java.util.Iterator;

public class Employee {

    private ArrayList<Stationery> stationers;

    public Employee() {

        this.stationers = new ArrayList<>();
    }

    public ArrayList<Stationery> getStationers() {
        ArrayList<Stationery> clone = new ArrayList<>();
        clone.addAll(stationers);
        return clone;
//        return new ArrayList<>(stationers);
//        return stationers;
    }

    public void setStationers(ArrayList<Stationery> stationers) {

        this.stationers = stationers;
    }


    public void addStationery(Stationery st) {

        stationers.add(st);
    }

    public void removeStatoinery(int index) {

        stationers.remove(index);
    }

    public int getCostOfStationers() {

        int fullCost = 0;

        for (Stationery stn : this.stationers) {
            fullCost += stn.getCost() * stn.getCount();
        }
        return fullCost;
    }

    public void printCollection() {

        Iterator iterator = this.getStationers().iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
