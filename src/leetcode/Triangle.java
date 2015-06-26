package leetcode;
//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
import java.util.*;
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1) return triangle.get(0).get(0);
        int[] res=new int[triangle.size()];
        for(int i=0;i<triangle.size();i++){
            res[i]=triangle.get(triangle.size()-1).get(i);
        }
        for(int level=triangle.size()-2;level>=0;level--){//bottom up
            for(int j=0;j<=level;j++){
                res[j]=triangle.get(level).get(j)+Math.min(res[j],res[j+1]);
                
            }
        }
        return res[0];
    }
}
