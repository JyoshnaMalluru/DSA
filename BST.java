import java.util.*;

import DequeA.stack;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            this.left = this.right = null;
        }
    } 
    public static Node insert(Node root, int val){
        if(root == null){
            root  = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data>key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root,int val){
        if(root.data < val){
             root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            //case-1:no child
            if(root.left == null && root.right == null){
                return null;
            }
            //case-2:one child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
                //case-3:two child
            }else{
                Node IS = findInOrderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data +" ");
            printInRange(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }else{
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer>path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.print("null");
        System.out.println();
    }
    public static void printRootToLeaf(Node root, ArrayList<Integer>path){
         if(root == null){
            return;
         }
         path.add(root.data);
         if(root.left == null && root.right == null){
            printPath(path);
         }

         printRootToLeaf(root.left, path);
         printRootToLeaf(root.right, path);
         path.remove(path.size()-1);
    }
    public static boolean ValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <=min.data){
            return false;
        }
        if(max != null && root.data>= max.data){
            return false;
        }
        return ValidBST(root.left, min, root) && ValidBST(root.right, root, max);
    }

    public static Node CreateMirror(Node root){
        if(root == null){
            return null;
        }

        Node leftMirror = CreateMirror(root.left);
        Node rightMirror = CreateMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node balancedBST(int arr[], int st, int end){
       if(st>end){
        return null;
       }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left= balancedBST(arr, st, mid-1);
        root.right= balancedBST(arr, mid+1, end);
        return root;
    }
    public static void getInOrder(Node root,ArrayList <Integer> inOrder){
        if(root == null){
            return;
        }
        getInOrder(root.left, inOrder);
        inOrder.add(root.data);
        getInOrder(root.right, inOrder);
    }
    
    public static Node createBST(ArrayList<Integer> inOrder, int st, int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(inOrder.get(mid));
        root.left = createBST(inOrder, st, mid-1);
        root.right = createBST(inOrder, mid+1, end);
        return root;
    }
    public static Node ConvertToBalancedBST(Node root){
        //inOrder sequence
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);
        //sorted Inorder -> Balanced BST
        root = createBST(inOrder, 0, inOrder.size()-1);
        return root;

    }
    public static Node mergeBST(Node root1,Node root2,ArrayList <Integer> inOrder){
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add()
    }

    static class Info{
        boolean isBST;
        int size;
        int max;
        int min;
        public Info(boolean isBST, int size, int max, int min){
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min= min;
        }
    }

    public static int maxBST =0;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size +1;
        int max = Math.max(root.data ,Math.max(leftInfo.max,rightInfo.max));
        int min = Math.min(root.data ,Math.min(leftInfo.min,rightInfo.min));
        if(root.data <= leftInfo.max || root.data >= rightInfo.max){
            return new Info(false,size,max,min);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST =Math.max(maxBST,size);
            return new Info(true, size, max, min) ;  
        }
        return new Info(false,size,max,min);
    }
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left= new Node(1);
        root1.right= new Node(3);

        Node root2 =new Node(7);
        root2.left = new Node(6);
        root2.right = new Node(8);
        //int values[] ={5,1,3,4,2,7};
        //int values[] ={1,2,3,4,5,6,7,8,9,10};
        //int values [] = {8,5,3,1,4,6,10,11,14};
        //Node root = null;
        // for(int i=0;i<values.length;i++){
        //     root = insert(root, values[i]);
        // }
        // inOrder(root);
        // System.out.println();

        // //System.out.println(search(root, 10));
        // root = delete(root, 8);
        // System.out.println();

        // inOrder(root);
        // System.out.println();

       
        /*
          *           8
                     / \
                    5   10
                   / \    \
                  3   6    11
          */
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.right = new Node(10);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right.right = new Node(11);
        //printInRange(root, 5, 12);
        //ArrayList<Integer> path = new ArrayList<>();
        // printRootToLeaf(root,new ArrayList<>());
        // printPath(path);
        // if(ValidBST(root, null, null)){
        //     System.out.println("VALID");
        //    }else{
        //     System.out.println("NOT VALID");
        //    }
        /*
         *                 8
         *                / \
         *               10  5
         *              /   / \
         *             11  6   3
         *             MIRROR BST
         */
        // root = CreateMirror(root);
        // preOrder(root);
        //int arr[] ={3,5,6,8,10,11,12};
         /*                8
         *                / \
         *               5   11
         *              /\   / \
         *             3  6  10 12   */
        //  Node root = balancedBST(arr, 0, arr.length-1);
        //  preOrder(root);

        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);

        // root.right = new Node(10);
        // root.right.right= new Node(11);
        // root.right.right.right = new Node(12);

        // root = ConvertToBalancedBST(root);
        // preOrder(root);

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left= new Node(45);
        root.right.right= new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        Info info = largestBST(root);
        System.out.println("largest BST value "+ maxBST);
        
    }
}
