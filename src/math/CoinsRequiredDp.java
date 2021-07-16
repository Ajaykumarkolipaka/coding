package math;

public class CoinsRequiredDp {
    public static void main(String[] args) {
        int[] arr = {9, 6, 5, 1};
        int amount = 11;
        int res = getCoinsRequired(arr, amount);
        System.out.println(res);
    }

    private static int getCoinsRequired(int[] arr, int amount) {
        int[] table = new int[amount + 1];
        table[0] = 0;
        for(int i=1;i<=amount;i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for(int k = 1;k<=amount;k++) {
            for(int i=0;i<arr.length;i++) {
                if(arr[i] <= k) {
                    int sub_res = table[k - arr[i]];
                    if(sub_res != Integer.MAX_VALUE && table[k] > sub_res + 1)
                        table[k] = sub_res + 1;
                }
            }
        }
        return table[amount];
    }
}
