class sandglass {
	public static void main(String args[]) {
		int row = 5;
		int ind = 1;
		for(int i=5;i>=1;i--) {
			System.out.printf("%"+ ind+ "s"," ");
			for(int j=1;j<=(row-ind+1);j++)
				System.out.printf("* ");
		ind = ind +1;
		System.out.println();
		}
		for(int i=1;i<=row;i++)
		 {
		 	System.out.printf("%" + (row-i+1) + "s"," ");
		 	for(int j=1;j<=i;j++) {
		 		
		 		System.out.printf("* ");
		 	}
		 	System.out.println();

		 }
		
	}
}