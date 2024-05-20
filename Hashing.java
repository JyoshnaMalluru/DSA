import java.util.*;
public class Hashing {
    public static void main(String[] args) {
        //Create
        // HashMap<String,Integer> hm = new HashMap<>();
        
        // // Insert  O(1)
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("USA", 50);
        
        // System.out.println(hm);


        // //get - O(1)
        // int population = hm.get("India");
        // System.out.println(population);
        // System.out.println(hm.get("pakisthan"));

        // // //Contains- O(1)
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Indonesia"));

        //remove - O(1)
        // System.out.println(hm.remove("China"));
        // System.out.println(hm);
        // System.out.println(hm.remove("Indonesia"));
        // System.out.println(hm);

        //Size
        // System.out.println(hm.size());

        // // isEmpty
        // //hm.clear();
        // System.out.println(hm.isEmpty());

        // //Iterate - O(1)
        // Set <String> keys = hm.keySet();
        // System.out.println(keys);

        // for (String k : keys) {
        //     System.out.println("key="+k+",value="+hm.get(k));
        // }

        //LINKED HASHMAP
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        
        // Insert  O(1)
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("USA", 50);
        
        System.out.println(lhm);

//         //TREE MAP
        TreeMap<String,Integer> tm = new TreeMap<>();
        
        // Insert  O(1)
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("USA", 50);
        
        System.out.println(tm);
      }
 }
