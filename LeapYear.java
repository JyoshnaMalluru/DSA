package apnacollege;
import java.util.*;
public class LeapYear {
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int year = sc.nextInt();
    boolean leap = false;
    if(year%4==0){
        if(year%100==0){
          if(year%400==0){
            leap = true;
          }else{
            leap = false;
          }
        }else{
            leap = true;
        }

    }else{
        leap = false;
    }
    if(leap){
        System.out.println(year+"is leap year");
    }else{
        System.out.println(year+"is not leap year");
    }
    sc.close();
    }
}

/*public class Solution{
  public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    System.out.print("Input the year: ");
    int year=sc.nextInt();
    boolean x= (year%4) ==0;
    boolean y= (year%100) !=0;
    boolean z= ((year%100==0) && (year%400==0));
    if(x&& (y||z)) {
      System.out.println(year+" is a leap year");
    }else{
      System.out.println(year+" is not a leapyear");}
    }
    sc.close();
  }*/