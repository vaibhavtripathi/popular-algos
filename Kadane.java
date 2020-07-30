// This is iterative approach to the Kadane's algo.
public class Kadane {
    public int maxSubarraySum(int[] arr) {
        int ans = 0;
        int temp = 0; // Max subarray sum ending at last index.
        for (int i = 0; i < arr.length; i++) {
            temp = Math.max(0, temp) + arr[i];
            if (temp > ans) ans = temp;
        }
        return ans;
    } 

    public static void main(String[] args) {
        Kadane k = new Kadane();
        int[] arr = {2, 0, -3, 2};
        int ans = k.maxSubarraySum(arr);
        System.out.println(ans);
    }
}