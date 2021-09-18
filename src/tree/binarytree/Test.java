package tree.binarytree;

import tree.Node;

import java.util.*;

public class Test {
    private static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(levelOrder(root));
    }
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node temp = queue.poll();
                tempList.add(temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            if(tempList.size() > 0)
                res.add(tempList);
        }
        return res;
    }

    public static int[] frequencySort(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : list) {
            res[i++] = entry.getKey();
        }
        return res;
    }
}
