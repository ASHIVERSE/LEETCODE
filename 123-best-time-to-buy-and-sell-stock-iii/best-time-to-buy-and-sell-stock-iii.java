class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp =new int[n+1][2][3];
        for(int i=n-1;i>=0;i--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=2;cap++)
                {
                      int profit;
                    if(buy==1)
                    {
                        int take=-prices[i]+dp[i+1][0][cap];
                        int skip=dp[i+1][1][cap];
                        profit=Math.max(take,skip);

                    }
                    else
                    {
                        int sell=prices[i]+dp[i+1][1][cap-1];
                        int hold=dp[i+1][0][cap];
                        profit=Math.max(sell,hold);

                    } 
                      dp[i][buy][cap] = profit;
                }  
                }
            }
            return dp[0][1][2];
        }
     
    
}