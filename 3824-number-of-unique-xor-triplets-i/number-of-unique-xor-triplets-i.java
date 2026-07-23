class Solution {
    public int uniqueXorTriplets(int[] nums) {
         int n = nums.length;

        if (n == 1) return 1;
        if (n == 2) return 2;

        int bits = 32 - Integer.numberOfLeadingZeros(n);
        return 1 << bits;
//         int bits = 0;
// int x = n;

// while (x > 0) {
//     bits++;
//     x /= 2;      // or x >>= 1;
// }

// return 1 << bits;
    }
}