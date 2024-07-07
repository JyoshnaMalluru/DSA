import java.util.*;
import java.util.ArrayList;
public class TwoDArrayList {
    public static boolean pairSum1(ArrayList<Integer>list,int target){
        //TWO POINTER APPROACH
        //TIME COMPLEXITY O(N)
        int lp=0;
        int rp=list.size()-1;
        while(lp!=rp){
            //CASE 1
            if(list.get(lp)+list.get(rp)==target){
                return true;
                //CASE 2
            }else if(list.get(lp)+list.get(rp)<target){
                lp++;
                //CASE 3
            } else {
                rp--;
            }
        }
        return false;
    }
    public static boolean pairSum(ArrayList<Integer>list,int target){
        //BRUTE FORCE
        //TIME COMPLEXITY O(N^2)
        for(int dgt1=0;dgt1<=list.size();dgt1++){
            for(int dgt2=dgt1+1;dgt2<=list.size();dgt2++){
                if(list.get(dgt1)+list.get(dgt2)==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static int storeWater(ArrayList<Integer>height){
        //TWO POINTERS METHOD
        //TIME COMPLEXITY O(n)
        int maxWater =0;
        int lp=0;
        int rp=height.size()-1;
        while(lp<rp){
        int ht= Math.min(height.get(lp),height.get(rp));
        int width= rp-lp;
        int currWater= ht*width;
        maxWater=Math.max(maxWater,currWater);
        if(height.get(lp)<height.get(rp)){
         lp++;
        }else{
            rp--;
        }
    }
        return maxWater;
    }
    public static int waterContain(ArrayList<Integer>height){
        
        //TIME COMPLEXITY O(n^2)
        //BRUTE FORCE
        int maxWater=0;
        for(int l1=0;l1<height.size();l1++){
            for(int l2=l1+1;l2<height.size();l2++){
               int ht= Math.min(height.get(l1),height.get(l2));
               int width= l2-l1;
               int currWater= ht*width;
               maxWater=Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }
    public static boolean pairSum2(ArrayList<Integer>list,int target){
        //TIME COMPLEXITY O(N)
        // TWO POINTERS METHOD
        int breakpt =-1;
        int n= list.size();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                breakpt=i;
                break;
            }
        }
        int lp=breakpt+1;
        int rp = breakpt;
        while(lp!=rp){
         if(list.get(lp)+list.get(rp)==target){
            return true;
         }

         if(list.get(lp)+list.get(rp)>target){
            rp=(n+rp-1)%n;
         }else{
            lp=(lp+1)%n;
         }
        }
        return false;
    }
    public static void main(String args[]){
        // ArrayList<Integer>list = new ArrayList<>();
        // // 11 15 6 8 9 10
        // list.add(11);
        // list.add(15);
        // list.add(6);
        // list.add(8);
        // list.add(9);
        // list.add(10);
        // int target = 100;
        // System.out.println(pairSum2(list,target));


        // //1 2 3 4 5 6 
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // System.out.println(pairSum1(list,target));
       // System.out.println(pairSum(list,target));


        ArrayList<Integer>height= new ArrayList<>();
        //1,8,6,2,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(waterContain(height));
        System.out.println(storeWater(height));


        //TWO D ARRAYLIST 
        //ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        mainList.add(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);
        mainList.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(6);
        list3.add(9);
        list3.add(12);
        list3.add(15);
        mainList.add(list3);

        for(int lst=0;lst<mainList.size();lst++){
            ArrayList<Integer> currList = mainList.get(lst);
            for(int idx=0;idx<currList.size();idx++){
                System.out.print(currList.get(idx)+" ");
            }
            System.out.println();
        }
        System.out.println(mainList);*/


    //     ArrayList<Integer> listA = new ArrayList<>();
    //     ArrayList<Integer> listB = new ArrayList<>();
    //     ArrayList<Integer> listC = new ArrayList<>();
    //      for(int num=1;num<=5;num++){
    //         listA.add(1*num);
    //         listB.add(2*num);
    //         listC.add(3*num);
    //      }
    //      mainList.add(listA);
    //      mainList.add(listB);
    //      mainList.add(listC);
    //      listB.remove(2);
    //      listB.remove(3);
    //      for(int lst=0;lst<mainList.size();lst++){
    //         ArrayList<Integer> currList = mainList.get(lst);
    //         for(int idx=0;idx<currList.size();idx++){
    //             System.out.print(currList.get(idx)+" ");
    //         }
    //         System.out.println();
    //     }
    //      System.out.println(mainList);

     }
}
