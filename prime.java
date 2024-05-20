package apnacollege;
import java.util.*;
public class prime {
    public static void main (String args[]){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int div= 2;
      while (div<n) {
        if(n%div==0){
            System.out.println("not prime");
            break;
        }
        else{
            div= div+1;
            if(div==n){
                System.out.println("prime");
            }
        }
      }
      sc.close();
    }
}
// OPTIMISE METHOD IT SHOULD BE USED EVERYWHERE
 /* if(n==2){
     System.out.println("prime");
 }else{
   boolean isPrime= true;
    for(int i=2;i<=Math.sqrt(n);i++){
      if(n%i==0){
        isPrime==false;
      }
    }
    if(isPrime){
      System.out.println("prime");
    }else{
      System.out.println("not prime");
    }
    }
  */