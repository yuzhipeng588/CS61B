import java.util.ArrayList;
import java.util.Iterator;
import utils.Filter;

/** A kind of Filter that lets through every other VALUE element of
 *  its input sequence, starting with the first.
 *  @author Zhipeng Yu
 */
class AlternatingFilter<Value> extends Filter<Value> {

    /** A filter of values from INPUT that lets through every other
     *  value. */
    //private Iterator<Value> _input;
    AlternatingFilter(Iterator<Value> input) {
        super(input);
        //Zhipeng
        ArrayList<Value> L=new ArrayList<Value>();
        while(this.hasNext()){
            L.add(_next);
            this.set(false);
            boolean a=this.hasNext();
            this.set(false);
        }
        this.setinput(L.iterator());
        //Zhipeng
    }

    @Override
    protected boolean keep(){
        //Zhipeng
        return true; // FIXME
        //Zhipeng
    }

    // FIXME

}
