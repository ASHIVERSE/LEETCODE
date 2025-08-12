class Solution {
    Integer[][] dp; // Memoization table
    int N; //make N

    public int countArrangement(int n) {
        N = n;
        dp = new Integer[n + 1][1 << n]; // pos up to N, mask up to 2^N
        return backtrack(1, 0); // Start from position 1, no numbers used
    }

    private int backtrack(int pos, int mask) {
        if (pos > N) return 1; // All positions filled

        if (dp[pos][mask] != null) return dp[pos][mask];

        int total = 0;
        for (int num = 1; num <= N; num++) {
            int bit = 1 << (num - 1);
            if ((mask & bit) == 0 && (num % pos == 0 || pos % num == 0)) {
                total += backtrack(pos + 1, mask | bit);
            }
        }
        return dp[pos][mask] = total;
    }
}
