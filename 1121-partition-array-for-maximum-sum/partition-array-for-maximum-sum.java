class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n + 1];

        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--) {

            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int ans = Integer.MIN_VALUE;

            for(int j = i; j < Math.min(i + k, n); j++) {

                len++;

                maxi = Math.max(maxi, arr[j]);

                int sum = (len * maxi) + dp[j + 1];

                ans = Math.max(ans, sum);
            }

            dp[i] = ans;
        }

        return dp[0]; 
    }
}