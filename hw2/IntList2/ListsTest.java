import org.junit.Test;
import static org.junit.Assert.*;

/** FIXME
 *
 *  @author FIXME
 */

public class ListsTest {
    /** FIXME
     */
    @Test
    public void testnaturalRuns() {
        IntList a1 = new IntList();
        IntList2 a2 = new IntList2();
        Lists a3 = new Lists();
        IntList b = a1.list(1, 3, 7, 5, 4, 6, 9, 10, 10, 11);
        IntList2 e = a3.naturalRuns(b);
        IntList c1 = a1.list(1, 3, 7);
        IntList c2 = a1.list(5);
        IntList c3 = a1.list(4, 6, 9, 10);
        IntList c4 = a1.list(10, 11);
        IntList2 d = a2.list(c1, c2, c3, c4);
        assertEquals(d, e);
    }


    // It might initially seem daunting to try to set up
    // Intlist2 expected.
   	//
    // There is an easy way to get the IntList2 that you want in just
    // few lines of code! Make note of the IntList2.list method that
    // takes as input a 2D array.

    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(ListsTest.class));
    }
}
