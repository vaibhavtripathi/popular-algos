/* Program to find longest substring with atmost K distinct characters.
 *
 * IDEA: Keep a sliding window to keep track of the current candidate substring.
 * Maintain a map to keep track of all elements in the current window.
 */

import java.util.Map;
import java.util.HashMap;

public class SubstringWithMaxKDistinct {
    private int k;

    SubstringWithMaxKDistinct(int k) {
        this.k = k;
    }

    public String get(String s) {
        if (s.length() <= k) return s;
        Map<Character, Integer> visited = new HashMap<>();
        // Initialize the window.
        int start = 0;
        while (visited.size() < k) {
            if (start >= s.length()) return s;
            visited.put(s.charAt(start), visited.getOrDefault(start, 0) + 1);
            start++;
        }
        // Move the window.
        int end = start; // This is one more than the last window index.
        start = 0;
        int maxSubstringSize = end - start;
        String ans = s.substring(start, end);
        while (end < s.length()) {
            // If map has less entries than k, expand the window.
            if (visited.size() < k) {
                visited.put(s.charAt(end), visited.getOrDefault(end, 0) + 1);
                end++;
            } else if (visited.containsKey(s.charAt(end))) {
                // Expand the window.
                visited.put(s.charAt(end), visited.getOrDefault(end, 0) + 1);
                end++;
            } else {
                // Contract the window.
                if (visited.get(s.charAt(start)) == 1) {
                    visited.remove(s.charAt(start));
                } else {
                    visited.put(s.charAt(start), visited.get(s.charAt(start)) - 1);
                }
                start++;
            }
            if (end - start > maxSubstringSize) {
                maxSubstringSize = end - start;
                ans = s.substring(start, end);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubstringWithMaxKDistinct s = new SubstringWithMaxKDistinct(4);
        System.out.println(s.get("fabcadae"));
    }
}