/*
1 
2 6 
3 7 10 
4 8 11 13 
5 9 12 14 15 
*/
import java.util.*;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int row = sc.nextInt();
		//int n = row-1;
		int temp = 0;
		for(int i=1;i<=row;i++) {
			temp =i;
			//n = row -1;
			for(int j=1;j<=i;j++) {
				System.out.print(temp + " ");
				temp = temp + (row-j);
			}
			System.out.println();
		}

	}

}
