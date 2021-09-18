package priorityqueue;

import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/maximize-array-sum-k-negations-set-2/
public class MaximizeArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 5, -1, 2};
        int k = 4;
        System.out.println(getMax(arr, k));
    }
    private static int getMax(int[] arr, int k) {
        // Create a priority queue and insert all array elements
        // int
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr)
            pq.add(x);

        // Do k negations by removing a minimum element k times
        while (k-- > 0)
        {
            // Retrieve and remove min element
            int temp = pq.poll();

            // Modify the minimum element and add back
            // to priority queue
            temp *= -1;
            pq.add(temp);
        }

        // Compute sum of all elements in priority queue.
        int sum = 0;
        for (int x : pq)
            sum += x;
        return sum;
    }
}
