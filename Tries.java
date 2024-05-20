import java.util.*;
public class Tries {
    static class Node{
     Node Children [] = new Node[26];
     boolean eOW = false;

     public Node(){
        for(int j =0;j<26;j++){
            Children[j] =null;
        }
     }
    }

    public static Node root = new Node();
//INSERT
    public static void insert(String word){//O(L)
        Node curr = root;
        for(int level =0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.Children[idx]==null){
                curr.Children[idx]=new Node();
            }
            curr = curr.Children[idx];
        }
        curr.eOW = true;
    }

    //SEARCH
    public static boolean search(String key){//O(L)
        Node curr = root;
        for(int level =0;level<key.length();level++){
            int idx =key.charAt(level)-'a';
            if(curr.Children[idx]==null){
                return false;
            }
            curr = curr.Children[idx];
        }
        return curr.eOW == true;
    }

    //WORD BREAK PROBLEM
    public static boolean wordBreak(String key){//O(L)
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //String Words[] = {"the","a","their","they","any","thee"};
        String Words[] = {"i","like","sam","samsung","mobile","ice"};
         for(int i =0;i<Words.length;i++){
            insert(Words[i]);
         }

        //  System.out.println(search("any"));
        //  System.out.println(search("an"));

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
