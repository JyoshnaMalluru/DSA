import java.util.*;
public class ArraysAssignmentTwo {
    public static boolean appears(int num[]){
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i]==num[j]){
                    return true;
                }
            }
        }
       return false;
    }
    public static boolean appear(int num[]){
       Arrays.sort(num);
       for(int i=0;i<num.length;i++){  
        if(num[i]==num[i+1])  {
            return true;
        }
       }   
       return false;
    }
    public static void triplets(int num[]){
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                for(int k=j+1;k<num.length;k++){
                        if(num[i]+num[j]+num[k]==0){
                        System.out.println("["+num[i]+","+num[j]+","+num[k]+"]");
                    }
                }
            }
        }
    }

    public static void main(String args[]){
       // int num[]={1,2,3,1};
        //int num[] = {1, 2, 3, 4};
        //int num[] = { 1, 1, 3, 3, 4, 3, 2, 4, 2};
        //System.out.println(appears(num));
        //System.out.println(appear(num));
        //int num [] = {0,0,0};
        int num [] ={-1,0,1,2,-1,4};
           triplets(num);
    }
}
