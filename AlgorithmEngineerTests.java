import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test RangeSearchTreeAE class
 */
public class AlgorithmEngineerTests {
    /**
     * Tests is nodes were added correctly
     */
    @Test
    public void test1() {
        RangeSearchTreeAE rangeSearch = new RangeSearchTreeAE();
        rangeSearch.insertOne(2);
        rangeSearch.insertOne(3);
        rangeSearch.insertOne(4);
        rangeSearch.insertOne(5);
        assertEquals(4, rangeSearch.getNumberOfNodes());
    }
    /**
     * Tests if nodes were removed correctly
     */
    @Test
    public void test2() {
        RangeSearchTreeAE rangeSearch = new RangeSearchTreeAE();
        rangeSearch.insertOne(2);
        rangeSearch.insertOne(3);
        rangeSearch.insertOne(4);
        rangeSearch.removeOne(4);
        assertEquals(2, rangeSearch.getNumberOfNodes());
    }

    /**
     * Test if toLevelOrderString() is correct after insertion
     */
    @Test
    public void test3() {
        RangeSearchTreeAE rangeSearch = new RangeSearchTreeAE();
        rangeSearch.insertOne(2);
        rangeSearch.insertOne(3);
        rangeSearch.insertOne(4);
        // Compare expected level order string to actual toLevelOrderString()
        assertEquals("[ 3, 2, 4 ]", rangeSearch.toLevelOrderString());
    }

    /**
     * Test if toLevelOrderString() is correct after insertion and removal
     */
    @Test
    public void test4() {
        RangeSearchTreeAE rangeSearch = new RangeSearchTreeAE();
        rangeSearch.insertOne(2);
        rangeSearch.insertOne(3);
        rangeSearch.insertOne(4);
        rangeSearch.removeOne(4);
        // Compare expected level order string to actual toLevelOrderString()
        assertEquals("[ 3, 2 ]", rangeSearch.toLevelOrderString());
    }

    /**
     * Test if enforceRBTreePropertiesAfterRemove() is correct
     */
    @Test
    public void test5() {
        RangeSearchTreeAE rangeSearch = new RangeSearchTreeAE();
        rangeSearch.insertOne(2);
        rangeSearch.insertOne(3);
        rangeSearch.insertOne(4);
        rangeSearch.insertOne(5);
        rangeSearch.removeOne(4);
        rangeSearch.enforceRBTreePropertiesAfterRemove(rangeSearch.findNodeWithData(3));
        assertEquals("[ 3, 2, 5 ]", rangeSearch.toLevelOrderString());
    }
}
