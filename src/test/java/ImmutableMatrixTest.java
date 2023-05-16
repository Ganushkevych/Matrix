import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableMatrixTest {
    @Test
    public void emptyMatrixCreation(){
        ImmutableMatrix matrix = new ImmutableMatrix();
        assertEquals(matrix.getSize().numOfColumns(),0);
        assertEquals(matrix.getSize().numOfRows(),0);
        assertNull(matrix.getNumbers());
    }
    @Test
    public void matrixCreationBySize(){
        ImmutableMatrix matrix = new ImmutableMatrix(2,3);
        assertEquals(matrix.getSize().numOfColumns(),3);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{0,0,0},new double[]{0,0,0}});
    }
    @Test
    public void matrixCreationByNumbers(){
        ImmutableMatrix matrix = new ImmutableMatrix(new double[][]{new double[]{1,2,3},new double[]{-1,-2,-3}});
        assertEquals(matrix.getSize().numOfColumns(),3);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2,3},new double[]{-1,-2,-3}});
    }
    @Test
    public void matrixCreationByMatrix(){
        ImmutableMatrix matrix = new ImmutableMatrix(new Matrix(new double[][]{new double[]{1,2,3},new double[]{-1,-2,-3}}));
        assertEquals(matrix.getSize().numOfColumns(),3);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2,3},new double[]{-1,-2,-3}});
    }
    @Test
    public void matrixFillOneElement(){
        ImmutableMatrix matrix = new ImmutableMatrix(2,2);
        try{
            matrix.setElement(0,0,1);
            matrix.setElement(0,1,2);
            assertEquals(matrix.getSize().numOfColumns(),2);
            assertEquals(matrix.getSize().numOfRows(),2);
            assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2},new double[]{0,0}});
            fail();
        }catch(ImmutableMatrixException ignored){}

    }
    @Test
    public void matrixFillRow(){
        ImmutableMatrix matrix = new ImmutableMatrix(2,2);
        try{
            matrix.setRow(0,1);
            matrix.setRow(1,2);
            assertEquals(matrix.getSize().numOfColumns(),2);
            assertEquals(matrix.getSize().numOfRows(),2);
            assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,1},new double[]{2,2}});
            fail();
        }catch(ImmutableMatrixException ignored){}

    }
    @Test
    public void matrixFillColumn(){
        ImmutableMatrix matrix = new ImmutableMatrix(2,2);
        try{
            matrix.setColumn(0,1);
            matrix.setColumn(1,2);
            assertEquals(matrix.getSize().numOfColumns(),2);
            assertEquals(matrix.getSize().numOfRows(),2);
            assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2},new double[]{1,2}});
            fail();
        }catch(ImmutableMatrixException ignored){}

    }
    @Test
    public void matrixFillByArray(){
        ImmutableMatrix matrix = new ImmutableMatrix(2,2);
        try{
            matrix.fillByArray(new double[][]{new double[]{1,2},new double[]{1,2}});
            assertEquals(matrix.getSize().numOfColumns(),2);
            assertEquals(matrix.getSize().numOfRows(),2);
            assertArrayEquals(matrix.getNumbers(), new double[][]{new double[]{1,2},new double[]{1,2}});
            fail();
        }catch(ImmutableMatrixException ignored){}

    }
    @Test
    public void matrixFillRandom(){
        ImmutableMatrix matrix = new ImmutableMatrix(2,2);
        try{
            matrix.fillRandom();
            fail();
        }catch(ImmutableMatrixException ignored){}
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
    }
    @Test
    public void matrixGetElement(){
        ImmutableMatrix matrix = new ImmutableMatrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertEquals(matrix.getElement(0,1),2);
    }
    @Test
    public void matrixGetRow(){
        ImmutableMatrix matrix = new ImmutableMatrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertEquals(Arrays.toString(matrix.getRow(0)), Arrays.toString((new double[]{1, 2})));
    }
    @Test
    public void matrixGetColumn(){
        ImmutableMatrix matrix = new ImmutableMatrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertEquals(Arrays.toString(matrix.getColumn(1)), Arrays.toString((new double[]{2, 4})));
    }
    @Test
    public void matrixGetNumbers(){
        ImmutableMatrix matrix = new ImmutableMatrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.getSize().numOfColumns(),2);
        assertEquals(matrix.getSize().numOfRows(),2);
        assertTrue(Arrays.deepEquals(matrix.getNumbers(), new double[][]{new double[]{1,2},new double[]{3,4}}));
    }
    @Test
    public void matrixGetSize(){
        ImmutableMatrix matrix = new ImmutableMatrix(5,6);
        assertEquals(matrix.getSize().numOfColumns(),6);
        assertEquals(matrix.getSize().numOfRows(),5);
    }
    @Test
    public void matrixEquals(){
        ImmutableMatrix matrix = new ImmutableMatrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        Matrix otherMatrix = new Matrix(2,2);
        otherMatrix.setRow(0, 1);
        otherMatrix.setColumn(1,2);
        otherMatrix.setElement(1,0,3);
        otherMatrix.setElement(1,1,4);
        assertTrue(matrix.equals(otherMatrix));
    }
    @Test
    public void matrixHashCode(){
        ImmutableMatrix matrix = new ImmutableMatrix(2,2);
        assertEquals(matrix.hashCode(),63488);
    }
    @Test
    public void matrixInverse(){
        ImmutableMatrix matrix = new ImmutableMatrix(new double[][]{new double[]{1,2},new double[]{3,4}});
        assertEquals(matrix.inverseMatrix(),new Matrix(new double[][]{new double[]{-2,1},new double[]{1.5,-0.5}}));
    }
    @Test
    public void matrixSingle(){
        assertEquals(ImmutableMatrix.singleMatrix(3),new Matrix(new double[][]{new double[]{1,0,0},new double[]{0,1,0},new double[]{0,0,1}}));
    }
}