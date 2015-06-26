package leetcode;
import java.util.*;
public class LargestNumber {
	public String largestNumber(int[] nums) {
        if(nums.length==1) return String.valueOf(nums[0]);
        ArrayList<String> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
        		arr.add(String.valueOf(nums[i]));
        }
        String res="";
        boolean b=true;// this boolean for considering "00"
        Collections.sort(arr,new NewComparator());
        for(String ar:arr){
            if(!ar.equals("0")) b=false;
            res=res+ar;
        }
        return b ? "0" : res;
    }
	class NewComparator implements Comparator<String>{
		public int compare(String a,String b){
		    //cannot implement like this, since it will overflow
			//int a1=Integer.parseInt(a+b);
			//int b1=Integer.parseInt(b+a);
			//return (a1>b1)? 1:-1;
			String a1=a+b;
			String a2=b+a;
			//inverse order for having the large number at head;
			return a2.compareTo(a1);
		}
	}
}
