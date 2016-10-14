import java.util.ArrayList;
import java.util.Iterator;
import utils.Predicate;
import utils.Filter;

/** A kind of Filter that tests the elements of its input sequence of
 *  VALUES by applying a Predicate object to them.
 *  @author You
 */
class PredicateFilter<Value> extends Filter<Value> {

    /** A filter of values from INPUT that tests them with PRED,
     *  delivering only those for which PRED is true. */
    public Predicate<Value> pred2;
    PredicateFilter(Predicate<Value> pred, Iterator<Value> input) {
        super(input); //FIXME ??
        //Zhipeng
        pred2=pred;
        ArrayList<Value> L=new ArrayList<Value>();
        while(this.hasNext()){
            L.add(_next);
            this.set(false);
        }
        this.set(true);
        this.setinput(L.iterator());
        //Zhipeng
        // FIXMEX

    }

    @Override
    protected boolean keep() {
        if(pred2.test(this._next)){
            return true;
        }
        else return false;  // FIXME
    }

    // FIXME

}
