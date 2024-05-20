  
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
public class Sorting {
    public static void bubbleSort(int arr[]){
        //time complexity O(N^2)
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]   = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int arr[]){
        //time complexity O(n^2)
        for(int i=0;i<arr.length-1;i++){
            int minPos= i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
                int temp = arr[minPos];
                arr[minPos]= arr[i];
                arr[i]= temp;
        }
    }
    public static void insertionSort(int arr[]){
        //time complexity O(N^2)
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
                while(prev>=0&& arr[prev]>curr){
                    arr[prev+1]= arr[prev];
                    prev--;
                }
                arr[prev+1] =curr;
            }
        }
    public static void array(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int  arr[] ={5,4,1,3,2};
        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //Arrays.sort(arr,1,5);
        // array(arr);
        //Arrays.sort(arr);
        //changr to "Integer" in all
        //Arrays.sort(arr,0,3,Collections.reverseOrder());
        array(arr);
    }
}
