package string;

import java.util.ArrayList;
import java.util.List;
//Time complexity is O(n*n!) as string of length n -> n! permutations will be there and n as we need to print it
//Space complexity is O(n!)
public class Permutation {
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String str = "abc";
        List<String> res = generatePermStrings(str, 0, str.length() - 1);
        System.out.println(res);
    }

    private static List<String> generatePermStrings(String str, int p, int q) {
        if(p == q)
            list.add(str);
        else {
            for(int i=p;i<=q;i++) {
                str = swap(str, p, i);
                generatePermStrings(str, p + 1, q);
                str = swap(str, p, i);
            }
        }
        return list;
    }

    private static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return new String(arr);
    }
}
