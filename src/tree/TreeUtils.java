package tree;

public class TreeUtils {
    public static void preOrderTraversal(Node root) {
        if(root == null) return;

        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if(root == null) return;

        preOrderTraversal(root.left);
        System.out.print(root.val + " ");
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root) {
        if(root == null) return;

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }
}
