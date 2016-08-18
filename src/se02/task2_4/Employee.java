package se02.task2_4;

import se02.task2_4.exception.InvalidValue;

import java.util.ArrayList;
import java.util.Iterator;

public class Employee {

    private ArrayList<Stationery> stationers;

    public Employee() {
        this.stationers = new ArrayList<>();
    }

    public ArrayList<Stationery> getStationers() {
        return stationers;
    }

    public void setStationers(ArrayList<Stationery> stationers) {

        this.stationers = stationers;
    }


    public void addStationery(Stationery st) {
        stationers.add(st);
    }

    public void removeStatoinery(int index) throws InvalidValue {
        if (index < 0 || index > stationers.size() - 1) {
            throw new InvalidValue();
        } else {
            stationers.remove(index);
        }
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
