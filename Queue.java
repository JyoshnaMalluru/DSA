import java.util.*;
public class QueueB {
    //QUEUE USING ARRAY

    static class QueueA{
        static int arr[];
        static int size;
        static int rear;

    QueueA(int n){
        arr = new int[n];
        size = n;
        rear = -1;
   
    }
    public static boolean isEmpty(){
        return rear== -1  ;
    }

    
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
    }

   

    public static void main(String[] args) {
        //QueueA q = new QueueA();
        Queue <Integer> q = new LinkedList<>();//we can also use Arraydeque
        q.add(1);
        q.add(2);
        q.add(3);

        // For circular queue usage 
        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);


        while(!q.isEmpty()){
            System.out.println(q.peek());
             q.remove();
        }
    }
}
