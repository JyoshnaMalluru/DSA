import java.util.*;
public class BinaryTreesAssigmentPrbs {
    static class Node{
        int data;
        Node left;
        Node right;
         public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //UNIVALUED TREE
    public static boolean univaluedTree(Node root){
       if(root == null){
        return true;
       }
       if(root.left != null && root.left.data != root.data){
         return false;
       }
       if(root.right != null && root.right.data != root.data){
        return false;
       }
       return univaluedTree(root.left)&&univaluedTree(root.right);
    }
    //INVERT BINARY TREE
    public static Node invertedBinaryTree(Node root){
        if(root == null){
            return root;
    }
    Node left = invertedBinaryTree(root.left);
    Node right = invertedBinaryTree(root.right);
    
    root.left = right;
    root.right = left;

    return root;
}
public static void inOrder(Node root){
    if(root == null){
        return;
    }
    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);
}

//DELETE LEAF NODES WITH VALUE AS X
public static Node deleteLeafNode(Node root, int x){
    if(root == null){
        return null;
    }
    root.left = deleteLeafNode(root.left,x);
    root.right = deleteLeafNode(root.right,x);
    if(root.data == x && root.left == null && root.right == null){
        return null;
    }
    return root;
}

//MAXIMUM PATH SUM IN A BINARY TREE
public static int maxSum(Node root,int res){
   
    if(root == null){
        return 0;
    }
    int leftSum = maxSum(root.left,res);
    int rightSum= maxSum(root.right,res);
    int max_Single = Math.max(Math.max(leftSum,rightSum)+root.data,root.data);
    int max_top = Math.max(max_Single,leftSum+rightSum+root.data);
    res = Math.max(res,max_top);
    return res;
}
    public static void main(String args[]){
        //UNIVALUED TREE
        // Node root = new Node(2);
        // root.left = new Node(2);
        // root.right = new Node(2);
        // root.left.left = new Node(2);
        // root.left.right= new Node(2);
        // if(univaluedTree(root)){
        //     System.out.print("Yes");
        // }else{
        //     System.out.print("No");
        // }

        //INVERTED BINARY TREE
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right= new Node(5);
        // root.right.left = new Node(6);
        // root.right.right= new Node(7);
        // inOrder(root);
        // invertedBinaryTree(root);
        // System.out.println();
        // inOrder(root);
    
    //DELETE LEAF NODES WITH VALUE AS X
        //  Node root = new Node(1);
        //  root.left = new Node(3);
        //  root.right = new Node(3);
        //  root.left.left = new Node(3);
        //  root.left.right = new Node(2);
        //  inOrder(root);
        //  deleteLeafNode(root,3);
        //  inOrder(root);

        //FIND ALL DUPLICATES SUBTREES
        // Node root = new Node (1);
        // root.left = new Node(4);
        // root.right = new Node(3);
        // root.left.left = new Node (3);
        // root.right.left = new Node(4);
        // root.right.left.left = new Node(3);
        // root.right.right = new Node(3);
        // System.out.print(duplicateTrees(root));


        //MAXIMUM PATH SUM IN A BINARY TREE
        // Node root = new Node(4);
        // root.left = new Node(2);
        // root.right = new Node(7);


        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        int res = Integer.MIN_VALUE;
        System.out.println(maxSum(root,res));
    }
}
