import java.util.*;
class zigzag {
	public static void main(String args[]) {
		int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		int row = arr.length;
		int col = arr[0].length;
		ArrayList <ArrayList <Integer>> sol = new ArrayList<ArrayList<Integer>>(row*col-1);
		for(int a=0; a< (row*col-1); a++)
			sol.add(new ArrayList<Integer>());
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if((i+j)%2 == 0)
					sol.get(i+j).add(0,arr[i][j]);
				else
					sol.get(i+j).add(arr[i][j]);
			}
		}
		System.out.println(sol.get(1));
		for(ArrayList<Integer> solution : sol) {
			for(Integer i : solution)
				System.out.print(i+" ");
		}
		}
}