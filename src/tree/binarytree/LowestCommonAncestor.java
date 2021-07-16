package tree.binarytree;

import tree.Node;

import java.util.ArrayList;
//Time complexity is O(n)
//Space complexity is 0(n)
public class LowestCommonAncestor {
    Node root;
    public static ArrayList<Node> left = new ArrayList<>();
    public static ArrayList<Node> right = new ArrayList<>();

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println(tree.findLCA(2,5));
    }

    private Integer findLCA(int n1, int n2) {
        if(!findPath(root, n1, left) || !findPath(root, n2, right))
            return -1;
        int i = 0;
        while(i < left.size() && i < right.size()) {
            if(left.get(i).val != right.get(i).val)
                break;
            i++;
        }
        return left.get(i-1).val;
    }

    public boolean findPath(Node root, int key, ArrayList<Node> list) {
        if(root == null) return false;
        list.add(root);
        if(root.val == key) return true;

        if(root.left != null && findPath(root.left, key, list))
            return true;
        if(root.right != null && findPath(root.right, key, list))
            return true;

        list.remove(list.size() - 1);
        return false;
    }
}
