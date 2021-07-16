package string.dp;
//Time complexity 0(n*n)
// space complexity 0(n*n)
public class LongestPalinSubSeq {
    public static void main(String[] args) {
        String str = "adbsa";
        int res = longestPalinSubseq(str);
        System.out.println(res);
    }

    public static int longestPalinSubseq(String str) {
        int n = str.length();
        int[][] table = new int[n][n];
        for(int i=0;i<n;i++)
            table[i][i] = 1;

        for(int k = 2;k<=n;k++) {
            for(int i=0;i<n-k+1;i++) {
                int j = i+k-1;
                boolean isSame = str.charAt(i) == str.charAt(j);
                if(isSame && k == 2) {
                    table[i][j] = 2;
                } else if(isSame) {
                    table[i][j] = table[i+1][j-1] + 2;
                } else {
                    table[i][j] = Math.max(table[i+1][j], table[i][j-1]);
                }
            }
        }
        return table[0][n-1];
    }
}
