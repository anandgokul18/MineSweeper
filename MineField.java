import java.util.Random;

/** 
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {
   
   // <put instance variables here>
   private int numberOfMines;
   private boolean[][] mineField;
   private int numRows;
   private int numCols;
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {

       //Defensive Copy
       //mineField=mineData.clone();
       mineField=new boolean[mineData.length][mineData[0].length];
       boolean copyVar=false;
       for(int i=0;i<mineData.length;i++){
           for(int j=0;j<mineData[i].length;j++){
               copyVar=mineData[i][j];
               mineField[i][j]=copyVar;
           }
       }
       numberOfMines=0;
       numRows=mineField.length;
       numCols=mineField[0].length;

       for(int i=0;i<numRows;i++){
          for(int j=0;j<numCols;j++){
              if(mineField[i][j]==true){
                  numberOfMines++;
              }
          }
      }
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {

       numberOfMines=  numMines;
       this.numRows=numRows;
       this.numCols=numCols;
       mineField = new boolean[numRows][numCols];

   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {
       //Removing existing mines on the minefield
       resetEmpty();

       int minesAllotted=0;
       int mineRow=0;
       int mineCol=0;
       Random rand= new Random();

       //Temporarily setting initial location to be true so that mines are considered as already existing
       // and won't be allocated here
       mineField[row][col]=true;

       while(minesAllotted<numberOfMines){
           mineRow=rand.nextInt(numRows);
           mineCol=rand.nextInt(numCols);
           if(mineField[mineRow][mineCol]!=true){
               mineField[mineRow][mineCol]=true;
               minesAllotted++;
           }
       }
       //Setting the initial location back to false since no mine at the first location
       mineField[row][col]=false;


   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {

       for(int i=0;i<numRows;i++){
           for(int j=0;j<numCols;j++){
               mineField[i][j]=false;
           }
       }

   }

   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
       int adjacentMines=0;

       int[] currRow={row+1,row+1,row+1, row, row, row-1,row-1,row-1};
       int[] currCol={col+1, col, col-1, col+1, col-1, col+1, col, col-1};

       for(int i=0; i<currRow.length; i++){
           if(inRange(currRow[i],currCol[i]) && hasMine(currRow[i],currCol[i])){
               adjacentMines++;
           }
       }

       return adjacentMines;
   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
       if(row<0 || row>=numRows){
           return false;
       }
       if(col<0 || col>=numCols){
           return false;
       }
       return true;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return this.numRows;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      return this.numCols;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
       return mineField[row][col];
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {

       return numberOfMines;
   }

   
   // <put private methods here>
   
         
}

