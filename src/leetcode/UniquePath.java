package leetcode;

public class UniquePath {
	public int uniquePaths1(int m, int n) {
		//we could only 1-D array and dont have to consider the initial of whole row or column, just the first element is okay
        int[][] res=new int[n][m];
        for(int i=0;i<m;i++){
            res[0][i]=1;
            for(int j=0;j<n;j++){
                res[j][0]=1;
                if(i==0 || j==0) continue;
                res[j][i]=res[j-1][i]+res[j][i-1];
            }
        }
        return res[n-1][m-1];
    }
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid[0].length;
        int n=obstacleGrid.length;
        if(obstacleGrid[0][0]==1) return 0;        
        int[] res=new int[m];
        res[0]=1; // this initialize all the first column of every row.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1) res[j]=0;
                else if(j>0) res[j]+=res[j-1];
            }
        }
        return res[m-1];
    }
}
