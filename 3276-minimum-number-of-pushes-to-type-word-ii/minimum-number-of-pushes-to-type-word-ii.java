class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // Count frequency
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies
        Arrays.sort(freq);

        int ans = 0;
        int count = 0;

        // Traverse from highest frequency
        for (int i = 25; i >= 0; i--) {

            if (freq[i] == 0)
                break;

            int cost = (count / 8) + 1;

            ans += freq[i] * cost;

            count++;
        }

        return ans;
    }
}