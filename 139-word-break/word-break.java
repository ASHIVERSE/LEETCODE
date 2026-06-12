class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        Boolean[] dp =new Boolean[s.length()];
        return solve(0,s,set,dp);
    }
    public boolean solve(int ind,String s,HashSet<String> set, Boolean[] dp)
    {
        if(ind==s.length())
        {
            return true;
        }
        if(dp[ind]!=null)
            return dp[ind];
        for(int end=ind+1;end<=s.length();end++)
        {
            String word=s.substring(ind,end);
            if(set.contains(word))
            {
                if(solve(end, s, set, dp))
                return dp[ind]=true;
            }
        }
         return dp[ind] = false;
    }
}