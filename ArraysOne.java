import java.util.*;
public class ArraysOne {
    public static void update(int marks[],int nonChangable){
        nonChangable+=1;
        for(int i=0;i<=2;i++){
            marks[i] +=1;
        }
    }
    
    public static int getLargest(int arr[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(largest<arr[i]){
                largest = arr[i];
            }
            if(smallest>arr[i]){
                smallest = arr[i];
            }
        }
        System.out.println("Smallest numer is "+ smallest);
        return largest;
    }
    public static void main (String args[]){
     // Scanner sc = new Scanner(System.in);
    //   int marks[] = new int[50];
    //   System.out.println(marks.length);
    //   marks[0] = sc.nextInt();
    //   marks[1] = sc.nextInt();
    //   marks[2] = sc.nextInt();
    //  System.out.println("phy :"+ marks[0]);
    //  System.out.println("che :"+ marks[1]);
    //  System.out.println("mat :"+ marks[2]);
    //  marks[2] +=1;
    // System.out.println("mat :"+ marks[2]); 
    /*int marks[] ={98,99,97};   
    int nonChangable = 5;
    update(marks,nonChangable);
    for(int i=0;i<=2;i++){
        System.out.println(marks[i]);
        }
    System.out.println(nonChangable);*/
    // sc.close();
    int arr[] = {4,6,8,3,5,2,6};
     System.out.println("Largest number is "+getLargest(arr));
}
}