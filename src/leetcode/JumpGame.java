package leetcode;

public class JumpGame {
    public int jump(int[] A) {
        int num=0;
        int s=0;
        while(s<A.length-1){
            int temp=-1;
            int t=-1;
            for(int i=1;i<=A[s];i++){
                //should have condition for end case, for example [3,2,1], the len of 3 and 2 are the same but, the 3 only 1step but 2 two step
                //so if we can reach the end, then we'd better finish, or there would be more result come out
                if(s+i==A.length-1) t=i;//IMPORTANT
                if((s+i)<A.length){
                    if(A[i+s]+i>temp){
                        temp=A[i+s]+i;
                        t=i;
                    }
                }
                //else break;
            }
            s=s+t;
            num++;
        }
        return num;
    }

}
