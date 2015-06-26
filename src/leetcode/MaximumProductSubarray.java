package leetcode;

public class MaximumProductSubarray {
	//O(N2)
	public int maxProduct1(int[] nums) {
        if(nums.length==1) return nums[0];
        int max=Integer.MIN_VALUE;
        int[] prod=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i==j) {
                    prod[j]=nums[i];
                    continue;
                }
                prod[j]=prod[j-1]*nums[j];
                max=Math.max(max,prod[j]);
            }
        }
        return max;
    }
	public int maxProduct(int[] nums){
        if(nums.length==1) return nums[0];
        int max=nums[0];
        int premax=nums[0];
        int premin=nums[0];
        for(int i=1;i<nums.length;i++){
        		int temp=premin;
        		//只取一个最小值是不够的，需要取两个
        		premin=Math.min(Math.min(premax*nums[i], premin*nums[i]),nums[i]);
        		premax=Math.max(Math.max(premax*nums[i], temp*nums[i]),nums[i]);
        		max=Math.max(premax, max);
        }
        return max;
	}
	public static void main(String args[]){
		int[] nums={2,3,-2,4};
		MaximumProductSubarray test=new MaximumProductSubarray();
		System.out.println(test.maxProduct(nums));
	}
}
