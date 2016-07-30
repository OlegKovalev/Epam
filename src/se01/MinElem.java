package se01;

import java.util.Locale;
import java.util.Scanner;

public class MinElem {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		//без локали точка в разделителе не работает
		sc.useLocale(new Locale("US"));


		System.out.println("Insert number: ");
		new MinElem().go(sc.nextDouble());

	}

	public void go(double num){

		if(num > 1){
			System.out.println("Number should be less than 1.");
			System.exit(0);
		}
		double a;

		for(int i=0;;i++){
			a = 1/Math.pow(i + 1, 2);

			if(a < num){
				System.out.println("Index of min element: " + i);
				break;
			}
			System.out.println(a);
		}
	}
}


/*
Insert number:
0.01
1.0
0.25
0.1111111111111111
0.0625
0.04
0.027777777777777776
0.02040816326530612
0.015625
0.012345679012345678
0.01
Index of min element: 10
*/
