package cube;

import java.util.Observable;

import static java.lang.System.arraycopy;

/** Models an instance of the Cube puzzle: a cube with color on some sides
 *  sitting on a cell of a square grid, some of whose cells are colored.
 *  Any object may register to observe this model, using the (inherited)
 *  addObserver method.  The model notifies observers whenever it is modified.
 *  @author P. N. Hilfinger
 */
class CubeModel extends Observable {
//Zhipeng
        private  int Side;
        private  int Row0;
        private  int Col0;
        private  boolean[][] Painted=new boolean[4][4];
        private  boolean[] FacePainted=new boolean[6];
        private  int moves;
        class MyException extends Exception {
                 public MyException() {}
                 public MyException(String message) {
                     super(message);
                 }
     }
//Zhipeng

    /** A blank cube puzzle of size 4. */
    CubeModel() {
//Zhipeng
        moves=0;
        Side=4;
        Row0=0;
        Col0=0;
        boolean[][] painted1={{false,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
        boolean[] facePainted1={false,false,false,false,false,false};
        Painted=painted1;
        FacePainted=facePainted1;
//Zhipeng
        // FIXME
    }

    /** A copy of CUBE. */
    CubeModel(CubeModel cube) {
        this.initialize(cube);
    }

    /** Initialize puzzle of size SIDExSIDE with the cube initially at
     *  ROW0 and COL0, with square r, c painted iff PAINTED[r][c], and
     *  with face k painted iff FACEPAINTED[k] (see isPaintedFace).
     *  Assumes that
     *    * SIDE > 2.
     *    * PAINTED is SIDExSIDE.
     *    * 0 <= ROW0, COL0 < SIDE.
     *    * FACEPAINTED has length 6.
     */
    void initialize(int side, int row0, int col0, boolean[][] painted,
                    boolean[] facePainted) {
//Zhipeng
        this.Side=side;
        this.Row0=row0;
        this.Col0=col0;
        this.Painted=painted;
        this.FacePainted=facePainted;
//Zhipeng
        // FIXME
        setChanged();
        notifyObservers();
    }
    /** Initialize puzzle of size SIDExSIDE with the cube initially at
     *  ROW0 and COL0, with square r, c painted iff PAINTED[r][c].
     *  The cube is initially blank.
     *  Assumes that
     *    * SIDE > 2.
     *    * PAINTED is SIDExSIDE.
     *    * 0 <= ROW0, COL0 < SIDE.
     */
    void initialize(int side, int row0, int col0, boolean[][] painted) {
        initialize(side, row0, col0, painted, new boolean[6]);
    }

    /** Initialize puzzle to be a copy of CUBE. */
    void initialize(CubeModel cube) {
//Zhipeng
        this.Side=cube.side();
        this.Row0=cube.cubeRow();
		this.Col0=cube.cubeCol();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(cube.Painted[i][j]){
					this.Painted[i][j]=true;
				}
				else this.Painted[i][j]=false;
				
			}
		}
		for(int i=0;i<6;i++){
			if(cube.FacePainted[i]){
					FacePainted[i]=true;
				}
			else FacePainted[i]=false;
		}
		moves=cube.moves();
//Zhipeng
        // FIXME
        setChanged();
        notifyObservers();
    }

    /** Move the cube to (ROW, COL), if that position is on the board and
     *  vertically or horizontally adjacent to the current cube position.
     *  Transfers colors as specified by the rules.
     *  Throws IllegalArgumentException if preconditions are not met.
     */
    void move(int row, int col) {
//Zhipeng
        if(row>=0&&col>=0&&row<=3&&col<=3&&((Col0-col)*(Col0-col)+(Row0-row)*(Row0-row))==1){
			boolean swap1=false;
		    boolean swap2=false;
			if(col>Col0){
				this.swap1(2,3,4,5,row,col);
			}
			if(col<Col0){
				this.swap2(2,3,4,5,row,col);
			}
			if(row>Row0){
				this.swap1(0,1,4,5,row,col);
			}			
			if(row<Row0){
				this.swap2(0,1,4,5,row,col);
			}
			Row0=row;
            Col0=col;
            moves++;
         }
         else try{
            IllegalArgumentException E=new IllegalArgumentException();
            throw E;
         }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
         }

//Zhipeng
        // FIXME
        setChanged();
        notifyObservers();
    }

    /** Return the number of squares on a side. */
    int side() {
//Zhipeng
        return Side; // FIXME
//Zhipeng
    }

    /** Return true iff square ROW, COL is painted.
     *  Requires 0 <= ROW, COL < board size. */
    boolean isPaintedSquare(int row, int col) {
//Zhipeng
        return Painted[row][col]; // FIXME
//Zhipeng
    }

    /** Return current row of cube. */
    int cubeRow() {
//Zhipeng
        return Row0; // FIXME
//Zhipeng
    }

    /** Return current column of cube. */
    int cubeCol() {
//Zhipeng
        return Col0; // FIXME
//Zhipeng
    }

    /** Return the number of moves made on current puzzle. */
    int moves() {
//Zhipeng
        return moves; // FIXME
//Zhipeng
    }

    /** Return true iff face #FACE, 0 <= FACE < 6, of the cube is painted.
     *  Faces are numbered as follows:
     *    0: Vertical in the direction of row 0 (nearest row to player).
     *    1: Vertical in the direction of last row.
     *    2: Vertical in the direction of column 0 (left column).
     *    3: Vertical in the direction of last column.
     *    4: Bottom face.
     *    5: Top face.
     */
    boolean isPaintedFace(int face) {
//Zhipeng
        return FacePainted[face]; // FIXME
//Zhipeng
    }

    /** Return true iff all faces are painted. */
    boolean allFacesPainted() {
//Zhipeng
        int count=0;
        for(int i=0;i<FacePainted.length;i++){
			if(FacePainted[i]==false) break;
			else count++;
		}
        if(count==FacePainted.length) return true;
        else return false;		 // FIXME
//Zhipeng
    }

    // ADDITIONAL FIELDS AND PRIVATE METHODS HERE, AS NEEDED.
//Zhipeng
	 void swap1(int a,int b,int c,int d,int row,int col){
		boolean swap1=FacePainted[a];
		boolean swap2=FacePainted[b];
		FacePainted[a]=FacePainted[c];
		FacePainted[b]=FacePainted[d];
		FacePainted[c]=Painted[row][col];
		FacePainted[d]=swap1;
		Painted[row][col]=swap2;
	}
	void swap2(int a,int b,int c,int d,int row,int col){
		boolean swap1=FacePainted[a];
		boolean swap2=FacePainted[b];
		FacePainted[a]=FacePainted[d];
		FacePainted[b]=FacePainted[c];
		FacePainted[c]=Painted[row][col];
		FacePainted[d]=swap2;
		Painted[row][col]=swap1;
	}
	boolean[][] cubePainted(){
		return Painted;
	}
	boolean[] cubeFacePainted(){
		return FacePainted;
	}
//Zhipeng
}
