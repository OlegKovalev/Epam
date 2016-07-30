package se01;

public class FunctTable {

	private double step, left, right;

	FunctTable(double st, double a, double b){
		step = st;
		left = a;
		right = b;
	}

	public void go(){

		double tmp = Math.abs(left);

		System.out.println("    x  |  F(x)");
		System.out.println("   -----------");

		while(tmp <= right){

			System.out.printf("%6.1f |%6.2f%n", tmp, (Math.tan(2 * tmp)-3));
			tmp += step;
		}
	}

	public static void main(String[] args){
		new FunctTable(0.2,-7.4,10).go();
	}
}
