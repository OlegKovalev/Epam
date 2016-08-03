package se02.task1;

public class Pen {

	private int price;
	private String manufacturer;

	public Pen(int price, String manufacturer) {
		this.price = price;
		this.manufacturer = manufacturer;
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

		Pen pen = (Pen) obj;
		if (price != pen.price) {
			return false;
		}
		if (null == manufacturer){
			return (manufacturer == pen.manufacturer);
		} else {
			if (!manufacturer.equals(pen.manufacturer)) {
				return false;
			}
		}

		return true;
	}

	public int hashCode() {
		return 31 * price + ((null == manufacturer) ? 0 : manufacturer.hashCode());
	}

	public String toString() {
		return getClass().getName() + "@" + "price: " + price + ", manufacturer: " + manufacturer;
	}

}
