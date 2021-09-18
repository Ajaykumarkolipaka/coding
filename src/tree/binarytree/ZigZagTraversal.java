package tree.binarytree;

import tree.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    private static Node root;
    public static void main(String[] args) {
        root = new Node(3);
        root.left     = new Node(2);
        root.right     = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(5);
        System.out.println(zigZagTraversal(root));
    }

    private static List<List<Integer>> zigZagTraversal(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        boolean flag = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        res.add(list);

        while (!queue.isEmpty()) {
            list = new LinkedList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                Node temp = queue.poll();
                if(temp.left != null) {
                    list.add(temp.left.val);
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    list.add(temp.right.val);
                    queue.add(temp.right);
                }
            }
            if(!list.isEmpty())
                res.add(list);
        }
        return res;
    }
}
