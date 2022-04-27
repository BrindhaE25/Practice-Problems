import java.util.*;
public class LargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();
		int midresult = 0;
		int arr[] = new int[n];
		for(int a=0;a<n;a++)
			arr[a] = sc.nextInt();
		
		int result = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i< n; i++) {
			sum =0;
			for(int j=i; j< n; j++) {
				sum+= arr[j];	
			}
			if(sum > result)
				result = sum;
		}
		if(result < 0) {
			for(int k=0;k<n;k++) {
				
				if(arr[k] > 0) {
					midresult += arr[k];
					
				}
					
				
			}
			if(midresult > result)
				result = midresult;
		}
		System.out.println(result);

	}

}
