class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(0, nums, curr, ans);

        return ans;
    }
     void solve(int ind, int[] nums,
               List<Integer> curr,
               List<List<Integer>> ans) {

        ans.add(new ArrayList<>(curr));

        for(int i = ind; i < nums.length; i++) {

            if(i > ind && nums[i] == nums[i - 1])
                continue;

            curr.add(nums[i]);

            solve(i + 1, nums, curr, ans);

            curr.remove(curr.size() - 1);
        }
    }
}