package leetcode;
import java.util.*;
public class MergeInterval {
	@SuppressWarnings("unused")
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()==1) return intervals;
        if(intervals==null) return null;
        int i=0;
        Collections.sort(intervals,new IntervalComparator());
        while(i<intervals.size()-1){
            if(intervals.get(i).end>=intervals.get(i+1).start){
                intervals.get(i).end=Math.max(intervals.get(i).end,intervals.get(i+1).end);
                intervals.remove(i+1);
            }
            else i++;//if modified, don't need to i++
        }
        return intervals;
    }

	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	}
	//Insertion of intervals
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null) return null;
        
        int p=0;
        while(p<intervals.size() && newInterval.start>intervals.get(p).start){
            p++; // find p position 
        }
        intervals.add(p,newInterval); //insert
        if(p!=0) p--; //before that position
        while(p<intervals.size()-1){
            if(intervals.get(p).end>=intervals.get(p+1).start){   //[3,5]->[3,9]->[3,10]........take [3,5],[4,9],max of 5 and 9
            // has to have a equal sign here
                intervals.get(p).end=Math.max(intervals.get(p).end,intervals.get(p+1).end);
                intervals.remove(p+1); //[1,2],[3,9],[4,9],[6,7],[8,10],[12,16] some needs to remove; it's a DP
            }
            else p++;
        }
        return intervals;
    }
    public class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval l1, Interval l2){
            return l1.start-l2.start;

        }
        
    }
}
