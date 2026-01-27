

public class CircularLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data=data;
            this.next=null;
        }
    };

    Node head;

    CircularLinkedList() {
        head=null;
    }

    void insert(int data) {
        if (head==null) {
            head=new Node(data);
            head.next=head;
        } else {
            Node node=new Node(data);

            Node temp=head;
            while (temp.next!=head) {
                temp=temp.next;
            }

            temp.next=node;
            node.next=head;
        }
    }

    void printList() {
        if (head==null) {
            System.out.println("Empty list!");
            return;
        }

        Node temp=head;

        do {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        } while (temp!=head);
        
        System.out.println();
    }

    int sumOfEven() {
        if (head==null) {
            return 0;
        }

        Node temp=head;
        int sum=0;

        do {
            if (temp.data%2==0)
                sum+=temp.data;

            temp=temp.next;
        } while (temp!=head);
        return sum;
    }

    public static void main(String[] args) {
        CircularLinkedList cll=new CircularLinkedList();
        cll.insert(2);
        cll.insert(3);
        cll.insert(7);
        cll.insert(24);

        cll.printList();
        int sum=cll.sumOfEven();
        System.out.println("Sum of even numbers in list = " + sum);
    }    
}
