package se02.task2_4.good;

import se02.task2_4.good.property.Color;
import se02.task2_4.Stationery;

public abstract class WritingAccessories extends Stationery {

    private String inkColor;

    public WritingAccessories(int cost, String manufacturer, Color color, int count, String inkColor) {
        super(cost, manufacturer, color, count);
        this.inkColor = inkColor;
    }

    public String getInkColor() {
        return inkColor;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + "cost: " + getCost() + ", manufacturer: " + getManufacturer() +
                ", color: " + getColor() + ", count: " + getCount() + ", ink color: " + getInkColor() + "\n";
    }
}
