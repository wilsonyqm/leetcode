package leetcode;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[1],nums[0]);
        int n=nums.length;
        //include first and not the last{
        int[] iter=new int[n];
        //Cannot assign here with iter=num, or it will have a shallow copy, which will change num
        int first=0; //no last element so first is impossible
        int second=nums[0];//only by taking the first element
        
        for(int i=2;i<n;i++){
            //remember it's not include the last element, so we add like this
            iter[i]=Math.max(second,first+nums[i-1]);//nums[i-1] take the element before,since last element cannot take +
            //first which is also include the first element here,it include the element before first, so it can be added.
            first=second;
            second=iter[i];
        }
        //include last but not first
        first=0;
        second=nums[1];
        for(int i=2;i<n;i++){
            nums[i]=Math.max(second,first+nums[i]);
            first=second;
            second=nums[i];
        }
        return Math.max(nums[n-1],iter[n-1]);
    }
}
