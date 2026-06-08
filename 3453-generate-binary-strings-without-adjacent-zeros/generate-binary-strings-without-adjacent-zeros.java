class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();

        solve("", n, ans);

        return ans;
    }
     public void solve(String curr,int n,List<String> ans)
    {
        if(curr.length()==n)
        {
            ans.add(curr);
            return;
        }
        solve(curr+"1",n,ans);
        if(curr.length()==0 || curr.charAt(curr.length()-1) !='0')
        {
            solve(curr+"0",n,ans);
        }
    }
}