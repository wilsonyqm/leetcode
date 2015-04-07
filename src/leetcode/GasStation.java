package leetcode;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
//		Complexity O(N)
//		Two assumptions:
//		If car starts at A and can not reach B (let’s say B is the first station that A can not reach), 
//		then any station between A and B can not reach B.
//		
//		If the total number of gas is bigger than the total number of cost. There must be a valid solution.
//		
		int len=gas.length;
		int total=0;// total for all the sums which satisfies assumption 2;
		int sum=0;// sum for recording every period of stations
		int i=0,j=0;
		while(i<len){
			int diff=gas[i]-cost[i];
			if(sum+diff<0){
				j=i+1;
				sum=0;
			}else{
				sum+=diff;
			}
			i++;
			total+=diff;
		}
		return total<0 ? -1:j;
    }
	public static void main(String args[]){
		
	}
}
