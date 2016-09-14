package se02.task2_4.good;

import se02.task2_4.good.property.Color;

public class Pen extends WritingAccessories {

    private String inkColor;

    public Pen(int cost, String manufacturer, Color color, int count, String inkColor) {

        super(cost, manufacturer, color, count, inkColor);
    }


    @Override
    public String getName() {
        return "Pen";
    }
}
