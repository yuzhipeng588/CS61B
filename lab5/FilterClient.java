import utils.Filter;
import utils.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

/** Exercises for Lab 6.
 *  @author Zhipeng Yu.
 */
public class FilterClient {


    /** Print out the items returned by L. */
    static void printAll(Filter<Integer> L) {
        System.out.print("[");
        String sep;
        sep = "";
        for (Integer i : L) {
            System.out.print(sep + i);
            sep = ", ";
        }
        System.out.println("]");
    }

    /** A sample space where you can experiment with your filter. 
      * ARGS is unused. */
    public static void main(String[] args) {
        List<Integer> L = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        System.out.println(L);
        Filter<Integer> f1 = everyFourth(L.iterator());
        printAll(f1);

        /* Extra Challenges that you should complete without creating
           any new Filter implementations (i.e. you can create them
           using Trivial, Alternating, Monotonic, and/or PredicateFilter)
           1. Create a filter everyFourth that prints very fourth
              item.
           2. Create a filter that prints only even valued items. */
    }


    /** Below follow some additional puzzles you should feel free to attempt. */

    /** Returns a filter that delivers every fourth item of INPUT,
     *  starting with the first.  You should not need to define a new
     *  class. */
    static Filter<Integer> everyFourth(Iterator<Integer> input) {
        Iterator<Integer> itr=input;
        ArrayList<Integer> L=new ArrayList<Integer>();
        lableA:
        while(input.hasNext()){
            int j=0;
            if(L.size()==0) {
                j = input.next();
                L.add(j);
            }
            for(int i=0;i<4;i++){
                if(!input.hasNext()){
                    break lableA;
                }
                j=input.next();
            }
            L.add(j);
        }
        Filter<Integer> F=new TrivialFilter<Integer>(L.iterator());
        return F;  // FIXME
    }




}
