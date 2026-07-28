class Solution {
    public String smallestPalindrome(String s) {

        // Frequency array for lowercase letters
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        // Build the left half in lexicographical order
        for (int i = 0; i < 26; i++) {

            // If frequency is odd, this character goes in the middle
            if (freq[i] % 2 == 1) {
                middle.append((char) (i + 'a'));
            }

            // Add half of its occurrences to the left half
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }
        }

        // Right half is the reverse of the left half
        String right = new StringBuilder(left).reverse().toString();

        // Final palindrome
        return left.toString() + middle.toString() + right;
    }
}