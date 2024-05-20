import java.util.HashSet;
import java.util.*;

public class HashingTwo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(2);
        set.add(1);
        

        System.out.println(set);

        // if(set.contains(3)){
        //     System.out.println("Contains 3");
        // }

        // if(!set.contains(4)){
        //     System.out.println("Not Contains 4");
        // }
        // // //set.clear();
        // set.remove(2);
        // System.out.println(set);
        // System.out.println(set.size());
        // set.clear();
        // System.out.println(set.isEmpty());


        //ITERATION ON HASHSETS
        // HashSet<String> set = new HashSet<>();
        // set.add("Delhi");
        // set.add("Hyderabad");
        // set.add("Banglore");
        // set.add("Chennai");

        //System.out.println(set);
       
        //USING ITERATORS
        // Iterator it = set.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();

        // //USING ENHANCED FOR LOOP
        // for(String city : set){
        //     System.out.println(city);
        // }

        //LINKED HASHSET
        // LinkedHashSet<String> cities = new LinkedHashSet<>();
        // cities.add("Delhi");
        // cities.add("Hyderabad");
        // cities.add("Banglore");
        // cities.add("Chennai");
        // System.out.println(cities);
        // cities.remove("Delhi");
        // System.out.println(cities);

        //TREE SET
        TreeSet <String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Hyderabad");
        ts.add("Banglore");
        ts.add("Chennai");

        System.out.println(ts);
    }
}
