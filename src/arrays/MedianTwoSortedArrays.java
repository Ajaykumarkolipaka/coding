package arrays;

import java.util.Arrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
* */

//Time complexity O(arr.length)
//Space complexity O(m + n)
public class MedianTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2,4};
        double res = findMedian(arr1, arr2);
        System.out.println(res);
    }
    /*As the two arrays are sorted it's is similar to merge sort where we will merge the two sub arrays after dividing*/
    public static double findMedian(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int len = m + n;
        int[] res = new int[len];
        int i=0,j=0,k=0;
        // adding the two array elements to the temp array based on comparision
        while(i < m && j < n) {
            if(arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        // adding any left out elements in arr1
        while(i<m) {
            res[k++] = arr1[i++];
        }

        // adding any left out elements in arr2
        while(j<n) {
            res[k++] = arr2[j++];
        }

//        System.out.println(Arrays.toString(res));
        if(len % 2 != 0)
            return res[len / 2];

        int mid = len / 2;
        int mid_sum = res[mid] + res[mid - 1];
        return mid_sum;
    }
}
