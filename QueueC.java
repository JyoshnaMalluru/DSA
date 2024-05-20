import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class QueueC {
    //QUEUE USING ARRAy

    // static class QueueA{
    //     static int arr[];
    //     static int size;
    //     static int rear;

    // QueueA(int n){
    //     arr = new int[n];
    //     size = n;
    //     rear = -1;
   
    // }
    // public static boolean isEmpty(){
    //     return rear== -1  ;
    // }

    
    // // add
    // public static void add(int data){
    //     if(rear==size-1){
    //         System.out.println("queue is full");
    //         return;
    //     }
    //     rear = rear+1;
    //     arr[rear]= data;
    // }

    // //remove 
    // public static int remove(){
    //     if(isEmpty()){
    //         System.out.println("queue is empty");
    //         return-1;
    //     }
    //     int front = arr[0];
    //     for(int i=0;i<rear;i++){
    //         arr[i]=arr[i+1];
    //     }
    //     rear = rear-1;
    //     return front;
    // }

    // //peek
    // public static int peek(){
    //     if(isEmpty()){
    //         System.out.println("queue is empty");
    //         return-1;
    //     }
    //     return arr[0];
    // }
    // }




// CIRCULAR QUEUE ARRAY
    // static class QueueA{
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;

    // QueueA(int n){
    //     arr = new int[n];
    //     size = n;
    //     rear = -1;
    //     front = -1;
    // }
    // public static boolean isEmpty(){
    //     return rear== -1 && front ==-1 ;
    // }

    // public static boolean isFull(){
    //     return (rear+1)%size == front;
    // }

    // // add
    // public static void add(int data){
    //     if(isFull()){
    //         System.out.println("queue is full");
    //         return;
    //     }
    //     //add first element
    //     if(front == -1){
    //         front = 0;
    //     }
    //     rear = (rear+1)%size;
    //     arr[rear]= data;
    // }

    // //remove 
    // public static int remove(){
    //     if(isEmpty()){
    //         System.out.println("queue is empty");
    //         return-1;
    //     }
    //     int result = arr[front];
    //     //last element delete
    //     if(rear == front){
    //         rear = front = -1;
    //     }else{
    //         front = (front+1)%size;
    //     }

    //     return result;
    // }


    //  //peek
    // public static int peek(){
    //     if(isEmpty()){
    //         System.out.println("queue is empty");
    //         return-1;
    //     }
    //     return arr[front];
    // }
    // }


    //  QUEUE USING LINKED LIST
    //   static class Node{
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    //   }
    // static class QueueA{
    //     static Node head = null;
    //     static Node tail = null;
    // public static boolean isEmpty(){
    //     return head ==null && tail == null;
    // }


    // // add
    // public static void add(int data){
    //     Node newNode = new Node(data);
    //     if(head == null){
    //         head = tail = newNode ;
    //         return;
    //     }
    //     tail.next = newNode;
    //     tail = newNode;
    // }

    // //remove 
    // public static int remove(){
    //     if(isEmpty()){
    //         System.out.println("queue is empty");
    //         return-1;
    //     }
    //     int front = head.data;
    //     // single element
    //     if(head == tail){
    //         tail = head = null;
    //     }else{
    //         head = head.next;
    //     }
    //     return front;
    // }


    //  //peek
    // public static int peek(){
    //     if(isEmpty()){
    //         System.out.println("queue is empty");
    //         return-1;
    //     }
    //     return head.data;
    // }
    // }


    // queue using two stacks
     static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
               s1.push(s2.pop());
            }
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            return s1.pop();
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return s1.peek();
        }
     }



     // STACK USING TWO QUEUES
     static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top =-1;

            //case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top= q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{// case 2
              while(!q2.isEmpty()){
                    top= q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top =-1;

            //case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top= q1.remove();
                    q2.add(top);
                }
            }else{// case 2
              while(!q2.isEmpty()){
                    top= q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }
   

    public static void main(String[] args) {
        //QueueA q = new QueueA();
        //Queue <Integer> q = new LinkedList<>();//we can also use Arraydeque
        //Queue <Integer> q = new ArrayDeque<>();

        
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // For circular queue usage 
        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);


        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //      q.remove();
        // }

         Stack s = new Stack();
         s.push(1);
         s.push(2);
         s.push(3);

         while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
         }

    }
}

