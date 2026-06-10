class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        solve(0,target,candidates,cur, ans) ;
        return ans;
    }
    public void solve(int ind,int target,int[] candidates,List<Integer> cur,
                        List<List<Integer>> ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(cur));
            return;
        }

       

        for(int i=ind;i<candidates.length;i++)
        {
            if(i > ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            
            cur.add(candidates[i]);
            solve(i + 1,target-candidates[i],candidates,cur, ans);
            cur.remove(cur.size()-1);
        }
        
    }
}