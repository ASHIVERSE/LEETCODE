class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
         for(int i=0;i<n;i++)
         {
            dp[n-1][i]=matrix[n-1][i];
         }
         for(int i=n-2;i>=0;i--)
         {
            for(int j=0;j<n;j++)
            {
                int down=dp[i+1][j];
                int leftDiag= (j>0)? dp[i+1][j-1] : (int)1e9;
                int rightDiag =(j<n-1) ? dp[i+1][j+1] : (int)1e9;
                dp[i][j]=matrix[i][j]+ Math.min(down,Math.min(leftDiag,rightDiag));
            }
         }
         int ans=(int)1e9;
         for(int i=0;i<n;i++)
         {
             ans=Math.min(ans,dp[0][i]);
         }
         return ans;

    }
}