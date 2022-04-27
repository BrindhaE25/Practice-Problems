import java.util.*;
import java.io.*;

class bubblesort {
	public static void main(String args[]) {
		int arr[] = new int [] {90,80,70,50,60,30,40,10,20};
		int size = arr.length;
		for (int i=0;i<arr.length-1;i++) {
			int exchange =0;
			for(int j=0;j<size-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					exchange = exchange+1;
				}
			}
			if(exchange == 0){
				for(int k=0;k<arr.length;k++)
					System.out.println(arr[k]);
			}
			size = size -1;
			
		}

	}
}