package se02.task2_4.goods;

import se02.task2_4.Color;
import se02.task2_4.Stationery;

public class Pencil extends WritingAccessories {

    private String inkColor;

    public Pencil(int cost, String manufacturer, Color color, int count, String inkColor) {

        super(cost, manufacturer, color, count, inkColor);
    }

    @Override
    public String getName() {

        return "Pencil";
    }
}
