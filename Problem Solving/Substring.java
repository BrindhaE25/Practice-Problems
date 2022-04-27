import java.util.*;

public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = sc.next();
		String result = "";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u' )
				result = result + s.charAt(i);
			else
				result = result + ',';
		}
		//System.out.println(result);
		String res [] = result.split(",");
		if(res.length == 0) {
			System.out.println("The string contain only vowels");
				
		}
		int len = -1;
		for(int j=0;j<res.length;j++) {
			if(res[j].length() >= len)
				len = res[j].length();	
		}
		for(int k=0;k<res.length;k++) {
			
			if(res[k].length() == len)
				System.out.println(res[k]);
		}

	}

}
