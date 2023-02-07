/*
     *
    **
   ***
  ****
 *****
 */
class diamond {
	public static void main(String args[]) {
		int row =5;
		for(int i=1;i<=row;i++) {
			for(int k=1;k<=row;k++) {
			System.out.printf("%"+ (row-k+1)+ "s"," ");
			for(int l=1;l<=k;k++)
				System.out.printf("*");
			System.out.println();
		}
		
		}


	}
}
