class Solution {

    static long MOD = 1000000007;

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long evenWays = power(5, even);
        long oddWays = power(4, odd);

        return (int)((evenWays * oddWays) % MOD);
    }

    long power(long x, long n) {

        if (n == 0)
            return 1;

        long half = power(x, n / 2);

        long ans = (half * half) % MOD;

        if (n % 2 == 1)
            ans = (ans * x) % MOD;

        return ans;
    }
}