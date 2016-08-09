package se01.task4;

public class MaxOfArray {

	public double maxOfSum(double[] arr){

		double maxValue = Double.MIN_VALUE;
		int lengthOfArray = arr.length;

		for(int i=0; i < lengthOfArray/2; i++){
			if(arr[i] + arr[lengthOfArray-i-1] > maxValue){
				maxValue = arr[i] + arr[lengthOfArray-i-1];
			}
		}
		return maxValue;
	}

	public static void main(String[] args){

		double[] array = {2.3,1.0,7.5,4.8,1.2,4.9};

		System.out.println(new MaxOfArray().maxOfSum(array));
	}
}
