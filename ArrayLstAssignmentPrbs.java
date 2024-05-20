import java.util.*;
public class ArrayLstAssignmentPrbs {
    public static boolean isMonotonic(ArrayList<Integer>list){
        boolean inc = true;
        boolean dec = true;
        for(int idx=0;idx<list.size()-1;idx++){
            if(list.get(idx)>list.get(idx+1)){
                inc =false;
            }
            if(list.get(idx)<list.get(idx+1)){
                dec= false;
            }
        }
        return inc||dec;
    }
    public static void lonelyNum(ArrayList<Integer>numlist){
        ArrayList<Integer>currList= new ArrayList<>();
        for(int idx=0;idx<=numlist.size()-1;idx++){
            for(int nxtidx=idx+1;nxtidx<=numlist.size()-1;nxtidx++){
               if((numlist.get(idx))+1!=numlist.get(nxtidx)||(numlist.get(idx))-1!=numlist.get(nxtidx)){
                  currList.add(numlist.get(idx));
               }
            }
        }
        System.out.println(currList);
    }
    public static void main(String args[]){
        ArrayList<Integer>list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(isMonotonic(list));


        ArrayList<Integer>numlist= new ArrayList<>();
        numlist.add(10);
        numlist.add(6);
        numlist.add(5);
        numlist.add(8);
        lonelyNum(numlist);

    }
}
