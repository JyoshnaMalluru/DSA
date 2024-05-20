package apnacollege;
import java.util.*;
public class TableAndSum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int evenSum =0;
        int oddSum =0;
        //for(int i=0;i<=10;i++){
        //    System.out.println(n+" * "+i+" = "+n*i);
       // }
       for(int i=0;i<=n;i++){
        if(i%2==0){
            evenSum+=i;
        }else{
            oddSum+=i;
        }
       }
       System.out.println(evenSum);
       System.out.println(oddSum);
       sc.close();
    }
}
