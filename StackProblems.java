import java.util.*;
class StackProblems {
    /*class Node {
    int data;
    Node ptr;
    Node(int d){
        ptr = null;
        data = d;
    }
}*/
/*static boolean isPalindrome(Node head){
        Node slow = head;
        boolean ispalin = true;
        Stack <Integer> stack = new Stack<Integer>();
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.ptr;
        }
        while (head != null) {
            int i = stack.pop();
            if (head.data == i) {
                ispalin = true;
            }else {
                ispalin = false;
                break;
            }head = head.ptr;
        }return ispalin;
    }*/

    /*public static void main(String args[]){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        four.ptr = five;
        five.ptr = six;
        six.ptr = seven;
        boolean condition = isPalindrome(one);
        System.out.println("Palindrome :" + condition);
    }
    /*public  String simplifyPath(String path){
        String paths[] = path.split("/");
        Stack<String> stk = new Stack<>();
        for(int idx = 0; idx<paths.length;idx++){
            if(paths[idx].equals(".")){
               continue;
            }else if(paths[idx].equals(" ")){
                continue;
            }else if(paths[idx].equals("..")){
                if(stk.size()>0){
                    stk.pop();
                }else{
                    stk.push(paths[idx]);
                }
            }
            String res = "";
            while (stk.size()>0) {
                String folder = stk.pop();
                res = "/"+folder+res;
                if(res.length()==0){
                    return"/";
                }
                return res;
            }
        }
    }
    public static void main(String[] args) {
        String path = "/c//d/./songs/../songs/tiger3/";
        System.out.println(simplifyPath(path));
    }*/
    public static int TrappingRainWater(int arr[]){
       int lge[] = new int[arr.length];
       int rge[] = new int [arr.length];
       Stack <Integer> s = new Stack<>();
       //left greatest element

       for(int i=0;i<arr.length;i++){
        while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            lge[i]=-1;
        }else{
            lge[i] = arr[s.peek()];
        }
        s.push(i);
       }
       s.clear();
       //right greatest element
       s= new Stack<>();
    
       for(int i=arr.length-1;i>=0;i--){
        while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            rge[i]=-1;
        }else{
            rge[i] = arr[s.peek()];
        }
        s.push(i);
       }

       int trappedWater = 0;
       for(int i=0;i<arr.length;i++){
        if(lge[i] != -1 && rge[i] != -1){
        int waterLevel = Math.min(lge[i],rge[i]);
        trappedWater+=waterLevel-arr[i];
       }
    }
       return trappedWater;
    }
    public static void main(String args[]){
        int arr[] = {7,0,4,2,5,0,6,4,0,5};
        System.out.println(TrappingRainWater(arr));
    }
}