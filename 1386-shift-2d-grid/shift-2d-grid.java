class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int total=m*n;
        k = k%total;
        int[][] temp=new int[m][n];
        for (int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int oldInd=i*n+j;
                int newInd=(oldInd+k)%total;
                int newRow=newInd/n;
                int newCol=newInd%n;
                temp[newRow][newCol]=grid[i][j];
            }
        }
        List<List<Integer>> ans= new ArrayList<>();

        for(int[] row:temp)
        {   List<Integer> list=new ArrayList<>();
            for(int x: row)
            {
                list.add(x);
            }
            ans.add(list);
        }
        return ans;
    }
}