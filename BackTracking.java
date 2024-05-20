public class BackTracking {
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void changeArr(int arr[],int i,int val) {
        //base case
        if(i==arr.length){
            printArr(arr);
            return;
        }
        //recursion
        arr[i]=val;
        changeArr(arr, i+1, val+1);//fnx calling step
        arr[i]=arr[i]-2;//backtracking step
    }
    public static void subsets(String str, int idx, String subsets){
        //base
        if(idx==str.length()){
            if(subsets.length()==0){
                System.out.println("null");
            }else{
                System.out.println(subsets);
            }
        return;
        }
        //recursion
        subsets(str,idx+1,subsets+str.charAt(idx));
        subsets(str,idx+1,subsets);
    }
    public static void permutations(String str,String ans){
        //base
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newStr= str.substring(0, i)+str.substring(i+1);
            permutations(newStr, ans+curr);
        }
    }
  //PRINT CHESS BOARD WITHOUT ANY ATTACKS
  public static boolean isSafe(char board[][],int row,int col){
    //vertical up
    for(int i=row-1;i>=0;i--){
        if(board[i][col]=='Q'){
            return false;
        }
    }
    //diagonal left
    for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
        if(board[i][j]=='Q'){
            return false;
        }
    }
   //diagonal right
   for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
    if(board[i][j]=='Q'){
            return false;
   }
  }
  return true;
}
  public static void /*boolean*/ nQueens(char board[][],int row){
    //TIME COMPLEXITY  O(n!)//n*T(n-1)+isSafes
    //base
    if(row==board.length){
        //count++;
        printArray(board);
        //return true;
        return;
    }
    for(int j=0;j<board.length;j++){
        if(isSafe(board, row, j)){
        board[row][j]='Q';
        // if(nQueens(board, row+1)){
        //     return true;
        // }
        nQueens(board, row+1);
        board[row][j]='.';
        }
    }
    //return false;
  }
  public static void printArray(char board[][]){
    System.out.println("//CHESS BOARD//");
    for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
  }
  //GRID WAYS
  public static int gridWays(int strt1, int strt2,int rows,int cols){
    //TIMECOMPLEXITY O(2^(ROWS+COLS))
   //base case
   if(strt1==rows-1&& strt2== cols-1){
    return 1;
   }
   if(strt1==rows || strt2==cols){
    return 0;
   }
   int w1=gridWays( strt1+1, strt2, rows, cols);
   int w2=gridWays(strt1, strt2+1, rows, cols);
   return w1+w2;
  }

  //SUDOKU PROBLLEM
  public static boolean isSafe(int sudoku[][],int row,int col,int digit){
    //column
    for(int rows=0;rows<9;rows++){
        if(sudoku[rows][col]==digit){
           return false;
        }
    }
    //rows
    for(int cols=0;cols<9;cols++){
        if(sudoku[row][cols]==digit){
            return false;
        }
    }
    //grid
    int sr =(row/3)*3;
    int sc =(col/3)*3;
    for(int r=sr;r<sr+3;r++){
        for(int c=sc;c<sc+3;c++){
            if(sudoku[r][c]==digit){
                return false;
            }
        }
    }
    return true;
  }
  public static boolean sudokuSolver(int sudoku[][],int row,int col){
    //base case
    if(row==9 && col==0){
        return true;
    }
    //recursion
    int nextRow= row; 
    int nextCol = col+1;
    if(col+1==9){
        nextRow= row+1;
        nextCol = 0;
    }
    if(sudoku[row][col]!=0){
        return sudokuSolver(sudoku, nextRow, nextCol);
    }
    for(int digit=1;digit<=9;digit++){
        if(isSafe(sudoku,row,col,digit)){
            sudoku[row][col]=digit;
            if(sudokuSolver(sudoku,nextRow,nextCol)){
                return true;
            }
            sudoku[row][col]=0;
        }

    }
    return false;
  }
  public static void printSudoku(int sudoku[][]){
      for(int r=0;r<9;r++){
        for(int c=0;c<9;c++){
            System.out.print(sudoku[r][c]+" ");
        }
        System.out.println();
      }
  }
    static int count=0;
    public static void main(String args[]){
        //int arr[]= new int[5];
        //changeArr(arr,0,0);
        //printArr(arr);
        // subsets("abc", 0, "");
        //permutations("abc", "");
        //CHESS BOARD
        int n=4;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
         nQueens(board,0);
        // if(nQueens(board,0)){
        //     System.out.println("Solution Possible");
        //  printArray(board);
        // }else{
        //     System.out.println("Solution Is Not Possible");
        // }
       
        //System.out.println("ways = "+count);
        // int rows=3,cols=3;
        // System.out.println(gridWays(0, 0, rows, cols));
       /*int sudoku[][]={{0,0,8,0,0,0,0,0,0},
                        {4,9,0,1,5,7,0,0,2},
                        {0,0,3,0,0,4,1,9,0},
                        {1,8,5,0,6,0,0,2,0},
                        {0,0,0,0,2,0,0,6,0},
                        {9,6,0,4,0,5,3,0,0},
                        {0,3,0,0,7,2,0,0,4},
                        {0,4,9,0,3,0,0,5,7},
                        {8,2,7,0,0,9,0,1,3}};
    if(sudokuSolver(sudoku,0,0)){
        System.out.println("solution exists");
         printSudoku(sudoku);
    }else{
        System.out.println("solution does not exists");
    }*/
    }
}





// class Solution {
//     public boolean isValid(char[][] board, int row, int col) {
//         char digit = board[row][col];
//         board[row][col] = '.'; // Temporarily remove the digit for backtracking

//         // Check row, column, and 3x3 grid
//         for (int i = 0; i < 9; i++) {
//             if (board[i][col] == digit || board[row][i] == digit) {
//                 return false;
//             }
//             int subgridRow = 3 * (row / 3) + i / 3;
//             int subgridCol = 3 * (col / 3) + i % 3;
//             if (board[subgridRow][subgridCol] == digit) {
//                 return false;
//             }
//         }

//         board[row][col] = digit; // Restore the digit
//         return true;
//     }

//     public boolean isValidSudoku(char[][] board) {
//         for (int row = 0; row < 9; row++) {
//             for (int col = 0; col < 9; col++) {
//                 if (board[row][col] == '.') {
//                     for (char digit = '1'; digit <= '9'; digit++) {
//                         board[row][col] = digit;
//                         if (isValid(board, row, col)) {
//                             if (isValidSudoku(board)) {
//                                 return true;
//                             }
//                         }
//                         board[row][col] = '.'; // Backtrack
//                     }
//                     return false; // No valid digit found
//                 }
//             }
//         }
//         return true; // All cells filled
//     }
// }