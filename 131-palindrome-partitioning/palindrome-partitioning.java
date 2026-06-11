class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> cur=new ArrayList<>();
        solve(0,s,cur,ans);
        return ans;
    }
    boolean isPalindrome(String s, int start,int end)
    {
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            
            start++;
            end--;
        }
        return true;
    }
    public void solve(int ind,String s ,List<String> cur,List<List<String>> ans )
    {
        if(ind==s.length())
        {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=ind;i<s.length();i++)
        {
            if(isPalindrome(s,ind,i))
            {
                cur.add(s.substring(ind,i+1));
                solve(i+1,s,cur,ans);
                cur.remove(cur.size()-1);
            }
        }
    }
}