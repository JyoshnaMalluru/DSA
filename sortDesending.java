import java.util.*;
public class sortDesending {
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1]= temp;
                }
            }
        }
    }
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int maxPos = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[maxPos]<arr[j]){
                    maxPos=j;
                }
            }
                int temp = arr[maxPos];
                arr[maxPos]= arr[i];
                arr[i]= temp;
            }
        }
    public static void array(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void insertionSort(int arr[]){
        //time complexity O(N^2)
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
                while(prev>=0&& arr[prev]<curr){
                    arr[prev+1]= arr[prev];
                    prev--;
                }
                arr[prev+1] =curr;
            }
        } 
        public static void countingSortDescending(int arr[]){
            int largest=Integer.MIN_VALUE; 
            for(int i=0;i<arr.length;i++) {
                largest=Math.max(largest,arr[i]);
            }
            int count[] =new int[largest+1];
            for(int i=0;i<arr.length;i++) { 
                count[arr[i]]++;
            }
            int j=0;
            for(int i=count.length-1;i>=0;i--) { 
                while(count[i] >0) {
                    arr[j] =i;
                    j++;
                    count[i]--;
                }
            }
            }
    public static void main(String args[]){
        int arr[] = {5,1,4,3,2};
        //bubbleSort(arr);
        //selectionSort(arr);
        insertionSort(arr);
        array(arr);
    }
}
