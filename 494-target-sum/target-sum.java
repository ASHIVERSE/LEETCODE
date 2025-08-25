class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int totalSum = 0;
        for (int num : nums) totalSum += num;

        // If not possible
        if (Math.abs(target) > totalSum || (target + totalSum) % 2 != 0) return 0;

        int sum = (target + totalSum) / 2;
        return countSubsets(nums, sum);
    }

    // Count subsets with given sum
    private static int countSubsets(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // Empty subset always makes sum 0
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
