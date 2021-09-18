package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianDataStream {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        double[] res = printMedian(arr);
        System.out.print(Arrays.toString(res));
    }

    private static double[] printMedian(int[] arr) {
        double[] res = new double[arr.length];
        //we are making this because we are focusing on median of two q's
        PriorityQueue<Integer> smaller = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> greater = new PriorityQueue<>();

        double median = arr[0];
        int index = 0;
        res[index++] = median;
        smaller.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            int cur = arr[i];

            if(smaller.size() > greater.size()) {
                if(cur < median) {
                    greater.add(smaller.remove());
                    smaller.add(cur);
                } else {
                    greater.add(cur);
                }
                median = (double) (smaller.peek() + greater.peek()) / 2;
            } else if(smaller.size() == greater.size()){
                if(cur < median) {
                    smaller.add(cur);
                    median = (double) smaller.peek();
                } else {
                    greater.add(cur);
                    median =  greater.peek();
                }
            }else {
                if(cur > median) {
                    smaller.add(greater.remove());
                    greater.add(cur);
                } else {
                    smaller.add(cur);
                }
                median = (double) (smaller.peek() + greater.peek()) / 2;
            }
            res[index++] = median;
        }
        return res;
    }
}
