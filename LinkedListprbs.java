import java.util.*;
public class LinkedListprbs {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
     //1st PROBLEM : INTERSECTION OF TWO LINKED LISTS
    public static Node intersectionPoint(Node head1, Node head2){
        while(head2!= null){
            Node temp = head1;
            while(temp != null){
                if(temp== head2){
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    } 
    // public class Solution {
    //     public int getSize(ListNode head){
    //         int counter = 0;
    //         ListNode curr = head;
    
    //         while(curr != null){
    //             counter++;
    //             curr = curr.next;
    //         }
    
    //         return counter;
    //     }
    
    //     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //         int sizeA = getSize(headA);
    //         int sizeB = getSize(headB);
    
    //         while(sizeA > sizeB){
    //             headA = headA.next;
    //             sizeA--;
    //         }
    
    //         while(sizeB > sizeA){
    //             headB = headB.next;
    //             sizeB--;
    //         }
    
    //         while(headA != headB){
    //             headA = headA.next;
    //             headB = headB.next;
    //         }
    
    //         return headA;
    //     }
    //}
    public static void main(String[] args) {
        //1st PROBLEM : INTERSECTION OF TWO LINKED LISTS

        // LinkedListprbs list = new LinkedListprbs();
        // Node head1, head2;
        
        // head1 =  new Node(4);
        // head2 = new Node(1);
        
        // Node newNode = new Node(5);
        // head1.next = newNode;

        // newNode = new Node(2);
        // head2.next = newNode;

        // newNode = new Node(3);
        // head2.next.next = newNode;

        // newNode = new Node(6);
        // head1.next.next = newNode;
        // head2.next.next.next= newNode;

        // newNode = new Node(7);
        // head1.next.next.next = newNode;
        // head2.next.next.next.next= newNode;

        // head1.next.next.next.next = null;
        // head2.next.next.next.next.next= null;

        // System.out.println(intersectionPoint(head1, head2).data);


        //DELETE N NODES AFTER M NODES IN A LINKED LIST
        static Node addAtHead(Node head, int val){
            Node node = new Node(val);
            node.next = head;
            return node;
        }

        Node head = new Node(100);
        head = addAtHead(head,90);
        head = addAtHead(head,80);
        head = addAtHead(head,70);
        head = addAtHead(head,60);
        head = addAtHead(head,50);
        head = addAtHead(head,40);
        head = addAtHead(head,30);
        head = addAtHead(head,20);
        head = addAtHead(head,10);

        LinkDelete(head, 3 ,2);
        while (head != null) {
            System.out.print(head.data+" ");
            head= head.next;
        }
       System.out.println();

    }
}
