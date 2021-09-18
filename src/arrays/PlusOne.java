package arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {1,9,9};
        int[] res = plusOne(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] != 10) return digits;
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
