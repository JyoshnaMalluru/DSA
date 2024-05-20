package apnacollege;
import java.util.*;
public class BreakContinue {
    public static void main(String args[]){
        /*for(int i=0;i<10;i++){
            if(i==8){
                //break;
                continue;
            }
            System.out.print(i);
        }*/
       Scanner sc = new Scanner(System.in);
       do{
       System.out.println("number");
       int n= sc.nextInt();
       if(n%10==0){
        //break;
        continue;
       }
      System.out.println("number is"+n);
       }while(true);
    }
}
