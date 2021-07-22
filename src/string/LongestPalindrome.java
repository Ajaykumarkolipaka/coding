package string;

import java.util.HashSet;

/*Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
 that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
Example 1:
Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.*/
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "cccddd";
        System.out.println(longestPalindrome(str));
    }

    public static int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;

        char[] arr = s.toCharArray();
        int count = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for(char i : arr) {
            if(hashSet.contains(i)) {
                hashSet.remove(i);
                count++;
            } else {
                hashSet.add(i);
            }
        }
        if(!hashSet.isEmpty()) {
            return count = count * 2 + 1;
        }
        return count * 2;
    }
}
