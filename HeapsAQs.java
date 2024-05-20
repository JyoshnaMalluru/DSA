import java.util.*;
public class HeapsAQs{
//     public static void mergeKSortedLists(LinkedList<Integer>List1,LinkedList<Integer>List2,LinkedList<Integer>List3){
//         PriorityQueue<Integer> pq= new PriorityQueue<>();
//         pq.addAll(List1);
//         pq.addAll(List2);
//         pq.addAll(List3);
//         while (!pq.isEmpty()) {
//             System.out.print(pq.poll()+"->");
//         }
//         System.out.print("null");
//     }
//     public static void main(String[] args) {
//         int k = 3;
//         int N= 3;
//         LinkedList<Integer> List1= new LinkedList<>();
//         List1.add(1);
//         List1.add(3);
//         List1.add(7);
//         LinkedList<Integer>List2 = new LinkedList<>();
//         List2.add(2);
//         List2.add(4);
//         List2.add(8);
//         LinkedList<Integer>List3 = new LinkedList<>();
//         List3.add(9);
//         List3.add(10);
//         List3.add(11);
//         mergeKSortedLists(List1,List2,List3);
//     }
// }

// // import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a min-heap to store the first element from each list
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Initialize the heap with the first elements from all lists
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Dummy head for the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Pop the smallest element from the heap and add it to the merged list
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // If there's a next element in the same list, insert it into the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    // Helper function to print a linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        //MergeKSortedLists solution = new MergeKSortedLists();
        

        // Sample input lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(8);

        ListNode list3 = new ListNode(9);
        list3.next = new ListNode(10);
        list3.next.next = new ListNode(11);

        ListNode[] lists = {list1, list2, list3};

        // Merge the lists
        ListNode mergedList = solution.mergeKLists(lists);

        // Print the merged list
        solution.printList(mergedList);
    }
}
