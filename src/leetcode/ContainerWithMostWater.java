package leetcode;

public class ContainerWithMostWater {
	public int maxArea(int[] height){
		if(height.length==0) return 0;
		int len=height.length;
		int max=0;
		int i=0,j=len-1;
		while(i<j){
			max=Math.max(max, Math.min(height[i],height[j])*(j-i));
			if(height[i]>height[j]) j--;
			else i++;
		}
		return max;
	}
}
