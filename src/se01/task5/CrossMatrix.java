package se01.task5;

public class CrossMatrix {

	private int sizeOfMatrix;

	public CrossMatrix(int sizeOfMatrix) {
		this.sizeOfMatrix = sizeOfMatrix;
	}

	public int[][] buildMatrix() {

		int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

		for(int i=0; i < sizeOfMatrix; i++){
			for(int j=0; j < sizeOfMatrix; j++){

				if(i == j || j == sizeOfMatrix-i-1){
					matrix[i][j] = 1;
				}
				else{
					matrix[i][j] = 0;
				}

			}
		}
		return matrix;
	}

	public void printMatrix(int[][] mtrx){

		for(int i=0; i < mtrx.length; i++){
			for(int j=0; j < mtrx.length; j++){



			}
		}
	}


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
