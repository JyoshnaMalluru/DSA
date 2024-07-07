import java.util.*;
import java.util.LinkedList;
public class BinaryTrees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            this.left = null;
            this.right = null;
        }
    }
   static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left= buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }
        
    
       public static void preOrder(Node root){//O(n)
        if(root == null){
            //System.out.print("-1 ");
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
        }
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

       // LEVEL ORDER TRAVERSAL
        public static void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue <Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                     if(currNode.left!=null){
                        q.add(currNode.left);
                     }
                     if(currNode.right!=null){
                        q.add(currNode.right);
                     }
                }
            }
        }
        
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh= height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount+rightCount+1;
    }
    public static int nodesSum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum = nodesSum(root.left);
        int rightSum = nodesSum(root.right);
        return leftSum+rightSum+root.data;
    }

    //DIAMETER OF A TREE
    //APPROACH-1
    public static int diameter2(Node root){//O(n^2)
        if(root == null){
            return 0;
        }

        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt+rightHt+1;
        return Math.max(selfDiam,Math.max(leftDiam,rightDiam));
    }

    //APPROACH-2
    // static class Info{
    //     int diam;
    //     int ht;
    //     public Info(int diam,int ht){
    //        this.diam= diam;
    //        this.ht = ht;
    //     }
    // }
    // public static Info diameter(Node root){//O(n)
    //     if(root ==null){
    //         return new Info(0,0);
    //     }
    //     Info leftInfo = diameter(root.left);
    //     Info rightInfo = diameter(root.right);
    //     int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
    //     int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;
    //     return new Info(diam, ht);

    // } 

    //SUBTREE OF ANOTHER TREE
    public static boolean isIdentical(Node node, Node subroot){
        if(node == null && subroot == null){
            return true;
        }else if(node == null || subroot == null || node.data != subroot.data){
            return false;
        }

        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    } 

    //TOP VIEW OF A TREE
    static class Info{
        Node node;
        int hd;
        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        //level order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        
        int min =0 , max =0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node);
            }
            if(curr.node.left != null){
                q.add(new Info(curr.node.left, curr.hd-1));
                min = Math.min(min,curr.hd-1);
            }
            if(curr.node.right != null){
                q.add(new Info(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }
    }
        for(int i=min; i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    //Kth LEVEL OF A TREE
    public static void KthLevel(Node root,int level,int k){
        if(root == null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        KthLevel(root.left,level+1,k);
        KthLevel(root.right, level+1, k);
    }
     
    public static void KlevelNums(Node root, int k){
        int level = 1;
        if(root == null){
            return;
        }
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null){
               if(q.isEmpty()){
                break;
               }else{
                q.add(null);
                level++;
               }
            }else{
                if(level == k){
                    System.out.print(currNode.data+" ");
                }
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

    }

    //LOWEST COMMON ANCESTOR
    //Approach 1
    public static boolean getPath(Node root, int n,ArrayList<Node> path){
        if(root ==null){
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        //last common ancestor
        int i=0;
        for(;i<path1.size()&& i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }

    //APPROACH2
    public static Node lca2(Node root, int n1, int n2){
        if(root == null || root.data ==n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        if(rightlca == null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }
        return root;
    }

    //MINIMUM DISTANCE BETWEEN NODES
    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist==-1 && rightDist==-1){
            return -1;
        }
        else if(leftDist==-1){
            return rightDist+1;
        }else {
            return leftDist+1;
        }

    }
    public static int minDist(Node root , int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1+dist2;
    }

    //Kth Ancestor of node
    public static int KthAncestor(Node root,int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);

        if(leftDist ==-1 && rightDist==-1){
            return -1;
        }
        int max = Math.max(leftDist,rightDist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max +1;
    }

    //Transform to sum tree
    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
         
        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0: root.right.data;
        
        root.data = newLeft+ leftChild+newRight+ rightChild;
        return data;

    }
    public static void preOrder(Node root){//O(n)
        if(root == null){
            //System.out.print("-1 ");
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
        }
    public static void main(String args[]){
        int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
         System.out.println(root.data);
        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        //tree.levelOrder(root);

        /*
         *             1
         *           /   \
         *          2     3
         *         / \   / \
         *        4   5 6   7
         */

        //  Node root= new Node(1);
        //  root.left = new Node(2);
        //  root.left.left= new Node(4);
        //  root.left.right = new Node(5);
        //  root.right = new Node(3);
        //  root.right.left= new Node(6);
        //  root.right.right = new Node(7);
       
        //   System.out.println(height(root));
        //   System.out.println(count(root));
        //   System.out.println(nodesSum(root));

        //PROBLEMS
        // int n1 =4 , n2 = 5;
        // System.out.println(minDist(root, n1, n2));
        // System.out.println(diameter2(root));
        // System.out.println(diameter(root).diam);
         //topView(root);
         //KthLevel(root, 1, 3);
        //  //KlevelNums(root,3);
        //  int n1 =4 , n2 = 5;
        //  System.out.println(lca(root, n1, n2).data);
        //  System.out.println(lca2(root, 4, 7).data);
        //  int n=4 , k =2;
        //  KthAncestor(root,n,k);

        //  transform(root);
        //  preOrder(root);
        //  Node subroot = new Node(2);
        //  subroot.left = new Node(4);
        //  subroot.right = new Node(5);

        //  /*
        //   *             2
        //                / \
        //               4   5
        //   */


        //  System.out.println(isSubtree(root,subroot));
    }
}

