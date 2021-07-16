package math;

/*
* Given a value V, if we want to make change for V cents, and we have infinite supply of
* each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
*  If it’s not possible to make change, print -1.

Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents
* */
//Time complexity is exponential a^n --> n = number of coins given, a = amount
//space complexity O(a)
public class CoinsRequired {
    public static void main(String[] args) {
        int[] arr = {9, 6, 5, 1};
        int amount = 11;
        int res = getCoinsRequired(arr, amount);
        System.out.println(res);
    }

    public static int getCoinsRequired(int[] arr, int amount) {
        if(amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++) {
            if(amount >= arr[i]) {
                int sub_res = getCoinsRequired(arr, amount - arr[i]);
                if(sub_res != Integer.MAX_VALUE && res > sub_res + 1) {
                    res = sub_res + 1;
                }
            }
        }
        return res;
    }
}
