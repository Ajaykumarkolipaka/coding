package arrays;

class Node {
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
    }
}

public class MergeSortedLists {
    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        Node head = mergeKLists(arr, k - 1);
        printList(head);
    }

    private static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static Node mergeKLists(Node[] arr, int last) {
        while(last != 0) {
            int i = 0, j = last;
            while(i < j) {
                arr[i] = sortedMerge(arr[i], arr[j]);
                i++;
                j--;

                if(i >= j)
                    last = j;
            }
        }

        return arr[0];
    }

    private static Node sortedMerge(Node a, Node b) {
        Node result = null;
        if(a == null) return b;
        else if(b == null) return a;

        if(a.data < b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }
}
