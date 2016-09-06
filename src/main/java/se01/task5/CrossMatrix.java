package se01.task5;

public class CrossMatrix {

    private int sizeOfMatrix;

    public CrossMatrix(int sizeOfMatrix) {
        this.sizeOfMatrix = sizeOfMatrix;
    }

    public int[][] buildMatrix() {

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {

                if (i == j || j == sizeOfMatrix - i - 1) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }

            }
        }
        return matrix;
    }

    public void printMatrix(int[][] mtrx) {

        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx.length; j++) {

                System.out.print(mtrx[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
