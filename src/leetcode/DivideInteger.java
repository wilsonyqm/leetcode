package leetcode;

public class DivideInteger {
		public int divide(int dividend, int divisor) {
			long dvd=dividend;
			long dvs=divisor;
	        dvd=dividend<0 ? -1*dvd:dvd;
	        dvs= divisor<0 ? -1*dvs:dvs;
	        if(dvd<dvs) return 0;
	        long old_dvs=dvs;
	        boolean sign=(dividend<0)^(divisor<0);
	        int step=0;
	        while(dvd>dvs){
	        	dvs=dvs<<1;
	        	step++;
	        }
	        long result=0;
	        while(dvd>=old_dvs){
	        	if(dvd>=dvs){
	        		dvd-=dvs;
	        		result+=(long) 1<<step;//the long here is so important!! otherwise the -2147483648/-1
	        		//will overflow to be a negative number
	        	}
	        	step--;
	        	dvs=dvs>>1;
	        }
	        long finalQuo= sign ? -result:result;
	        //the condition below is also very necessary, if not, the overflow problem will also happened
	        if (finalQuo < Integer.MIN_VALUE || finalQuo > Integer.MAX_VALUE) {
	            return Integer.MAX_VALUE;
	        } else {
	            return (int) finalQuo;
	        }
	    }
    
	public static void main(String args[]){
		DivideInteger test=new DivideInteger();
		System.out.println(test.divide(-1010369383, -2147483648));
		System.out.println(test.divide(-2147483648, -1));
	}
	
}
