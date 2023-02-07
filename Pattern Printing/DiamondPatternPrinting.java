/* Diamond Pattern Printing
		A
	       B B
	      C   C
	       B B
	        A
*/
import java.util.*;
public class PatternPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the alphabet");
		char charRow = sc.nextLine().charAt(0);
		int row = (int)charRow - 64;
		for(int i=0;i<row;i++) {
			System.out.printf("%" + (row-i) + "s", " ");
			int toprint = 'A'+i;
			System.out.print((char)toprint);
			if(toprint > 65) {
				System.out.printf("%"+ (i*2) + "s", " ");
				System.out.print((char)toprint);
				
				
			}
			System.out.println("");
			
			}
		int k = 1;
		int toprint1 = 'E';
		for(int j=row-1;j > 0;j--) {
			System.out.printf("%" + (row-j+1) + "s", " ");
		
			System.out.print((char)toprint1);
			if(toprint1 > 65) {
				System.out.printf("%"+ (j*2-2) + "s", " ");
				System.out.print((char)toprint1);
				
				
			}
			System.out.println("");
			toprint1 = 'E'- k;
			k++;
			
			}


	}

}
