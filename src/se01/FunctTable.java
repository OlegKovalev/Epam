package se01;

public class FunctTable {

	private double step, left, right;

	FunctTable(double st, double a, double b){
		step = st;
		left = a;
		right = b;
	}

	public void go(){
		for(double x=left; x <= right; x += step){
			System.out.printf("%5.1f%10.2f%n", x, (Math.tan(2*x)-3));
		}
	}

	public static void main(String[] args){
		new FunctTable(0.2,-7.4,10).go();
	}
}
