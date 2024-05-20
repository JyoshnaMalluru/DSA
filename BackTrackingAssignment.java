import java.util.*;
public class BackTrackingAssignment {
    public static String [] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void printCombination(String str,int idx,String combination){
        if(idx==str.length()){
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar-'0'];
        for(int i=0;i<mapping.length();i++){
            printCombination(str, idx+1, combination+mapping.charAt(i));
        }
    }
    public static boolean checker(int maze[][],int sol [][],int row,int col){
        int n= maze.length;
        if(row<0||row>=n||col<0||col>=n){
            return false;
        }
        if(maze[row][col]==0||sol[row][col]==1){
            return false;
        }
       return true;
    }
    public static void solveMaze(int row, int col,int maze[][],int sol[][]){
      int n = maze.length;
      if(row==n-1&&col==n-1){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        return ;
      } 
      if(checker(maze, sol, row, col+1)){
        sol[row][col+1]=1;
        solveMaze(row, col+1, maze, sol);
        sol[row][col+1]=0;
      }
      if(checker(maze, sol, row, col-1)){
        sol[row][col-1]=1;
        solveMaze(row, col-1, maze, sol);
        sol[row][col-1]=0;
      }
      if(checker(maze, sol, row+1, col)){
        sol[row+1][col]=1;
        solveMaze(row+1, col, maze, sol);
        sol[row+1][col]=0;
      }
      if(checker(maze, sol, row-1, col)){
        sol[row-1][col]=1;
        solveMaze(row-1, col, maze, sol);
        sol[row-1][col]=0;
      }
    }
    public static void main(String[] args) {
         String str = "23";
         printCombination(str, 0,"");
        int  maze [][] = {{1,0,0,0},
                          {1,1,0,0},
                          {0,1,0,0},
                          {1,1,1,1}};
        int n= 4;
        int sol[][] = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                sol[i][j]=0;
            }
        }
        sol[0][0]=1;
        solveMaze(0,0,maze,sol);
    }
}
