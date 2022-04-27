
public class SecondGreaterNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] arr = {2,4,6,7,0,13,8};
		int first = -999;
		int second = 999;
		
		for(int i=0;i<arr.length;i++) {
			first = arr[i];
			second = 999;
			for(int j=0;j<arr.length;j++) {
				if(first < arr[j] && second > arr[j] ) {
					//System.out.print(secnd_element);
					second = arr[j];	
					//System.out.println(first + " "+ second);
			}
				
			}
			if(second != 999)
				System.out.print(second +" ");
			else 
				System.out.print("-1 ");
			
				
			
		}

	}

}

