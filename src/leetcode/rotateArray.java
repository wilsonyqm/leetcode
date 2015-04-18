package leetcode;

public class rotateArray {
	public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n==0||n==1) return;
		reverse(nums,0,n);
        reverse(nums,0,k);
        reverse(nums,k,n);
    }
	public void reverse(int[] num, int i,int j){
		while(i<j){
			int temp=num[i];
			num[i]=num[j];
			num[j]=temp;
			i++;
			j--;
		}
	}
}
