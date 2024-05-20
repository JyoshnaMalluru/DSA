import java.util.LinkedList;
public class LLFrameworks {
    public static void main(String args[]){
        LinkedList<Integer> ll = new LinkedList<>();
        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addFirst(0);

        //remove
        ll.removeLast();
        ll.removeFirst();


        //print
        System.out.println(ll);

    }
}
