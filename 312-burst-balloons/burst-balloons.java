class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Add virtual balloons with value 1 at both ends
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // Fill from smaller intervals to larger intervals
        for (int i = n; i >= 1; i--) {

            for (int j = i; j <= n; j++) {

                int maxi = 0;

                // Assume k is the LAST balloon burst
                for (int k = i; k <= j; k++) {

                    int coins =
                            dp[i][k - 1]                  // left interval
                          + dp[k + 1][j]                  // right interval
                          + arr[i - 1] * arr[k] * arr[j + 1];

                    maxi = Math.max(maxi, coins);
                }

                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }
}