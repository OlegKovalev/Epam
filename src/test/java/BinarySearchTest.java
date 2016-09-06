
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег on 06.09.2016.
 */
public class BinarySearchTest {

    BinarySearch binarySearch;
    @Before
    public void setUp() throws Exception {
        binarySearch = new BinarySearch();
    }

    @Test
    public void binarySearch() throws Exception {
        Integer[] array = {1,2,4,5,6,8,9,10,13,14,15,99};
        assertEquals(3, binarySearch.binarySearch(array, 5));
    }

}