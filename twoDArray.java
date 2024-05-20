import java.util.*;
public class twoDArray {
   public static boolean search(int matrix[][],int key){
    for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(key==matrix[i][j]){
                System.out.println("key is found at ["+i+","+j+"]");
                return true;
                }
            }
        }
        return false;
   }
   public static void values(int matrix[][]){
    int maxValue = Integer.MIN_VALUE;
    for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]>maxValue){
                    maxValue=matrix[i][j];
                }
            }
        }
       System.out.println(maxValue);
   }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.println(search(matrix, 0));
        values(matrix);
        sc.close();
    }
}
