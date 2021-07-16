package search;

//Time complexity is O(log n)
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10};
        int key = 3;
        int index = binarySearch(arr, key, 0, arr.length-1);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int key, int l, int r) {
        if(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] == key) return m;
            else if(arr[m] < key)
                return binarySearch(arr, key, m + 1, r);
            else
                return binarySearch(arr, key, l, m - 1);
        }
        return -1;
    }
}
