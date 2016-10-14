import java.util.Formatter;
public class IntDList {

    private DNode _front, _back;

    public IntDList() {
        _front = _back = null;
    }

    public IntDList(Integer... values) {
        _front = _back = null;
        for (int val : values) {
            insertBack(val);
        }
    }

    public int getFront() {
        return _front._val;
    }

    /** Returns the last item in the IntDList. */
    public int getBack() {
        return _back._val;
    }

    /** Return value #I in this list, where item 0 is the first, 1 is the
     *  second, ...., -1 is the last, -2 the second to last.... */
    public int get(int i) {
        DNode p=null;
        if(this._front==null){
            System.out.print("Errors");
        }
        else {
            if (i >= 0) {
                p=this._front;
                for (int j=0;j<this.size() ;j++){
                    if(i==j){
                        return p._val;
                    }
                    p=p._next;
                }
            }
            else{
                p=this._back;
                for (int j=1;j<this.size()+1 ;j++){

                    if(i==-1*j){
                        return p._val;
                    }
                    p=p._prev;
                }
            }
        }
        return p._val;   // Your code here
    }

    /** The length of this list. */
    public int size() {
        int count=1;
        if(this._front==null){
            return 0;
        }
        else {
            DNode p=this._front;
            while (p._next != null) {
                count++;
                p=p._next;
            }
        }
        return count;   // Your code here
    }

    /** Adds D to the front of the IntDList. */
    public void insertFront(int d) {
        DNode p=new DNode(d);
        if(this.size()==0) {
            this._front = p;
            this._back = p;
        }
        else {
            p._next=this._front;
            this._front._prev=p;
            this._front=p;
        }
        // Your code here 
    }

    /** Adds D to the back of the IntDList. */
    public void insertBack(int d) {
        DNode p=new DNode(d);
        if(this.size()==0) {
            this._front = p;
            this._back = p;
        }
        else {
            p._prev=this._back;
            this._back._next=p;
            this._back=p;
        }
        // Your code here 
    }

    /** Removes the last item in the IntDList and returns it.
     * This is an extra challenge problem. */
    public int deleteBack() {
        DNode p=this._back;
        if(this._back._prev!=null) {
            this._back = this._back._prev;
            this._back._next=null;
        }
        else {
            this._back = null;
            this._front = null;
        }
        return p._val;   // Your code here

    }

    /** Returns a string representation of the IntDList in the form
     *  [] (empty list) or [1, 2], etc. 
     * This is an extra challenge problem. */
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "[";
        if(this._front!=null) {
            for (DNode p = this._front; p != null; p = p._next) {
                out.format("%s%d", sep, p._val);
                sep = ", ";
                if (p._next == null) {
                        break;
                }
            }
            out.format("]");
            return out.toString();
        }
        else {
            out.format("[]");
            return out.toString();// Your code here
        }
    }

    /* DNode is a "static nested class", because we're only using it inside
     * IntDList, so there's no need to put it outside (and "pollute the
     * namespace" with it. This is also referred to as encapsulation.
     * Look it up for more information! */
    private static class DNode {
        protected DNode _prev;
        protected DNode _next;
        protected int _val;

        private DNode(int val) {
            this(null, val, null);
        }

        private DNode(DNode prev, int val, DNode next) {
            _prev = prev;
            _val = val;
            _next = next;
        }
    }

}
