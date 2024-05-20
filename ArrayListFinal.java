//import java.util.ArrayList;
//import java.util.Collections;
import java.util.*;
public class ArrayListFinal{
    public static void swap(ArrayList<Integer> list1,int idx1,int idx2){
        int temp = list1.get(idx1);
        list1.set(idx1,list1.get(idx2));
        list1.set(idx2,temp);
    }
    public static void main (String args[]){
        ArrayList<Integer> list1 =new ArrayList<>();

        //Add operation
        list1.add(1);//O(1)-TimeComplexity
        list1.add(2);
        list1.add(7);
        list1.add(4);
        list1.add(6);
        // System.out.println(list1);
        // Collections.sort(list1);
        // System.out.println(list1);
        // Collections.sort(list1,Collections.reverseOrder());
        System.out.println(list1);


        /*int idx1 = 1;int idx2=2;
        System.out.println(list1);
        swap(list1, idx1, idx2);
        System.out.println(list1);*/


        //list1.add(1,6);//O(n)-TimeComplexity
        //System.out.println(list1);


        //MAX_VALUE IN ARRAY
        /*int max = Integer.MIN_VALUE;//O(n)-TimeComplexity
        for(int i=0;i<list1.size();i++){
            //if(max<list1.get(i)){
            //  max=list1.get(i);
            //}
            max= Math.max(max,list1.get(i));
        }
        System.out.println(max);*/

        //size
        //System.out.println(list1.size());

        //print ArrayList
        /*for(int i=0;i<list1.size();i++){
            //O(n)-TimeComplexity
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();*/


        /*//print ArrayList in Reverse
        for(int i=list1.size()-1;i>=0;i--){
            //O(n)-TimeComplexity
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();*/


        /*//get Operation
        int element=list1.get(1);
        System.out.println(element);//O(1)-TimeComplexity*/


        /*//delete operation
        list1.remove(1);//O(n)-TimeComplexity
        System.out.println(list1);*/

        //set
        /*list1.set(2,10);
        System.out.println(list1);//O(n)-TimeComplexity*/
 
        //contains
        //System.out.println(list1.contains(1));//O(n)-TimeComplexity
        //System.out.println(list1.contains(11));
        
    }
}
 