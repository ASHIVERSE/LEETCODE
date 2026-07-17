class Solution {
    public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // prefix sum 0 occurs once initially

    int sum = 0, count = 0;
    for (int num : nums) {
        sum += num;

        // Check if there is a prefix sum that when removed from current sum gives k
        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }

        // Record the current prefix sum
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
}

}