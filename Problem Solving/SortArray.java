import java.util.*;

public class SortArray {
	
	public int[] checkArray(int arr[], int n) {
		for(int i=0;i<n-1;i++) {
			if(arr[i] == arr[i+1]) {
				for(int k=i; k< n-1;k++)
					arr[k] = arr[k+1];
			}
		}
		int j =0 ;
		if(arr[j] > arr[j+1]) {
			int low = 0;
			int high = arr.length -1;
			int temp = 0;
			while(low <= high) {
				temp = arr[low];
				arr[low]= arr[high];
				arr[high] = temp;
				low++;
				high--;
				
			}
			
		}
		//for(int z=0;z<n;z++)
			//System.out.print(arr[z] + " ");
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortArray sa = new SortArray();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in A array");
		int n1 = sc.nextInt();
		System.out.println("Enter the number of element in B array");
		int n2 = sc.nextInt();
		int a[]= new int[n1];
		int b[] = new int[n2];
		for(int x=0;x<n1;x++)
			a[x] = sc.nextInt();
		for(int y=0;y<n2;y++)
			b[y] = sc.nextInt();
				a = sa.checkArray(a,n1);
		b= sa.checkArray(b,n2);
		ArrayList <Integer> result = new ArrayList <Integer> ();
		int i=0, j=0;
		while(i< a.length && j< b.length) {
			if(a[i] <= b[j]) {
				result.add(a[i]);
				System.out.println(a[i]);
				i++;
			}
			if(a[i] == b[j])
				j++;
			if(b[j] <= a[i]) {
				result.add(b[j]);
				//System.out.println(result.get(i));
				System.out.println(b[j]);
				j++;
			}
		}
		while(i<a.length) {
			result.add(a[i]);
			System.out.println(a[i]);	
			i++;
		}
		
		while(j<b.length) {
			result.add(b[j]);
			System.out.println(b[j]);
			j++;
		}
			
		for(Integer res : result) {
			System.out.print(res + " ");
		}
		
		
			
		

	}

}
