package se02;

public abstract class Stationery {

	private int cost;
	private String manufacturer;
	private Color color;
	private int count;

	public Stationery() {
		this(0, "none", Color.BLACK, 0);
	}

	public Stationery(int cost, String manufacturer, Color color, int count) {
		this.cost = cost;
		this.manufacturer = manufacturer;
		this.color = color;
		this.count = count;
	}

	protected abstract String getName();

	public int getCost() {

		return cost;
	}

	public void setCost(int cost) {

		this.cost = cost;
	}

	public String getManufacturer() {

		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {

		this.manufacturer = manufacturer;
	}

	public Color getColor() {

		return color;
	}

	public void setColor(Color color) {

		this.color = color;
	}

	public int getCount() {

		return count;
	}

	public void setCount(int count) {

		this.count = count;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Stationery stationery = (Stationery) obj;
		if (cost != stationery.cost) {
			return false;
		}

		if (null == manufacturer){
			return (manufacturer == stationery.manufacturer);
		} else {
			if (!manufacturer.equals(stationery.manufacturer)) {
				return false;
			}
		}

		return true;
	}

	public int hashCode() {
		return 31 * cost + ((null == manufacturer) ? 0 : manufacturer.hashCode());
	}

	public String toString() {
		return getName() + ": " + "cost: " + getCost() + ", manufacturer: " + getManufacturer() +
				", color: " + getColor() + ", count: " + getCount() + "\n";
	}

}
