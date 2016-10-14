import java.util.ArrayList;
import java.util.Iterator;
import utils.Filter;

/** A kind of Filter that lets all the VALUE elements of its input sequence
 *  that are larger than all the preceding values to go through the
 *  Filter.  So, if its input delivers (1, 2, 3, 3, 2, 1, 5), then it
 *  will produce (1, 2, 3, 5).
 *  @author You
 */
class MonotonicFilter<Value extends Comparable<Value>> extends Filter<Value> {

    /** A filter of values from INPUT that delivers a monotonic
     *  subsequence.  */
    private ArrayList<Value> L1;
    MonotonicFilter(Iterator<Value> input) {
        super(input); //FIXME?
        //Zhipeng
        L1=new ArrayList<Value>();
        while(this.hasNext()){
            L1.add(_next);
            this.set(false);
        }
        boolean a=hasNext();
        this.set(true);
        this.setinput(L1.iterator());
        //Zhipeng
    }

    @Override
    protected boolean keep() {
        if(L1.size()==0){
            return true;
        }
        else if((Integer)_next<=(Integer)L1.get(L1.size()-1)){
            return false;
        }
        else return true;  // FIXME
    }

    // FIXME

}
