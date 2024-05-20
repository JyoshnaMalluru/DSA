import java.util.*;
public class HashSetPrbs {
     //FIND ITERNARY FROM TICKETS
    public static String  getStart(HashMap<String,String> tickets ){
        HashMap<String ,String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key),key);
        }

        for (String key : tickets.keySet()) {
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
       }
    public static void main(String args[]){

        //COUNT DISTINCT ELEMENTS
        int arr[] ={4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> nums = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            nums.add(arr[i]);
        }

        // System.out.print(nums);
        // System.out.println();
        // System.out.println("Distinct Count is "+ nums.size());


        //UNION AND INTERSECTION OF TWO ARRAYS
        int arr1[] ={7,3,9};
        int arr2[] ={6,3,9,2,9,4};

        HashSet<Integer> set = new HashSet<>();
    
        //UNION
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }

        //System.out.println("Union count "+set.size());
        for (Integer val : set) {
           //System.out.println(val);
        }

        //INTERSECTION
        set.clear();
        int count =0;
        for(int i=0;i<arr1.length;i++){
          set.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
          if(set.contains(arr2[i])){
            count++;
            set.remove(arr2[i]);
          }
        }
        //System.out.println("Intersection "+count);

       //FIND ITERNARY FROM TICKETS

       HashMap <String, String> tickets = new HashMap<>();
       tickets.put("Chennai","Bengaluru");
       tickets.put("Mumbai","Delhi");
       tickets.put("Goa","Chennai");
       tickets.put("Delhi", "Goa");

       String start = getStart(tickets);
       //System.out.print(start);
       for (String key : tickets.keySet()) {
          // System.out.print("->"+tickets.get(start));
           start = tickets.get(start);
       }
       System.out.println();



      //LARGEST SUBARRAY WITH SUM ZERO
        int array[] = {15,-2,2,-8,1,7,10,23}; //O(n)

        HashMap<Integer,Integer> map = new HashMap<>();
        //(Sum,Index)

        int sum =0;
        int len =0;

        for(int j=0;j<array.length;j++){
            sum+=array[j];

            if(map.containsKey(sum)){
                len = Math.max(len,j-map.get(sum));
            } else {
                map.put(sum,j);
            }
        }
        System.out.println("Larget sub array length with sum 0 => "+len);


         //LARGEST SUBARRAY WITH SUM K
         int num[] = {10,2,-2,-20,10};
         int k = -10;

         HashMap<Integer,Integer> maps = new HashMap<>();
         //(sum , count)
         maps.put(0,1);
         int addition =0;
         int ans =0;
         
         for(int j=0;j<num.length;j++){
            addition+=num[j];
            if(maps.containsKey(addition-k)){
               ans+=maps.get(addition-k);
            }
            maps.put(addition,maps.getOrDefault(addition, 0)+1);
         }
         System.out.println("Larget sub array length with sum K => "+ans);
    }
}
