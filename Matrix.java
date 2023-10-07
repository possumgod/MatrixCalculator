//written by Elijah Gallagher!!!
//has all computation methods, interface will be another file

public class Matrix{
    private int rows, cols;
    private float[][] matrix;

    //constuctor for the matrix
    public Matrix(float[][] matrix){
        this.cols = matrix.length;
        this.rows = matrix[0].length;
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
    public boolean isValid(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            if (matrix[0].length != matrix[i].length){
                return false;
            }
        }
        return true;
    }

    public float[][] swap(int constant, int row){
        return this.getMatrix();
    }

    public float[][] multiply(int constant, int row){
        for (int i = 0; i < getCols(); i++){
            this.getMatrix()[i][row - 1] = this.getMatrix()[i][row - 1] * constant;
        }
        
        return this.getMatrix();
    }

    @Override
    public String toString(){
        String string = "";
        for (int i = 0; i < getCols(); i++){
            for (int j = 0; j < getRows(); j++){
                string += this.matrix[j][i] + " ";
            }
            string += "\n";
        }
        return string;
    }

    public static void main(String[] args) {
        float[][] m1 = {{1, 1}, {2, 2}};
        Matrix test = new Matrix(m1);
        System.out.println(test);
        test.multiply(2, 1);
        System.out.println(test);
    }
}