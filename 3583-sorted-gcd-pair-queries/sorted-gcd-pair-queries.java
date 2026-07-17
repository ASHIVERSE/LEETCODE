class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];

        for (int x : nums)
            freq[x]++;

        long[] exact = new long[max + 1];

        // Count pairs whose gcd is a multiple of d
        for (int d = 1; d <= max; d++) {
            long cnt = 0;

            for (int multiple = d; multiple <= max; multiple += d)
                cnt += freq[multiple];

            exact[d] = cnt * (cnt - 1) / 2;
        }

        // Inclusion-Exclusion to get pairs with gcd exactly d
        for (int d = max; d >= 1; d--) {
            for (int multiple = d * 2; multiple <= max; multiple += d)
                exact[d] -= exact[multiple];
        }

        // Prefix counts
        long[] prefix = new long[max + 1];

        for (int d = 1; d <= max; d++)
            prefix[d] = prefix[d - 1] + exact[d];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // convert to 1-based rank

            int l = 1, r = max;

            while (l < r) {
                int mid = (l + r) / 2;

                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}