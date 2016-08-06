package se02.task2_4.goods;

import se02.task2_4.Color;
import se02.task2_4.Stationery;

public class Pen extends Stationery {

	public Pen(int cost, String manufacturer, Color color, int count) {

		super(cost, manufacturer, color, count);
	}


	@Override
	public String getName() {
		return "Pen";
	}
}
