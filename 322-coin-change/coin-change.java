class Solution {
   public int coinChange(int[] coins, int amount) {
   
       int n = coins.length;
       int INF = Integer.MAX_VALUE / 2; // large number for "infinity"
        
        int[][] dp = new int[n + 1][amount + 1];
        
        // Initialization
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = INF; // 0 coins cannot make positive sum
        }
        dp[0][0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    // Include coin[i-1] (stay at i, unbounded)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    // Exclude coin[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][amount] >= INF ? -1 : dp[n][amount];
   }
}