/* Program to find K closest elements to a number X from a provided sorted array.
 * IDEA: Consider the entire array and keep shrinking it until we find the optimal subarray.
 * Time Complexity: O(N - K)
 */

public class KClosestFinder {
    private int k;
    private int x;

    KClosestFinder(int k, int x) {
        this.k = k;
        this.x = x;
    }

    public int[] find(int[] arr) {
        if (arr.length < k) {
            return new int[] {};
        }
        int start = 0;
        int end = arr.length - 1;
        while (end - start + 1 > k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++; 
            } else {
                end--;
            }
        }
        int[] res = new int[end - start + 1];
        int index = 0;
        while (start <= end) {
            res[index++] = arr[start++];
        }
        return res;
    }

    public static void main(String[] args) {
        KClosestFinder k = new KClosestFinder(2, 10);
        int[] res = k.find(new int[] {1, 2, 3, 9, 11, 18});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}