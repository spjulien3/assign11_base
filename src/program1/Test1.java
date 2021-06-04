package program1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test1 {


    private LinkedList list0, list1,  list3;

    private static LinkedList listOf(int ... x) {
        LinkedList lst = new LinkedList();
        for(int i : x) {
            lst.addLastNode(i);
        }
        return lst;
    }


    @Before
    public void setup() {
        list0 = listOf();
        list1 = listOf(11);
//        list2 = listOf(13, 17);
        list3 = listOf(19, 23, 29);
    }


    // add first node

    @Test
    public void testAddFirstToEmpty() {
        list0.addFirstNode(11);
//        System.out.println("list1 " + list1);
        assertEquals(list1, list0);
    }

    @Test
    public void testAddFirstToNonEmpty() {
        list3.addFirstNode(123);
        assertEquals(listOf(123, 19, 23, 29), list3);

    }

    // add at index

    @Test
    public void testAddTo0InEmptyList() {
        list0.addAtIndex(0, 73);
        assertEquals(listOf(73), list0);
    }

    @Test
    public void testAddTo0InNonemptyList() {
        //ist3 = listOf(19, 23, 29);
        list3.addAtIndex(0, 73);
        assertEquals(listOf(73,19,23,29), list3);
    }

    @Test
    public void testAddToEndInNonEmptyList() {
        list3.addAtIndex(3, 73);
        assertEquals(listOf(19,23,29, 73), list3);
    }

    @Test
    public void addToMiddleInNonEmptyList() {
        list3.addAtIndex(2, 73);
        assertEquals(listOf(19,23,73,29), list3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexTooSmallNonEmptyList() {
        list3.addAtIndex(-1, 73);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexTooLargelNonEmptyList() {
        list3.addAtIndex(4, 73);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexTooSmallEmptyList() {
        list0.addAtIndex(-1, 73);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexTooLargelEmptyList() {
        list0.addAtIndex(1, 73);
    }



    //  remove First Node

    @Test(expected = IllegalStateException.class)
    public void testRemoveFromEmptyList() {
        list0.removeFirstNode();
    }

    @Test
    public void testRemoveFirstFromOneElementList() {
        list1.removeFirstNode();
        assertEquals(list0, list1);
    }

    @Test
    public void testRemoveFirstFromLargerList() {
        list3.removeFirstNode();
        assertEquals(listOf(23, 29), list3);
    }


    //  remove Last Node


    @Test(expected = IllegalStateException.class)
    public void testRemoveLastFromEmptyList() {
        list0.removeLastNode();
    }

    @Test
    public void testRemoveLastFromListWithOneElement() {
        list1.removeLastNode();
        assertEquals(list0, list1);
    }

    @Test
    public void testRemoveLastFromLargerList() {
        list3.removeLastNode();
        assertEquals(listOf(19,23),list3);
    }


    // remove at index

    @Test
    public void testRemoveAtIndexListOfOneElement() {
        list1.removeAtIndex(0);
        assertEquals(list0, list1);
    }

    @Test
    public void testRemoveFirstFromListWithMoreThanOneElement(){
        list3.removeAtIndex(0);
        assertEquals(listOf(23, 29), list3);
    }

    @Test
    public void testRemoveEndFromListWithMoreThanOneElement() {
        list3.removeAtIndex(2);
        assertEquals(listOf(19, 23), list3);

    }

    @Test
    public void testRemoveMiddleFromListWithMoreThanOneElement() {
        list3.removeAtIndex(1);
        assertEquals(listOf(19, 29), list3);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexTooSmallNonemptyList() {
        list3.removeAtIndex(-1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexTooLargeNonemptyList() {
        list3.removeAtIndex(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexTooSmallEmptyList() {
        list0.removeAtIndex(-1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexTooLargeEmptyList() {
        list0.removeAtIndex(0);
    }





}
