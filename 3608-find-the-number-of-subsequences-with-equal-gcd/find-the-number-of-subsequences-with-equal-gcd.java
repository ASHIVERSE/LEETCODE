class Solution {
    static final int MOD = 1000000007;

    public int subsequencePairCount(int[] nums) {

        long[][] dp = new long[201][201];
        dp[0][0] = 1;

        for (int x : nums) {

            long[][] ndp = new long[201][201];

            for (int a = 0; a <= 200; a++) {
                for (int b = 0; b <= 200; b++) {

                    if (dp[a][b] == 0) continue;

                    // Don't take x
                    ndp[a][b] += dp[a][b];

                    // Take x in first subsequence
                    ndp[gcd(a, x)][b] += dp[a][b];

                    // Take x in second subsequence
                    ndp[a][gcd(b, x)] += dp[a][b];

                    ndp[a][b] %= MOD;
                    ndp[gcd(a, x)][b] %= MOD;
                    ndp[a][gcd(b, x)] %= MOD;
                }
            }

            dp = ndp;
        }

        long ans = 0;

        for (int g = 1; g <= 200; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}