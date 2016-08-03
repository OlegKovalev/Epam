package se02.good;

import se02.Color;
import se02.Stationery;

public class Marker extends Stationery {

	public Marker(int cost, String manufacturer, Color color, int count) {
		super(cost, manufacturer, color, count);
	}

	@Override
	public String getName() {
		return "Marker";
	}
}
