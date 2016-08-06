package se02.task2_4.goods;

import se02.task2_4.Color;
import se02.task2_4.Stationery;

public class Stapler extends Stationery {

    public Stapler(int cost, String manufacturer, Color color, int count) {

        super(cost, manufacturer, color, count);
    }

    @Override
    public String getName() {

        return "Stapler";
    }
}
