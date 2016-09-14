package se02.task2_4.good;

import se02.task2_4.Stationery;
import se02.task2_4.good.property.Color;

public class Stapler extends Stationery {

    public Stapler(int cost, String manufacturer, Color color, int count) {

        super(cost, manufacturer, color, count);
    }

    @Override
    public String getName() {

        return "Stapler";
    }
}
