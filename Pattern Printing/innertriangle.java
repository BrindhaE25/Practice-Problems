class innertriangle {
	public static void main(String args[]) {
		int row=5;
		int k =1;
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++)
				System.out.printf("*");
			if(i<5)
				System.out.printf("%" + ((k++)*2) + "s"," ");
			for(int j=1;j<=i;j++)
				System.out.printf("*");
			System.out.println();
		}
		for(int a=1;a<=row;a++) {
			for(int b=1;b<=a;b++)
				System.out.printf("*");
			if(a<5)
				System.out.printf("%" + ((row-a)*2) + "s"," ");
			for(int b=1;b<=a;b++)
				System.out.printf("*");


			System.out.println();
		}

	}
}