//written by Elijah Gallagher!!!
//all functions (as of right now) besides the isValid() method, assumes information given is valid

public class Matrix {
    private int rows, cols;
    private float[][] matrix;

    //constuctor for the matrix
    public Matrix(float[][] matrix) {
        this.cols = matrix[0].length;
        this.rows = matrix.length;
        this.matrix = matrix;
    }

    public int getCols() {
        return cols;
    }
    public int getRows() {
        return rows;
    }
    public float[][] getMatrix() {
        return matrix;
    }

    //checks if the matrix is valid by checking if all the rows have the same num of vals
    //call before contstructing
    public boolean isValid(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[0].length != matrix[i].length){
                return false;
            }
        }
        return true;
    }

    //swap function creates a copy of each row given, then swaps the value through a
        //for loop with the temp arrays
    public float[][] swap(int row1, int row2) {
        float[] temp1 = new float[this.getCols()];
        float[] temp2 = new float[this.getCols()];

        for (int i = 0; i < this.getCols(); i++) {
            temp1[i] = this.getMatrix()[row1 - 1][i];
            temp2[i] = this.getMatrix()[row2 - 1][i];
        }

        for (int i = 0; i < this.getCols(); i++) {
            this.getMatrix()[row1 - 1][i] = temp2[i];
            this.getMatrix()[row2 - 1][i] = temp1[i];
        }

        return this.getMatrix();
    }

    //multiplies a "row" of the matrix by a constant
    public float[][] multiply(float constant, int row) {
        for (int i = 0; i < this.getCols(); i++){
            this.getMatrix()[row - 1][i] = this.getMatrix()[row - 1][i] * constant;
        }
        
        return this.getMatrix();
    }

    //subtracts one row of matrix by the multiple 
    public float[][] multiplyByRow(float constant, int row1, int row2) {
        for (int i = 0; i < this.getCols(); i++) {
            this.getMatrix()[row2 - 1][i] = this.getMatrix()[row2 -1][i] - (this.getMatrix()[row1 -1][i] * constant);
        }

        return this.getMatrix();
    }

    //puts the matrix into ref form, checks if leading entry in the first row is 0, if so, exchange with second row
    ///after that, 
    public float[][] REF() {
        int curRow = 0;
        while (true) {
            if (this.getMatrix()[curRow][0] == 0) {
                swap(curRow, 2);
            }
            break;
        }

        return this.getMatrix();
    }

    @Override
    public String toString(){
        String string = "";
        for (int r = 0; r < this.getRows(); r++) {
            for (int c = 0; c < this.getCols(); c++) {
                string += this.getMatrix()[r][c] + " ";
            }
            string += "\n";
        }
        return string;
    }

    public static void main(String[] args) {
        //first [] is row, [][] is col
        float[][] m1 = {{1, 1, 1}, {2, 2, 2}};
        Matrix test = new Matrix(m1);
        System.out.println(test);
        
        test.multiply(3, 1);
        System.out.println("Multiplying row 1 by 3:\n" + test);
        
        test.swap(1, 2);
        System.out.println("Swapping row 1 and row 2:\n" + test);

        test.multiplyByRow(1, 1, 2);
        System.out.println("Subtracted row 2 from 1 * row 1:\n" + test);
    }
}