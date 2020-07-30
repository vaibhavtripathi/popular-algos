import java.util.HashMap;
import java.util.Map;

public class KMP {
    private Map<Integer, Integer> alsoMatchedFor = new HashMap<>();

    public void preprocess(String pattern) {
        int matchedPrefixSize = 0;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(matchedPrefixSize)) {
                alsoMatchedFor.put(i, matchedPrefixSize);
                matchedPrefixSize++;
            } else {
                matchedPrefixSize = 0;
            }
        }
    }

    public int getPatternIndexToMatch(int lastMatchedIndex, char newChar, String pattern) {
        int index = alsoMatchedFor.getOrDefault(lastMatchedIndex, -1);
        while (index > -1) {
            if (pattern.charAt(index + 1) == newChar) {
                return index + 2;
            } else {
                index = alsoMatchedFor.getOrDefault(index, -1);
            }
        }
        return 0;
    }

    public int find(String pattern, String text) {
        preprocess(pattern);
        int matchedPatternLength = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(matchedPatternLength)) {
                matchedPatternLength++;
                if (matchedPatternLength == pattern.length()) {
                    return (i - pattern.length()) + 1;
                }
            } else {
                int patternIndexToMatch = getPatternIndexToMatch(matchedPatternLength - 1, text.charAt(i), pattern);
                if (patternIndexToMatch > 0) {
                    matchedPatternLength = patternIndexToMatch;
                } else {
                    if (text.charAt(i) == pattern.charAt(0)) {
                        matchedPatternLength = 1;
                    } else {
                        matchedPatternLength = 0;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Running pattern matching...");
        KMP matcher = new KMP();
        int found = matcher.find("bdb", "dbdb");
        System.out.println(found);
    }
}