import java.util.*;
public class QueuePrbs {
    public static void printNonRepeating(String str){
        int freq[] = new int [26]; //'a'-'z'
        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    public static void interleave(Queue<Integer>q){
       Queue<Integer> firstHalf = new LinkedList<>();
       int size = q.size();

       for(int i=0;i<size/2;i++){
        firstHalf.add(q.remove());
       }

       while(!firstHalf.isEmpty()){
        q.add(firstHalf.remove());
        q.add(q.remove());
       }

    }

    public static void reverse(Queue<Integer>q){
       Stack<Integer> s = new Stack<>();

       while(!q.isEmpty()){
        s.push(q.remove());
       }
       while(!s.isEmpty()){
        q.add(s.pop());
       }
    }

    //REVERSING FIRST K ELEMENTS OF A QUEUE
    public static void reverseKElements(Queue<Integer> q, int k){
        Queue<Integer> q1 = new LinkedList<>();
        Stack<Integer> s1 = new Stack<>();
        int count = 0;
        while(count<k){
           s1.push(q.remove());
            count++;
        }

        while(!q.isEmpty()){
            q1.add(q.remove());
        }

        while(!s1.isEmpty()){
            q.add(s1.pop());
        }

        while (!q1.isEmpty()) {
            q.add(q1.remove());
        }

    }
    public static void main(String[] args) {
        //REVERSING FIRST K ELEMENTS OF A QUEUE
        Queue<Integer> q = new LinkedList<>();
        int k = 5;
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        reverseKElements(q, k);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
       System.out.println();

        //NON REPEATING LETTER
        // String str = "aabccxb";
        // printNonRepeating(str);

        //INTERLEAVE TWO HALVES OF QUEUE
        /*Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interleave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
       System.out.println();*/


       /*//QUEUE REVERSAL
       Queue<Integer> q = new LinkedList<>();
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
       reverse(q);

       while(!q.isEmpty()){
        System.out.print(q.remove()+" ");
       }
       System.out.println();*/
    }
}
