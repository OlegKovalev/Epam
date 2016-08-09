package se02.task2_4.goods;

import se02.task2_4.properties.Color;

public class Marker extends WritingAccessories {

    private String inkColor;

    public Marker(int cost, String manufacturer, Color color, int count, String inkColor) {

        super(cost, manufacturer, color, count, inkColor);
    }

    @Override
    public String getName() {
        return "Marker";
    }
}
