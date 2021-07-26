package tree.binarytree;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/foldable-binary-trees/
public class FoldableBinaryTree {
    private static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isFoldableBinaryTree(root));
    }

    private static boolean isFoldableBinaryTree(Node root) {
        if(root == null) return true;

        return isFoldableUtil(root.left, root.right);
    }

    private static boolean isFoldableUtil(Node n1, Node n2) {
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;

        return isFoldableUtil(n1.left, n2.right) && isFoldableUtil(n1.right, n2.left);
    }
}
