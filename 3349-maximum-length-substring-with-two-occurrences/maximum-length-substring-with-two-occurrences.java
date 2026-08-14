class Solution {
    public int maximumLengthSubstring(String s) {


       
        int[] freq = new int[26];

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add s[right]
            freq[s.charAt(right) - 'a']++;

            // If current character occurs more than 2 times
            while (freq[s.charAt(right) - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            // Valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }
}