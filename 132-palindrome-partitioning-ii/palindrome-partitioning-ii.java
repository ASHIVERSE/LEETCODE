class Solution {
     boolean isPalindrome(String s, int i, int j) {

        while(i < j) {

            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
    public int minCut(String s) {
         int n = s.length();

        // dp[i] = minimum partitions needed from i to end
        int[] dp = new int[n + 1];

        dp[n] = 0; // base case

        // Fill from back
        for(int i = n - 1; i >= 0; i--) {

            int minCost = Integer.MAX_VALUE;

            for(int j = i; j < n; j++) {

                // If current substring is palindrome
                if(isPalindrome(s, i, j)) {

                    int cost = 1 + dp[j + 1];

                    minCost = Math.min(minCost, cost);
                }
            }

            dp[i] = minCost;
        }

        // Partitions - 1 = Cuts
        return dp[0] - 1;
    }
}