public class AVLtrees{
    static class Node{
        int data , height;
        Node left, right;

        Node(int data){
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int key){
        if(root == null){
            return new Node(key);
        }

        if(root.data>key){
           root.left = insert(root.left, key);
        }else if(root.data < key){
            root.right = insert(root.right, key);
        }else {
            return root; // Duplicate keys not allowed
        }

        //Update root Height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        //get roots balance factor
        int bf = getBalance(root);

        //Left Left case
        if(bf >1 && key< root.left.data){
            return rightRotate(root);
        }

        //right right case 
        if(bf< -1 && key >root.right.data){
            return leftRotate(root);
        }

        //left right case
        if(bf > 1 && key >root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        //right left case
        if(bf< -1 && key >root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate;
        }

        return root;
    }
    public static void main(String[] args) {
        root = insert(root,10);
        root = insert(root,20);
        root = insert(root,30);
        root = insert(root,40);
        root = insert(root,50);
        root = insert(root,25);

        preOrder(root);
    }
}