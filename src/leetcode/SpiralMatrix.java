package leetcode;
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
import java.util.*;
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res=new ArrayList<Integer>();
		int m=matrix[0].length;
		int n=matrix.length;
		//the ++ -- sign is always in front of the number, the m and n is Cross(loop for m reduce n,loop for n reduce m).
		//This can check the next step, instead of the current step
		if(n==0||m==0) return res;
		int row=0;
		int col=-1;
		while(true){
			for(int i=0;i<m;i++){
				res.add(matrix[row][++col]);
			}
			if(--n==0) break;
			for(int i=0;i<n;i++){
				res.add(matrix[++row][col]);
			}
			if(--m==0) break;
			for(int i=0;i<m;i++) 
				res.add(matrix[row][--col]);
			if(--n==0) break;
			for(int i=0;i<n;i++){
				res.add(matrix[--row][col]);
			}
			if(--m==0) break;
		}
		return res;
    }
	public static void main(String args[]){
		SpiralMatrix test=new SpiralMatrix();
		int[][] matrix=new int[][]{
		                            { 1, 2, 3 },
		                            { 4, 5, 6 },
		                            { 7, 8, 9 }
		                           };
		List<Integer> res=test.spiralOrder(matrix);
		for(int re:res){
			System.out.print(re+ " ");
		}
		int p=16;
		float r=(float) (p+(1-p)*0.15);
		float r1=r/p;
		System.out.print(r+" ");
		System.out.print(r1);
	}
}
