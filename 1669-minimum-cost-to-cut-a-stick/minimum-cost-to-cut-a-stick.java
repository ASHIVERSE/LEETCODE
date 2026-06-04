class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] cut=new int[m+2];
        cut[0]=0;
        cut[m+1]=n;
        for(int i=0;i<m;i++)
        {
            cut[i+1]=cuts[i];
        }
        Arrays.sort(cut);
        int[][] dp=new int[m+2][m+2];
        for(int i=m;i>=1;i--)
        {
            for(int j=i; j <= m; j++ )
            {
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int cost=(cut[j+1]-cut[i-1])+dp[i][k-1]+dp[k+1][j];
                    mini=Math.min(cost,mini);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][m];
    }
}