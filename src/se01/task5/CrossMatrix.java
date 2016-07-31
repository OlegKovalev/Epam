package se01.task5;

public class CrossMatrix {
	public static void main(String[] args){
		int size = 10;

		for(int i=0; i < size; i++){
			for(int j=0; j < size; j++){
				if(i == j || j == size-i-1)
					System.out.print(1 + "\t");
				else
					System.out.print(0 + "\t");

			}
			System.out.println();
		}
	}
}
