import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWoReptingChars {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        LongestSubstringWoReptingChars solution = new LongestSubstringWoReptingChars();
        String test = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + solution.lengthOfLongestSubstring(test));
    }
}
