package arrays;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dept = {910, 1200, 1120, 1130, 1900, 2000};
        int res = minPlatforms(arr, dept);
        System.out.println(res);
    }
    public static int minPlatforms(int[] arr, int[] dept) {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int count = 1, i = 1, j = 0, p = 1;
        while(i < arr.length && j< dept.length) {
            if(arr[i] <= dept[j]) {
                p++;
                i++;
            } else {
                p--;
                j++;
            }
            if(p > count)
                count = p;
        }
        return count;
    }
}
