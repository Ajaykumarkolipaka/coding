package math;

public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int sum = 4;
        boolean res = subSetSum(arr, sum, arr.length - 1);
        System.out.println(res);
    }

    public static boolean subSetSum(int[] arr, int sum, int n) {
        if(sum == 0) return true;
        if(n == 0) return false;

        if(arr[n] > sum)
            return subSetSum(arr, sum, n-1);

        return (subSetSum(arr, sum, n - 1) || subSetSum(arr, sum - arr[n], n - 1));
    }
}
