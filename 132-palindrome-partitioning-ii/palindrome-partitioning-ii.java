class Solution {

    boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    int solve(String s, int i, int[] dp) {

        // If we reached the end, no more cuts needed
        if (i == s.length())
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int ans = Integer.MAX_VALUE;

        // Try every possible partition
        for (int j = i; j < s.length(); j++) {

            if (isPalindrome(s, i, j)) {

                int cuts = 1 + solve(s, j + 1, dp);

                ans = Math.min(ans, cuts);
            }
        }

        return dp[i] = ans;
    }

    public int minCut(String s) {

        int[] dp = new int[s.length()];

        Arrays.fill(dp, -1);

        return solve(s, 0, dp) - 1;
    }
}