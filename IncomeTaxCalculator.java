package apnacollege;
import java.util.*;
public class IncomeTaxCalculator {
    public static void main (String args[]){
     Scanner sc = new Scanner(System.in);
     int income = sc.nextInt();
     int tax;
     if(income<=500000){
       tax=0;
     }else if(income> 500000 && income <=1000000){
        tax= (int)(income*0.2); //20% tax
     }else{
        tax = (int)(income*0.3);//30% tax (greater than 10lakhs)
     }
      System.out.println("my tax is "+ tax);
      sc.close();
    }
}
