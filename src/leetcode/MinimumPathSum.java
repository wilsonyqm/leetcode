package leetcode;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
	    if (grid.length == 0) return 0;
	    if (grid[0].length == 0) return 0;
	    int[] dp = new int[grid[0].length];
	    for (int i = 0; i < grid.length; i ++) 
	        for (int j = 0; j < grid[0].length; j ++) 
	            if (i == 0 && j == 0) dp[j] = grid[0][0];
	            else if (i == 0) dp[j] = dp[j-1] + grid[i][j];
	            else if (j == 0) dp[j] += grid[i][j];
	            else dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
	    return dp[dp.length-1];
	}
	//
	//in-place
	public int minPathSum2(int[][] grid) {
	    if (grid.length == 0) return 0;
	    if (grid[0].length == 0) return 0;
	    for (int i = 0; i < grid.length; i ++) 
	        for (int j = 0; j < grid[0].length; j ++) 
	            if (i == 0 && j == 0) continue;
	            else if (i == 0) grid[i][j] = grid[i][j] + grid[i][j-1];
	            else if (j == 0) grid[i][j] = grid[i][j] + grid[i-1][j];
	            else grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
	    return grid[grid.length-1][grid[0].length-1];
	}
}
