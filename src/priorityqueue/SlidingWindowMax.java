package priorityqueue;

import java.util.*;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = getMaxQueueBased(arr, k);
        System.out.println(Arrays.toString(res));
    }
    static int[] getSlideMax(int[] arr, int k) {
        List<Integer> res = new LinkedList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(new CustomComparator());
        int index = 0;
        for(int i=0;i<k;i++)
            q.add(arr[i]);
        res.add(q.peek());
        q.remove(arr[index++]);
        for(int i = k;i<arr.length;i++) {
            q.add(arr[i]);
            res.add(q.peek());
            q.remove(arr[index++]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    static int[] getMaxQueueBased(int[] arr, int k) {
        Deque<Integer> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();

        int i;
        for(i=0;i<k;i++) {
            while(!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();

            q.addLast(i);
        }

        for(;i<arr.length;i++) {
            res.add(q.peekFirst());
            while(!q.isEmpty() && q.peek() <= i - k)
                q.removeFirst();

            while(!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();

            q.addLast(i);
        }
        res.add(arr[q.peek()]);
        return res.stream().mapToInt(x -> x).toArray();
    }
}
