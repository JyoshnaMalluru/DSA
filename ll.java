
class LinkedList {
    //SWAPPING TWO NUMBERS
   
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static Node head;
    public static  Node swappingNodes(int x, int y){
        if(x==y){
          return head;
        }
        Node prevX = null;
        Node currX = head;
        while(currX != null && currX.val !=x){
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = head;
        while(currY != null && currY.val !=y){
            prevY = currY;
            currY = currY.next;
        }

        while(currX == null || currY == null){
            return null;
        }

        if(prevX != null){
            prevX.next = currY;
        }else{
            head = currY;
        }
        if(prevY != null){
            prevY.next = currX;
        }else{
            head = currX;
        }

        Node tempo = currX.next;
        currX.next = currY.next;
        currY.next = tempo;
        
        return head;

    }
    public void addFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
           head = newNode;
           return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void print(){
        if(head == null){
            System.out.println("ll is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
          System.out.print(temp.val+"->");
          temp= temp.next;
        }
        System.out.println("null");
        
    }
    public static void main(String[] args) {
         LinkedList list = new LinkedList();
        // list.addFirst(4);
        // list.addFirst(3);
        // list.addFirst(2);
        // list.addFirst(1);
        // int x = 2;
        // int y = 4;
        // list.print();
        // swappingNodes(x, y);
        int k =3;
        int n = 2;
  
        Node head1, head2, head3;
        head1 = new Node(1);
        head2 = new Node(5);
        head3 = new Node(8);

        Node newNode = new Node(2);
        head1.next = newNode;
       
        newNode = new Node(6);
        head2.next = newNode;

        newNode = new Node(9);
        head3.next = newNode;

    }
}
