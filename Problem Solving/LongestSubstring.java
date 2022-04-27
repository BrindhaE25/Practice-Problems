import java.util.*;
public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String str= sc.next();
		 char [] arr = str.toCharArray();
		 StringBuffer result = new StringBuffer("");
		 String [] resul = new String[str.length()];
		 int size =0;
		 int idx= -1;
		 int j=0;
		 for(int i=0;i<str.length();i++) {
			 if(arr[i] != 'a' && arr[i] != 'e' && arr[i] != 'i' && arr[i] != 'o' && arr[i] != 'u') {
				 result.append(arr[i]);
				 //System.out.println(result); 
			 }
				 
			 else {
				 resul[j] = result.toString();
				 
				 if(size <= result.length()) {
					 size = result.length();
					 idx = j;
					 j = j+1;
					 
				 }
				 resul[j] = result.toString();
				 if(size < result.length()) {
					 size = result.length();
					 idx = j;
					 j = j+1;
					 
				 }
					
				 result.delete(0, result.length());		 
				 
			 }
				 
		 }
		
		//System.out.println(result);
		/*String [] res = result.split(",");
		int size = res[0].length();
		int idx = 0;
		for(int i=1;i<res.length;i++) {
			if(res[i].length() > size) {
				size = res[i].length();
				idx =i;
			}	
		} */
		if(size==1)
			System.out.println(Arrays.toString(resul));
		else
			System.out.println(resul[idx]);
		
	}

}
