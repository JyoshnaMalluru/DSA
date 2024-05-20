public class TwoDArrAssignmentQA {
    public static int count(int matrix[][],int key){
        int count =0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    count++;
                }
            }
        }
        return count;
    }
    public static void secondRowSum(int matrix[][]){
        int sum =0;
            for(int j=0;j<matrix[0].length;j++){
               sum+=matrix[1][j];
            }
        System.out.println(sum);
    }
    public static void printMatrix(int matrix[][]){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        /*int matrix[][] ={ {4,7,8},{8,8,7}};
        int key = 7;
        System.out.println(count(matrix,key));*/
        /*int matrix[][] = {{1,4,9},{11,4,3},{2,2,3}};
        secondRowSum(matrix);*/
        int matrix[][]={{2,3,7},{5,6,7}};
        int row = 2; int col =3;
        printMatrix(matrix);
        int transpose[][] = new int[col][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                transpose[j][i]=matrix[i][j];
            }
        }
        printMatrix(transpose);
    }
}

