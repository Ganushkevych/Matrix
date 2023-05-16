import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Matrix implements MatrixInterface{
    private final int rows;
    private final int columns;
    private double[][] numbers;
    public Matrix() {
        this.rows = 0;
        this.columns = 0;
    }
    public Matrix(int rows, int columns) {
        if(rows<=0||columns<=0) throw new WrongParametersException("Numbers of rows and columns should be positive");
        this.rows = rows;
        this.columns = columns;
        this.numbers = new double[rows][columns];
    }

    public Matrix(double[][] numbers) {
        if(numbers==null) throw new WrongParametersException("Array of numbers should not be null");
        this.rows = numbers.length;
        this.columns = numbers[0].length;
        if(columns==0) throw new WrongParametersException("Numbers of rows and columns should be positive");
        this.numbers = numbers;
    }

    public Matrix(Matrix matrix) {
        this.rows = matrix.rows;
        this.columns = matrix.columns;
        this.numbers = matrix.numbers;
    }


    @Override
    public double getElement(int row, int column){
        if(row<0||column<0||row>rows||column>columns) throw new WrongParametersException("Numbers of rows and columns should be positive");
        return numbers[row][column];
    }
    @Override
    public double[] getRow(int row){
        if(row<0||row>rows) throw new WrongParametersException("Numbers of rows and columns should be positive");
        return numbers[row];
    }
    @Override
    public double[] getColumn(int column){
        if(column<0||column>columns) throw new WrongParametersException("Numbers of rows and columns should be positive");
        double[] columnArray = new double[rows];
        for (int i = 0; i < rows; i++) {
            columnArray[i] = numbers[i][column];
        }
        return columnArray;
    }
    @Override
    public double[][] getNumbers(){
        return numbers;
    }

    @Override
    public void print(){
        for(double[] row:numbers) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Override
    public void setElement(int row, int column, double element) {
        if(row<0||column<0||row>rows||column>columns) throw new WrongParametersException("Numbers of rows and columns should be positive");
        this.numbers[row][column] = element;
    }

    @Override
    public void setRow(int row, double element) {
        if(row<0||row>rows) throw new WrongParametersException("Numbers of rows and columns should be positive");
        for(int i=0;i<columns;i++) {
            this.setElement(row, i, element);
        }
    }

    @Override
    public void setColumn(int column, double element) {
        if(column<0||column>columns) throw new WrongParametersException("Numbers of rows and columns should be positive");
        for(int i=0;i<rows;i++) {
            this.setElement(i, column, element);
        }
    }
    @Override
    public void fillByArray(double[][] numbers){
        if(numbers==null) throw new WrongParametersException("Array of numbers should not be null");
        if(!(this.numbers.length == numbers.length && this.numbers[0].length == numbers[0].length)) throw new WrongParametersException("Array of numbers should be same size as matrix");
        this.numbers = numbers;
    }

    @Override
    public void fillRandom(){
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                numbers[i][j] = random.nextDouble();
            }
        }
    }
    @Override
    public MatrixSize getSize(){
        return new MatrixSize(this.rows,this.columns);
    }

    @Override
    public boolean equals(Object obj) {
        Matrix someMatrix = (Matrix) obj;
        if (this == obj) return true;
        else if (this.rows!=someMatrix.rows||this.columns!= someMatrix.columns) return false;
        else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if(numbers[i][j]!=someMatrix.numbers[i][j]) return false;
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns, Arrays.deepHashCode(numbers));
    }
    public static Matrix singleMatrix(int size){
        if(size<=0) throw new WrongParametersException("Size should be positive");
        double[][] numbers = new double[size][size];
        Arrays.stream(numbers).forEach(a -> Arrays.fill(a, 0));
        for (int i = 0; i < size; i++) {
            numbers[i][i] = 1;
        }
        return new Matrix(numbers);
    }

    private Matrix submatrix(int excludedRow, int excludedColumn) {
        double[][] newNumbers = new double[rows - 1][columns - 1];
        int currentRow = 0;
        for (int i = 0; i < rows; i++) {
            if (i != excludedRow) {
                int currentColumn = 0;
                for (int j = 0; j < columns; j++) {
                    if (j != excludedColumn) {
                        newNumbers[currentRow][currentColumn] = numbers[i][j];
                        currentColumn++;
                    }
                }
                currentRow++;
            }
        }
        return new Matrix(newNumbers);
    }
    private Matrix additionalMatrix() {
        if (this.rows != this.columns) {
            throw new UnsupportedParametersException("Additional matrix can only be calculated for square matrix");
        }
        double[][] additionalMatrixNumbers = new double[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                Matrix submatrix = this.submatrix(i, j);
                additionalMatrixNumbers[j][i] = Math.pow(-1, i + j) * submatrix.determinant();
            }
        }
        return new Matrix(additionalMatrixNumbers);
    }

    private double determinant() {
        if (this.rows != this.columns) {
            throw new UnsupportedParametersException("Determinant can only be calculated for square matrix");
        }
        if (this.rows == 1) {
            return this.getElement(0, 0);
        }
        else if (this.rows == 2) {
            return this.getElement(0, 0) * this.getElement(1, 1) - this.getElement(0, 1) * this.getElement(1, 0);
        }
        else {
            double determinant = 0;
            for (int i = 0; i < this.columns; i++) {
                Matrix submatrix = this.submatrix(0, i);
                System.out.println(determinant);
                determinant += Math.pow(-1, i) * this.getElement(0, i) * submatrix.determinant();
            }
            System.out.println(determinant);
            return determinant;
        }
    }

    public Matrix inverseMatrix() {
        if (this.rows != this.columns) throw new UnsupportedParametersException("Inverse can only be calculated for square matrix");
        double determinant = this.determinant();
        if (determinant == 0) throw new UnsupportedParametersException("Matrix isn't invertible");
        Matrix additionalMatrix = this.additionalMatrix();
        double[][] inverseMatrixNumbers = new double[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                inverseMatrixNumbers[i][j] = (double) Math.round(additionalMatrix.getElement(i, j) / determinant * 100) /100;
            }
        }
        return new Matrix(inverseMatrixNumbers);
    }
}
