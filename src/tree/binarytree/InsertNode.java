package tree.binarytree;

import tree.Node;
import tree.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree and a key, insert the key into the binary tree at the first position available in level order.*/
public class InsertNode {
    private static Node root;
    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        //print the cur status of binary tree in pre order traversal
        TreeUtils.preOrderTraversal(root);
        System.out.println();
        insertNode(root, 12);
        TreeUtils.preOrderTraversal(root);
    }

    private static void insertNode(Node root, int ele) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            root = new Node(ele);
            return;
        }

        //adding root element to the queue first
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            //checking if the left of the cur_node is empty if yes then add new node else add the cur_node to queue
            if(temp.left == null) {
                temp.left = new Node(ele);
                break;
            } else {
                queue.add(temp.left);
            }
            //check if the right of node is null if yes then add the ele else add cur_node right to the queue
            if(temp.right == null) {
                temp.right = new Node(ele);
                break;
            } else {
                queue.add(temp.right);
            }
        }

    }
}
