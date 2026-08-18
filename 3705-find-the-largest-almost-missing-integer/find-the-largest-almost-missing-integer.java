class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // Check every subarray of size k
        for (int i = 0; i <= nums.length - k; i++) {

            // Set ensures each number is counted only once
            // for this particular subarray
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // This number appeared in one more subarray
            for (int x : set) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        // Find largest number appearing in exactly one subarray
        for (int x : count.keySet()) {
            if (count.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}