
public class SubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] arr = {1,1,1,0,0,1};
		int cnt0=0, cnt1 = 0;
		int condition = 1;
		int j=0;
		//System.out.println(arr.length);
		while(condition != 0) {
			cnt0 = 0;
			cnt1= 0;
			for(int i=j;i<arr.length;i++) {
				if(arr[i] == 0)
					cnt0 = cnt0 +1;
				else
					cnt1 = cnt1 + 1;		
			}
			if(j == arr.length-1 && (cnt0 != cnt1)) {
				condition = 0;
				System.out.println("Not possible");
				
			}
			
			else if(cnt0 == cnt1) {
				condition = 0;
				System.out.println(j + "to" + arr.length);
				break;
					
		}
			else
				j= j+1;
			
		

	}
}
}