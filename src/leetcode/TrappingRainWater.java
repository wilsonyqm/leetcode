package leetcode;

public class TrappingRainWater {
	public int trap(int[] A){
		int len=A.length;
		int right=len-1;
		int left=0;
		int water=0;
		int leftmax=0;
		int rightmax=0;
		while(left<right){
			leftmax=Math.max(leftmax, A[left]);
			rightmax=Math.max(rightmax, A[right]);
			if(leftmax<rightmax){
				water+=leftmax-A[left++];
			}else{
				water+=rightmax-A[right--];
			}
		}
		return water;
	}
	public static void main(String args[]){
		int[] A=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		TrappingRainWater test=new TrappingRainWater();
		System.out.println("Water: "+test.trap(A));
	}
}
