class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,m-1,grid,dp);
    }
    public int solve(int i,int j1,int j2,int[][] grid,int[][][] dp)
    {
         int n=grid.length;
        int m=grid[0].length;
        if(j1<0 || j2<0 || j1>=m || j2>=m)
        {
            return -100000000;
        }

        if(i==n-1)
        {
            if(j1==j2)
                return grid[i][j1];
            return grid[i][j1]+grid[i][j2];

        }
        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];
        
         int current;

        if (j1 == j2)
            current = grid[i][j1];
        else
            current = grid[i][j1] + grid[i][j2];

        int max = -1000000000;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {

                int next = solve(
                    i + 1,
                    j1 + d1,
                    j2 + d2,
                    grid,
                    dp
                );

                max = Math.max(max, next);
            }
        }

        return dp[i][j1][j2] = current + max;

    }
}