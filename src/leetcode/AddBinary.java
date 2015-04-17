package leetcode;

public class AddBinary {
	public String addBinary(String a, String b) {
		int m=a.length()-1;
		int n=b.length()-1;
		int len=Math.max(m, n)+1;
		char[] res=new char[len+1];
		int carry=0;
		while(len>=0){
			if(m>=0)
				res[len]+=a.charAt(m--)-'0';
			if(n>=0)
				res[len]+=b.charAt(n--)-'0';
			int temp=res[len]+carry;//cannot -'0' here,res[len] is already a int with cast
			//its because res[len] is related to the default value, but not 0.
			res[len]=(char)(temp%2 + '0');
			carry=temp/2;
			len--;
		}
		if(res[0]=='0') res[0]=' ';
		//Cannot use res.toString here ,since res is a array, the way of doing it is Arrays.toString(res);
		//but this will return an array!!!! so only way to do it is with valueOf
		return String.valueOf(res).trim();
	}
	public static void main(String args[]){
		AddBinary test=new AddBinary();
		String a="111";
		String b="10";
		String res=test.addBinary(a, b);
		System.out.println(res);		
	}
}
