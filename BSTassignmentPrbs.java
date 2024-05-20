import java.util.*;
import java.util.LinkedList;
public class BSTassignmentPrbs {
    static class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data= data;
            this.left = this.right = null;
        }
    } 
    public static Node root ;
    static int sum = 0;
    public static Node insert(Node root , int val){
        if (root == null){
            return root;
        }
        if(val < root.data){
            insert(root.left, val);
        }else{
            insert(root.right, val);
        }
        return root;
    }
    public static int BSTsum(Node root , int low , int high){
        if(root == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
           Node curr=q.peek();
            q.remove();
            if(curr.data >= low && curr.data <=high){
                sum += curr.data;
            }
            if(curr.left != null && curr.data > low){
                q.add(curr.left);
            }
            if(curr.right != null && curr.data <high){
                q.add(curr.right);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 8);
        insert(root, 5);
        insert(root, 11);
        insert(root, 3);
        insert(root, 6);
        insert(root, 20);
        System.out.println(BSTsum(root, 9, 15));
    }
}