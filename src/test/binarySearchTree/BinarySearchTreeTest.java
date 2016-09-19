package binarySearchTree;

import org.junit.*;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer, String> tree;

    @Before
    public void init() {
        tree = new BinarySearchTree<>();
    }


    @Test
    public void testPutAndGet() {
        tree.put(5, "Five");
        assertEquals("Five", tree.get(5));

        tree.put(1, "One");
        assertEquals("One", tree.get(1));
        
        assertEquals("Five", tree.getRoot().getValue());
        
        assertEquals("One", tree.getRoot().getLeft().getValue());

        tree.put(7, "Seven");
        assertEquals("Seven", tree.getRoot().getRight().getValue());
    }

    @Test
    public void removeTest() {
        tree.put(8, "Eight");
        tree.remove(8);
        assertNull("Root wasn't removed", tree.getRoot());

        tree.put(8, "Eight");
        tree.put(10, "Ten");
        tree.put(9, "Nine");

        tree.remove(10);
        assertEquals("Nine", tree.getRoot().getRight().getValue());
        assertNull(tree.get(10));

        tree.put(4, "Four");
        tree.put(2, "Two");
        tree.put(6, "Six");
        tree.put(5, "Five");

        tree.remove(4);
        assertNull(tree.get(4));

    }
}