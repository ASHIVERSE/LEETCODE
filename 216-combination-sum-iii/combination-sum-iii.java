class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    void solve(int start,
               int k,
               int target,
               List<Integer> curr,
               List<List<Integer>> ans) {

        if(k == 0 && target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i <= 9; i++) {

            if(i > target)
                break;

            curr.add(i);

            solve(i + 1, k - 1,target - i, curr, ans);

            curr.remove(curr.size() - 1);
        }
    }
}