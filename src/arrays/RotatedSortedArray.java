package arrays;

/*There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
*/
public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int key = 0;
        int res = binarySearch(arr, key, 0, arr.length - 1);
        System.out.print(res);
    }

    static int binarySearch(int[] arr, int key, int l, int r) {
        while(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] == key) return m;
            else if(arr[l] <= arr[m]) {  // check the range of b/w l and m is valid sorted array
                if(key >= arr[l] && key <= arr[m]) { // check if key is present in the sorted array of range l and m
                    r = m - 1;  // if present then we should check in that sub array only
                } else {
                    l = m + 1; // else we will check in other sub array from range m + 1 to r
                }
            } else {
                if(arr[r] >= arr[m]) {
                    if(key >= arr[m] && key <= r) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
            }
        }
        return -1;
    }
}
