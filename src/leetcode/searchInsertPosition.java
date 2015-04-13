package leetcode;

public class searchInsertPosition {
	public int searchInsert(int[] A, int target) {
        int start = 0, end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //this divide conquer the start and end might not be the same at the final state
        //so u have to have condition to tell which result it should be. 
        // this is good to deal with the duplicates.
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;// this is for [1] 2, [1,3] 4 case, with insertion on the end and target is larger than the last;
        }
    }

}
