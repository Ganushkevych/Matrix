public interface MatrixInterface {
    double getElement(int row, int column);
    double[] getRow(int row);
    double[] getColumn(int column);
    double[][] getNumbers();

    void print();

    void setElement(int row, int column, double element);
    void setRow(int row, double element);
    void setColumn(int column, double element);
    void fillByArray(double[][] numbers);
    void fillRandom();


    MatrixSize getSize();
    boolean equals(Object object);
    int hashCode();

    Matrix inverseMatrix();
}
