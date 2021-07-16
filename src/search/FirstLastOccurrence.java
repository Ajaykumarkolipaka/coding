package search;

//time complexity O(log n)
public class FirstLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,6,6,6};
        int key = 6;
        int first = findFirstOccur(arr, key, 0, arr.length - 1);
        int last = findLastOccur(arr, key, 0, arr.length - 1);
        System.out.println(first + " " + last);
    }

    public static int findFirstOccur(int[] arr, int key, int l, int r) {
        if(l <= r) {
            int mid = (l + r) / 2;
            if((mid == 0 || arr[mid - 1] < key) && arr[mid] == key) return mid;
            else if(arr[mid] >= key)
                return findFirstOccur(arr, key, l, mid - 1);
            else
                return findFirstOccur(arr, key, mid + 1, r);
        }
        return -1;
    }

    public static int findLastOccur(int[] arr, int key, int l, int r) {
        if(l <= r) {
            int mid = (l + r) / 2;
            if((mid == r || arr[mid + 1] > key) && arr[mid] == key) return mid;
            else if(arr[mid] <= key)
                return findLastOccur(arr, key, mid + 1, r);
            else
                return findLastOccur(arr, key, l ,mid - 1);
        }
        return -1;
    }
}
