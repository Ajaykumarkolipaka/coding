package arrays;
//This time an array can have duplicates
//Time compleity O(log n)
public class RotatedSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1};
        int key = 0;
        int index = binarySearch(arr, key, 0, arr.length-1);
        System.out.println(index);
    }
    static int binarySearch(int[] arr, int key, int l, int r) {
        while(l <= r){
            int m = (l + r) / 2;
            if(arr[m] == key) return m;
            if(arr[l] == arr[m])
                l++;
            else if(arr[l] < arr[m]) {
                if(key >= arr[l] && key < arr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if(key > arr[m] && key <= arr[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
