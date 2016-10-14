import sun.invoke.empty.Empty;

/** A WeirdList holds a sequence of integers.
 * @author Zhipeng Yu
 */
public class WeirdList {
    /** The empty sequence of integers. */
    public static final WeirdList EMPTY=new EmptyList() ;  // REPLACE THIS LINE WITH THE RIGHT ANSWER.
    //Zhipeng
    private int head;
    private WeirdList tail;
    private int len;
    //Zhipeng
    /** A new WeirdList whose head is HEAD and tail is TAIL. */
    public WeirdList(int head, WeirdList tail) {
        /* FILL IN */
        //Zhipeng
        this.head=head;
        this.tail=tail;
        //Zhipeng
    }
    //Zhipeng
    public WeirdList(){
    }
    //Zhipeng

    /** Returns the number of elements in the sequence that
     *  starts with THIS. */
    public int length() {
        //Zhipeng
        return this.recursion();
        //return 0;  // REPLACE THIS LINE WITH THE RIGHT ANSWER.
        //Zhipeng
    }

    /** Return a string containing my contents as a sequence of numerals
     *  each preceded by a blank.  Thus, if my list contains
     *  5, 4, and 2, this returns " 5 4 2". */
    @Override
    public String toString() {
        //Zhipeng
        //return M.stringmethod(this);
        return " "+this.head+this.tail.toString(); // REPLACE THIS LINE WITH THE RIGHT ANSWER.
        //Zhipeng
    }

    /** Part 3b: Apply FUNC.apply to every element of THIS WeirdList in
     *  sequence, and return a WeirdList of the resulting values. */
    public WeirdList map(IntUnaryFunction func) {
        //return null;  // REPLACE THIS LINE WITH THE RIGHT ANSWER.
        WeirdList W=new WeirdList(func.apply(this.tail.head),map(func));
        return W;
    }
    //Zhipeng
    public int recursion(){
        len=this.tail.recursion()+1;
        return len;
    }
    public int sum(){
        int s=this.tail.sum()+head;
        return s;
    }
    public void add(int n){
        head+=n;
        this.tail.add(n);
    }

    //Zhipeng
    //Zhipeng
    public static class EmptyList extends WeirdList{
        EmptyList(){
            super();
        }
        @Override
        public int recursion(){
            return 0;
        }
        @Override
        public String toString(){
            return "";
        }
        @Override
        public int sum(){
            return 0;
        }
        @Override
        public void add(int i){
        }
        @Override
        public WeirdList map(IntUnaryFunction func){
            return WeirdList.EMPTY;
        }
    }
    public class SumClass extends WeirdList implements IntUnaryFunction{
        @Override
        public int apply(int x) {
            return x+head;
        }
    }
    //Zhipeng


    /*
     * You should not add any methods to WeirdList, but you will need
     * to add private fields (e.g. head).

     * But that's not all!

     * You will need to create at least one additional class for WeirdList
     * to work. This is because you are forbidden to use any of the
     * following in ANY of the code for HW3 (we won't actually check,
     * but, you're depriving yourself of a nice problem if you do):
     *       if, switch, while, for, do, try, or the ?: operator.

     * If you'd like an obtuse hint, scroll to the very bottom of this
     * file.

     * You can create this hypothetical class (or classes) in separate
     * files like you usually do, or if you're feeling bold you can
     * actually stick them INSIDE of this class. Yes, nested classes
     * are a thing in Java.

     * As an example:
     * class Garden {
     *     private static class Potato {
     *        int n;
     *        public Potato(int nval) {
     *           n = nval;
     *        }
     *     }
     * }
     * You are NOT required to do this, just an extra thing you can
     * do if you want to avoid making a separate .java file. */

}


















/*
 * Hint: The first non-trivial thing you'll probably do to WeirdList
 * is to fix the EMPTY static variable so that it points at something
 * useful. */

