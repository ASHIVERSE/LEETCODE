class Solution {
    public int lastStoneWeightII(int[] nums) {
         int n = nums.length;
         int totalsum=0;

         for(int num: nums)
         {
            totalsum+=num;
         };
        totalsum=Math.abs(totalsum);
        int w = totalsum/2;

        boolean[][] dp= new boolean[n+1][w+1];
        
         for(int i=0;i<=n;i++)
         {
            dp[i][0]=true;
         }
         for(int i=1;i<=n;i++)
         {
            for(int j=1;j<=w;j++)
            {
                if(nums[i-1]<=j)
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
                
            }
         }
         int s1=0;
         for(int j=w;j>=0;j--)
         {
            if(dp[n][j])
            {
                s1=j;
                break;
            }
         }
         return totalsum-2*s1;
    }
}