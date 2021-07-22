package string;

import java.util.Arrays;
//Given a number, find the next smallest palindrome
public class NextSmallestPalindromeNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        if(isAll9(arr)) {
            int[] res = new int[arr.length + 1];
            res[0] = 1;
            res[arr.length] = 1;
            System.out.print(Arrays.toString(res));
        }else {
            generateNextPalinNumber(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    static boolean isAll9(int[] arr) {
        for(int i : arr) {
            if(i != 9) return false;
        }
        return true;
    }
    public static void generateNextPalinNumber(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        //end of left side is always less than mid
        int i = mid - 1;
        //beginning of right number depends on number is even or odd
        int j = (n % 2 == 0) ? mid : mid + 1;

        boolean leftSmaller = false;

        //ignore the middle numbers that are already palindrome
        while(i >=0 && arr[i] == arr[j]) {
            i--;
            j++;
        }

        // Find if the middle digit(s) need to
        // be incremented or not (or copying left
        // side is not sufficient)
        if(i < 0 || arr[i] < arr[j])
            leftSmaller = true;

        //copying right with left numbers
        while(i >= 0) {
            arr[j++] = arr[i--];
        }

        // Handle the case where middle digit(s)
        // must be incremented. This part of code
        // is for CASE 1 and CASE 2.2
        if(leftSmaller) {
            int carry = 1;

            //if number length is odd then increment mid element
            if(n % 2 == 1) {
                arr[mid] += 1;
                carry = arr[mid] / 10;
                arr[mid] %= 10;
            }

            i = mid - 1;
            j = (n % 2 == 0) ? mid : mid + 1;

            // Add 1 to the rightmost digit of the left
            // side, propagate the carry towards MSB digit
            // and simultaneously copying mirror of the
            // left side to the right side.
            //when carry is zero no need to loop through till i>=0
            while (i >= 0 && carry > 0) {
                arr[i] = arr[i] + carry;
                carry = arr[i] / 10;
                arr[i] = arr[i] % 10;
                arr[j] = arr[i];
                i--;
                j++;
            }
        }
    }
}
