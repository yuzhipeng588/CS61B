/* NOTE: The file ArrayUtil.java contains some functions that may be useful
 * in testing your answers. */

/** HW #2, Problem #2. */

/** Array utilities.
 *  @author Zhipeng Yu
 */
class Arrays {
    /* 2a. */
    /** Returns a new array consisting of the elements of A followed by the
     *  the elements of B. */
    static int[] catenate(int[] A, int[] B) {
        /* *Replace this body with the solution. */
        if(A==null){
            return B;
        }
        if(B==null){
            return A;
        }
        int []C=new int[A.length+B.length];
        int i=0;
        for(;i<A.length;i++){
            C[i]=A[i];
        }
        for(;i<A.length+B.length;i++){
                C[i]=B[i-A.length];
        }
        return C;
    }

    /* 2b. */
    /** Returns the array formed by removing LEN items from A,
     *  beginning with item #START. */
    static int[] remove(int[] A, int start, int len) {
        /* *Replace this body with the solution. */
        if(A.length<start){
            int []a={};
            return a;
        }
        else if(len==0){
            return A;
        }
        int []B=new int[A.length-len];
        int i=0;
        for(i=0;i<start;i++){
            B[i]=A[i];
        }
        for(int j=start+len;j<A.length;j++){
            if(i>A.length){
                break;
            }
            B[i]=A[j];
            i++;
        }
        return B;
    }

    /* 4 (optional). */
    /** Returns the array of arrays formed by breaking up A into
     *  maximal ascending lists, without reordering.
     *  For example, if A is {1, 3, 7, 5, 4, 6, 9, 10}, then
     *  returns the three-element array
     *  {{1, 3, 7}, {5}, {4, 6, 9, 10}}. */
    //Zhipeng
    public static int [][]deepcopySame(int[]A,int[][]aa){
        int[][]bb=new int[aa.length][];
        bb[0]=new int[aa[0].length+1];
        bb[0][0]=A[0];
        int i=0;
        while(i<aa[0].length){
            bb[0][i+1]=aa[0][i];
            i++;
        }
        int j=1;
        while(j<aa.length){
            bb[j]=new int[aa[j].length];
            for(int k=0;k<aa[j].length;k++){
                bb[j][k]=aa[j][k];
            }
            j++;
        }
        return bb;
    }
    public static int [][]deepcopyDiff(int[]A,int[][]aa){
        int[][] cc = new int[aa.length+1][];
        cc[0]= new int[1];
        cc[0][0]=A[0];
        int i=0;
        while(i<aa.length){
            cc[i+1]=new int[aa[i].length];
            for(int k=0;k<aa[i].length;k++){
                cc[i+1][k]=aa[i][k];
            }
            i++;
        }
        return cc;
    }
    //Zhipeng
    static int[][] naturalRuns(int[] A) {
        /* *Replace this body with the solution. */
        //Zhipeng
        if (A.length == 1) {
            int[][] dd = {{A[0]}};
            return dd;
        }
        else {
            Utils unit = new Utils();
            int[]a=unit.subarray(A,1,A.length-1);
            int[][]aa=naturalRuns(a);
            if (A[0]<aa[0][0]) {
                int [][]bb=deepcopySame(A,aa);
                return bb;
            }
            else {
                int [][]cc=deepcopyDiff(A,aa);
                return cc;
            }
            //Zhipeng
        }
    }
}
