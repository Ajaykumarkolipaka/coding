package tree.binarytree;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class ContinuousTree {
    private static Node root;
    public static void main(String[] args) {
        root = new Node(3);
        root.left     = new Node(2);
        root.right     = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(5);
        System.out.println(isContinuous(root));
    }

    private static boolean isContinuous(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.left != null) {
                if(Math.abs(temp.left.val - temp.val) != 1) return false;
                queue.add(temp.left);
            }
            if(temp.right != null) {
                if(Math.abs(temp.right.val - temp.val) != 1) return false;
                queue.add(temp.right);
            }
        }
        return true;
    }
}
