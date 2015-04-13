package leetcode;

public class Strstr {
	public int strStr(String haystack, String needle) {
        int lenh=haystack.length();
        int lenn=needle.length();
        if(lenh<lenn) return -1;
        int j;//aaa a
        for(int i=0;i<lenh-lenn+1;i++){
            for(j=0;j<lenn;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
            if(j==lenn) return i;
        }
        return -1;
    }
}
