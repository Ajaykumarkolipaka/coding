package string.dp;

public class LongestPalinSubstring {
    public static void main(String[] args) {
        String str = "abbcdd";
        int maxPalinLen = longestPalinSubstring(str);
        System.out.println(maxPalinLen);
    }

    public static int longestPalinSubstring(String str) {
        int n = str.length(), maxLen = 1, start = 0;
        int[][] table = new int[n][n];
        //each char is palin so storing the same
        for(int i=0;i<n;i++)
            table[i][i] = 1;

        //check if the two len substring is palin if yes then store the result
        for(int i=0;i<n-1;i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                maxLen = 2;
                start = i;
                table[i][i+1] = 1;
            }
        }

        for(int k = 3;k<=n;k++) {
            for(int i=0;i < (n-k)+1;i++) {
                int j = (i + k) - 1;
                if(str.charAt(i) == str.charAt(j) && table[i+1][j-1] == 1) {
                    if(k > maxLen) {
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }
        System.out.println(str.substring(start, start+maxLen));
        return maxLen;
    }
}
