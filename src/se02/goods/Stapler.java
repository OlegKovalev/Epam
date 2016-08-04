package se02.goods;

import se02.Color;
import se02.Stationery;

public class Stapler extends Stationery {

    public Stapler(int cost, String manufacturer, Color color, int count) {

        super(cost, manufacturer, color, count);
    }

    @Override
    public String getName() {

        return "Stapler";
    }
}
