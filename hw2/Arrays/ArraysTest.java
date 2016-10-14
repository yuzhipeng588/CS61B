import org.junit.Test;
import static org.junit.Assert.*;

/** FIXME
 *  @author Zhipeng Yu
 */

public class ArraysTest {
    /** FIXME
     */
    @Test
    public void testcatenate() {
        int[] a={1,2,3,4,5};
        int[] b={3,6,8};
        int[] c={};
        int[] d={1,2,3,4,5,3,6,8};
        Arrays arr=new Arrays();
        assertArrayEquals("catenate1", d, arr.catenate(a,b));
        assertArrayEquals("catenate2", a, arr.catenate(a,c));
    }
    @Test
    public void testremove() {
        int[] a={1,2,3,4,5};
        int[] b={3,6,8};
        int[] c={};
        int[] d={1,2,3,4,5,3,6,8};
        Arrays arr=new Arrays();
        assertArrayEquals("remove1", a, arr.remove(d,5,3));
        assertArrayEquals("remove2", c, arr.remove(d,10,2));
    }
    @Test
    public void testnaturalRuns() {
        int[] a = {1, 3, 7, 5, 4, 6, 9, 10, 10, 11};
        Arrays arr = new Arrays();
        int[][] b = arr.naturalRuns(a);
        int[] c1 = {1, 3, 7};
        int[] c2 = {5};
        int[] c3 = {4, 6, 9, 10};
        int[] c4 = {10, 11};
        assertArrayEquals(new int[][]{c1, c2, c3, c4}, b);
    }
    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(ArraysTest.class));
    }
}
