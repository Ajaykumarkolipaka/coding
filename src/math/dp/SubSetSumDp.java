package math.dp;

public class SubSetSumDp {
    public static void main(String[] args) {
        int[] arr = {4,5,1};
        int sum = 6;
        System.out.println(isSubSetPresent(arr, sum, arr.length));
    }

    public static boolean isSubSetPresent(int[] arr, int sum, int n) {
        boolean[][] table = new boolean[n + 1][sum + 1];

        for(int i=0;i<n;i++) {
            table[0][i] = false;
        }
        for(int i=0;i<n;i++)
            table[i][0] = true;

        for(int j = 1;j<=sum;j++) {
            for(int i = 1;i<=n;i++) {
                if(arr[i-1] <= j) {
                    table[i][j] = table[i-1][j] || table[i - 1][j - arr[i-1]];
                }
            }
        }
        return table[n][sum];
    }
}
