package tree.bst;

import tree.Node;
//Time complexity is O(h)
//Space complexity is O(1)
public class LowestCommonAncestor {
    Node root;
    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 12, n2 = 14;
        int res = findLowestCommonAncestor(tree.root, n1, n2);
        System.out.println(res);
    }
    /*Approach: For Binary search tree, while traversing the tree from top to bottom the first node which lies in between
     the two numbers n1 and n2 is the LCA of the nodes, i.e. the first node n with the lowest depth which lies in
      between n1 and n2 (n1<=n<=n2) n1 < n2. So just recursively traverse the BST in, if node’s value is greater than
       both n1 and n2 then our LCA lies in the left side of the node, if it’s is smaller than both n1 and n2, then LCA lies
        on the right side. Otherwise, the root is LCA (assuming that both n1 and n2 are present in BST).*/
    static int findLowestCommonAncestor(Node root, int n1, int n2) {
        while(root != null) {
            if(root.val > n1 && root.val > n2)
                root = root.left;
            else if(root.val < n1 && root.val <n2)
                root = root.right;
            else
                break;
        }
        return root.val;
    }
}
