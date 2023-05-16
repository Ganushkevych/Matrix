import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {
    @Test
    public void emptyMatrixCreation(){
        Matrix matrix = new Matrix();
        assertEquals(matrix.getSize().numOfColumns(),0);
        assertEquals(matrix.getSize().numOfRows(),0);
        assertNull(matrix.getNumbers());
    }
    @Test
    public void matrixCreationBySize(){
        Matrix matrix = new Matrix(2,3);
        assertEquals(matrix.getSize().numOfColumns(),3);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{0,0,0},new double[]{0,0,0}});
    }
    @Test
    public void matrixCreationByNumbers(){
        Matrix matrix = new Matrix(new double[][]{new double[]{1,2,3},new double[]{-1,-2,-3}});
        assertEquals(matrix.getSize().numOfColumns(),3);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2,3},new double[]{-1,-2,-3}});
    }
    @Test
    public void matrixCreationByMatrix(){
        Matrix matrix = new Matrix(new Matrix(new double[][]{new double[]{1,2,3},new double[]{-1,-2,-3}}));
        assertEquals(matrix.getSize().numOfColumns(),3);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2,3},new double[]{-1,-2,-3}});
    }
    @Test
    public void matrixFillOneElement(){
        Matrix matrix = new Matrix(2,2);
        matrix.setElement(0,0,1);
        matrix.setElement(0,1,2);
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2},new double[]{0,0}});
    }
    @Test
    public void matrixFillRow(){
        Matrix matrix = new Matrix(2,2);
        matrix.setRow(0,1);
        matrix.setRow(1,2);
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,1},new double[]{2,2}});
    }
    @Test
    public void matrixFillColumn(){
        Matrix matrix = new Matrix(2,2);
        matrix.setColumn(0,1);
        matrix.setColumn(1,2);
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2},new double[]{1,2}});
    }
    @Test
    public void matrixFillByArray(){
        Matrix matrix = new Matrix(2,2);
        matrix.fillByArray(new double[][]{new double[]{1,2},new double[]{1,2}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2},new double[]{1,2}});
    }
    @Test
    public void matrixFillRandom(){
        Matrix matrix = new Matrix(2,2);
        matrix.fillRandom();
        matrix.print();
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
    }
}