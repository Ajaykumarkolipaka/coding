package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
        int val = x.compareTo(y);
        if(val > 0) return -1;
        else if(val < 0) return 1;
        else return 0;
    }
}

public class KthLargest {
    public static void main(String[] args) {
        int[] arr = {5, 20,10,7,1};
        int k = 2;
        System.out.println(getKthLargest(arr, k));
    }

    private static int getKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : arr)
            pq.add(i);
        while(k > 0) {
            pq.remove();
            k--;
        }
        return pq.peek();

    }
}
