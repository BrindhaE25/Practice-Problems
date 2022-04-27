class lefttriangle {
	public static void main(String args[]) {
		int row =5;
		for(int i=1;i<=row;i++) {
			System.out.printf("%"+ (row-i+1)+ "s"," ");
			for(int j=1;j<=i;j++)
				System.out.printf("*");
			System.out.println();
		}
	}
}