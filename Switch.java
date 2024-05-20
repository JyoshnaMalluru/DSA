package apnacollege;
import java.util.*;
public class Switch {
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
   /*  int number = sc.nextInt();
    switch (number){
    case 1 : System.out.println("samosa");
    break;
    case 2 : System.out.println("burger");
    break;
    case 3 : System.out.println("pizza");
    break;
    default : System.out.println("wake up");
    break;
    }*/
     int a= sc.nextInt();
     int b= sc.nextInt();

    char operator = sc.next().charAt(0);
    switch(operator){
        case '+' : System.out.println(a+b);
        break;
        case '-' : System.out.println(a-b);
        break;
        case '*' : System.out.println(a*b);
        break;
        case '/' : System.out.println(a/b);
        break;
        case '%' : System.out.println(a%b);
        break;

    }
    sc.close();
    }
}
