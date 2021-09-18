package arrays;

import java.util.Arrays;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        int[] arr = {3, 8, 5};
        System.out.println(canFormPythagoreanTriplet(arr));
    }
    static boolean canFormPythagoreanTriplet(int[] arr) {
        arr = Arrays.stream(arr).map(i -> i * i).toArray();
        int i = 0, j = arr.length - 1;
        for(int k = arr.length - 1;k >= 0; k--) {
            j = k - 1;
            while(i < j) {
                if(arr[i] + arr[j] == arr[k]) return true;
                if(arr[i] + arr[j] < arr[k]) i++;
                else j--;
            }
        }
        return false;
    }
}
