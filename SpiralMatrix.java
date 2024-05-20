public class SpiralMatrix {
    public static void spiralMat(int matrix[][]){
        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        while(startRow<=endRow && startCol<=endCol){
            //Top
            for(int j=startCol;j<=endCol;j++){
                System.out.print(matrix[startRow][j]+" ");
            }
            //Right
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol]+" ");
            }
            //bottom
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }
            //Left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }
   /*public static void diagonalMatrix(int matrix[][]){
        //time complexity O(n^2)
        int n= matrix.length-1;
        int sum1=0;int sum2=0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==j){
                sum1+=matrix[i][j];
            }
            if(i+j==n){
                sum2+=matrix[i][j];
            }
        }
    }
    System.out.println(sum1+sum2);
}*/
public static int  diagonalMatrix(int matrix[][]){
    //Time Complexity O(n)
    int sum =0;
    for(int i=0;i<matrix.length;i++){
        //pd
       sum+=matrix[i][i];
       if(i!=matrix.length-1-i){
        sum+=matrix[i][matrix.length-1-i];
       }
    }
    return sum;
}

    public static void main(String args[]){
        int matrix[][]={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        spiralMat(matrix);
        System.out.println(diagonalMatrix(matrix));
    }
}
