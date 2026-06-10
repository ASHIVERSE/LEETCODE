class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }
    private void solve(int index, int[] arr, int target, List<Integer> curr,
                        List<List<Integer>> ans) {

        // Found answer
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Out of bounds
        if(index == arr.length) {
            return;
        }

        // TAKE
        if(arr[index] <= target) {

            curr.add(arr[index]);

            solve(index, arr,target - arr[index], curr,ans);

            curr.remove(curr.size() - 1);
        }

        // NOT TAKE
        solve(index + 1, arr,target, curr,ans);
    }
}