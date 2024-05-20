 import java.util.*;
public class addArraysIB {
    public static void addArrays(int[] A, int[] B) {
        int sum=0;
        int count = 0;
        for(int i=B.length-1;i>=0;i--){
            int x= 0;
            int y =0;
            int aOne = A[i]*(int)Math.pow(10,x);
            int bOne = B[i]*(int)Math.pow(10,y);
            sum = sum+aOne+bOne;
            x++;y++;
            count++;
        }
        int rem = sum;
        int num = sum;
        System.out.print("[");
        while(rem>0){
         rem = rem%((int)Math.pow(10,count));
         num = num/((int)Math.pow(10,count));
         System.out.print(num+", ");
         count--;
        }
        System.out.print("]");
    }
public static void main(String args[]){
    int A[] = {1,2,3};
    int B []= {1,2,3};
    addArrays(A, B);
}
}
