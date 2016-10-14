import static org.junit.Assert.*;
import org.junit.Test;

public class IntListTest {

    /** Sample test that verifies correctness of the IntList.list static
     *  method. The main point of this is to convince you that
     *  assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.list(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    /** Do not use the new keyword in your tests. You can create
     *  lists using the handy IntList.list method.
     *
     *  Make sure to include test cases involving lists of various sizes
     *  on both sides of the operation. That includes the empty list, which
     *  can be instantiated, for example, with
     *  IntList empty = IntList.list().
     *
     *  Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     *  Anything can happen to A.
     */

    @Test
    public void testDcatenate() {
//Zhipeng
        IntList L1=IntList.list(1);
        IntList L2=IntList.list(2,3,4,5);
        IntList L3=IntList.list(1,2,3,4,5);
        IntList L4=null;
        assertEquals(L3,IntList.dcatenate(L1,L2));
        assertEquals(L1,IntList.dcatenate(L1,L4));
        assertEquals(L1,IntList.dcatenate(L4,L1));
//Zhipeng

    }

    /** Tests that subtail works properly. Again, don't use new.
     *
     *  Make sure to test that subtail does not modify the list.
     */

    @Test
    public void testSubtail() {
//Zhipeng
        IntList L1=IntList.list(1,2,3,4,5);
        IntList L2=IntList.list(3,4,5);
        IntList L3=null;
        assertEquals(IntList.subTail(L1,2), L2);
        assertEquals(IntList.subTail(L1,8), L3);
        assertEquals(IntList.subTail(L3,5), L3);
//Zhipeng

    }

    /** Tests that sublist works properly. Again, don't use new.
     *
     *  Make sure to test that sublist does not modify the list.
     */

    @Test
    public void testSublist() {
//Zhipeng
        IntList L1=IntList.list(1,2,3,4,5);
        IntList L2=IntList.list(3,4);
        IntList L3=IntList.list(3);
        IntList L4=null;
        assertEquals(L2,IntList.sublist(L1,2,2));
        assertEquals(L3,IntList.sublist(L1,2,1));
        assertEquals(L4,IntList.sublist(L1,5,1));
        assertEquals(L4,IntList.sublist(L1,2,0));
//Zhipeng

    }

    /** Tests that dSublist works properly. Again, don't use new.
     *
     *  As with testDcatenate, it is not safe to assume that list passed
     *  to dSublist is the same after any call to dSublist
     */

    @Test
    public void testDsublist() {
//Zhipeng
        IntList L1=IntList.list(1,2,3,4,5);
        IntList L2=IntList.list(3,4);
        IntList L3=IntList.list(5,6);
        IntList L4=null;
        IntList L6=IntList.list(5,6);
        assertEquals(L2,IntList.dsublist(L1,2,2));
        assertEquals(L4,IntList.dsublist(L3,2,1));
       assertEquals(L4,IntList.dsublist(L6,1,0));
//Zhipeng
    }


    /* Run the unit tests in this file. */
    public static void main(String... args) {
        System.exit(ucb.junit.textui.runClasses(IntListTest.class));
    }
}
