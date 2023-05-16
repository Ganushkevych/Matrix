public final class ImmutableMatrix extends Matrix implements MatrixInterface{
    private final MatrixInterface matrix;

    public ImmutableMatrix(Matrix matrix) {
        this.matrix = new ImmutableMatrix(matrix.getNumbers());
    }
    public ImmutableMatrix(int rows, int columns){
        this.matrix = new Matrix(rows,columns);
    }
    public ImmutableMatrix(double[][] numbers){
        this.matrix = new Matrix(numbers);
    }

    public ImmutableMatrix() {
        this.matrix = new Matrix();
    }

    @Override
    public double getElement(int row, int column){
        return matrix.getElement(row,column);
    }
    @Override
    public double[] getRow(int row){
        return matrix.getRow(row);
    }
    @Override
    public double[] getColumn(int column){
        return matrix.getColumn(column);
    }
    @Override
    public double[][] getNumbers(){
        return matrix.getNumbers();
    }
    @Override
    public void print(){
        matrix.print();
    }
    @Override
    public void setElement(int row, int column, double element){
        throw new ImmutableMatrixException("It's Immutable Matrix");
    }
    @Override
    public void setRow(int row, double element){
        throw new ImmutableMatrixException("It's Immutable Matrix");
    }
    @Override
    public void setColumn(int column, double element){
        throw new ImmutableMatrixException("It's Immutable Matrix");
    }
    @Override
    public void fillByArray(double[][] numbers){
        throw new ImmutableMatrixException("It's Immutable Matrix");
    }
    @Override
    public void fillRandom(){
        throw new ImmutableMatrixException("It's Immutable Matrix");
    }

    @Override
    public MatrixSize getSize(){
        return matrix.getSize();
    }
    @Override
    public boolean equals(Object object){
        return matrix.equals(object);
    }
    @Override
    public int hashCode(){
        return matrix.hashCode();
    }
    @Override
    public Matrix inverseMatrix(){
        return matrix.inverseMatrix();
    }
}
