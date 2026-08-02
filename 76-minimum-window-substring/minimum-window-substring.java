import java.util.*;

public class Solution {
    public static String minWindow(String s, String t) {
        
        // Frequency array to store required characters
        int[] need = new int[128];

        // Fill frequencies from t
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        // Number of characters still needed
        int count = t.length();

        int left = 0;

        // Stores minimum window
        int minLen = Integer.MAX_VALUE;

        // Starting index of answer
        int start = 0;

        // Expand the window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            /*
             If this character is still needed,
             we satisfy one required character.
            */
            if (need[ch] > 0) {
                count--;
            }

            /*
             Include current character
             inside the window.
            */
            need[ch]--;

            /*
             If count becomes zero,
             current window is valid.
            */
            while (count == 0) {

                // Update smallest window
                if (right - left + 1 < minLen) {

                    minLen = right - left + 1;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                /*
                 Put it back into "needed"
                 because it is leaving the window.
                */
                need[leftChar]++;

                /*
                 If it becomes positive,
                 we now miss this character.
                */
                if (need[leftChar] > 0) {
                    count++;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLen);
    }
}
