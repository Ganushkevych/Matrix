import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
    }
    @Test
    public void matrixGetElement(){
        Matrix matrix = new Matrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertEquals(matrix.getElement(0,1),2);
    }
    @Test
    public void matrixGetRow(){
        Matrix matrix = new Matrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertEquals(Arrays.toString(matrix.getRow(0)), Arrays.toString((new double[]{1, 2})));
    }
    @Test
    public void matrixGetColumn(){
        Matrix matrix = new Matrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertEquals(Arrays.toString(matrix.getColumn(1)), Arrays.toString((new double[]{2, 4})));
    }
    @Test
    public void matrixGetNumbers(){
        Matrix matrix = new Matrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertTrue(Arrays.deepEquals(matrix.getNumbers(), new double[][]{new double[]{1,2},new double[]{3,4}}));
    }
    @Test
    public void matrixGetSize(){
        Matrix matrix = new Matrix(5,6);
        assertEquals(matrix.getSize().numOfColumns(),6);
        assertEquals(matrix.getSize().numOfRows(),5);
    }
    @Test
    public void matrixEquals(){
        Matrix matrix = new Matrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        Matrix otherMatrix = new Matrix(2,2);
        otherMatrix.setRow(0, 1);
        otherMatrix.setColumn(1,2);
        otherMatrix.setElement(1,0,3);
        otherMatrix.setElement(1,1,4);
        assertTrue(matrix.equals(otherMatrix));
    }
    @Test
    public void matrixHashCode(){
        Matrix matrix = new Matrix(2,2);
        assertEquals(matrix.hashCode(),63488);
    }
    @Test
    public void matrixInverse(){
        Matrix matrix = new Matrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.inverseMatrix(),new Matrix(new double[][]{new double[]{-2,1},new double[]{1.5,-0.5}}));
    }
    @Test
    public void matrixSingle(){
        assertEquals(Matrix.singleMatrix(3),new Matrix(new double[][]{new double[]{1,0,0},new double[]{0,1,0},new double[]{0,0,1}}));
    }
}