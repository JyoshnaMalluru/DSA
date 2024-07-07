import java.util.*;
public class TriesPrbs {
    static class Node{
        Node children [] = new Node[26];
        boolean eOW = false;
        int freq;
        public Node(){
            for(int i=0;i<children.length;i++){
                    children[i] = null;
            }
            freq =1;
        }
    }

    public static Node root = new Node();
    //Insert 
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] =new Node();
            }else{
            curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eOW = true;
    }


    public static boolean search(String word){
        Node curr = root;
         int idx =0;
        int i=0;
        for(;i<word.length();i++){
           idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eOW==true;
    }

    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;

    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count =0;
        for(int i=0;i<26;i++){
            if(root.children != null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static void findPrefix(Node root,String ans){//O(l)
        if(root == null){
            return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!= null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static String ans = "";

    // public static void longestWord(Node root, StringBuilder temp){
    //     if(root == null){
    //         return;
    //     }
    //     for(int i=0;i<26;i++){
    //         if(root.children[i] != null && root.children[i].eOW == true){
    //             char ch = (char)(i+'a');
    //             temp.append(ch);
    //             if(temp.length() > ans.length()){
    //                 ans = temp.toString();
    //             }
    //             longestWord(root.children[i], temp);
    //             temp.deleteCharAt(temp.length()-1);
    //         }
    //     }
    // }
    public static void main(String[] args) {
        String arr[] = {"zebra","dog","duck","dove"};
        for(int i =0;i<arr.length;i++ ){
            insert(arr[i]);
        }
        root.freq= -1;
        findPrefix(root,"");


        // String words[] = {"apple","app","man","mango","woman"};
        // String prefix1 = "app";
        // String prefix2 = "maan";

        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }

        //System.out.println(startsWith(prefix1));
        /*System.out.println(startsWith(prefix2));*/

        // String str = "ababa";

        // // //suffix -> insert in trie
        // for(int i=0;i<str.length();i++){
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countNodes(root));


        // String str []= {"a","banana","app","ap","appl","apply","apple"};

        // for(int i=0;i<str.length;i++){
        //     insert(str[i]);
        // }
        // longestWord(root, new StringBuilder(""));
        // System.out.println(ans);

    }
}
