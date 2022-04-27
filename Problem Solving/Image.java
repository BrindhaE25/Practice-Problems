import java.util.*;
public class Image {
	int min=0, max = 6;
    int sol;
    public int checkCell(int row,int col,char [][]arr, char color) {
        if(row < min || row > max || col < min || col > max)
            return 0;
        if(arr[row][col] != 'r')
        	return 0;
        else {
        	//arr[row][col] = 'o';
        	  return 1;  
   
        }
        
        }
    public char[][] replaceColor(int row, int col, char [][] arr,char color) {
    	if(row < min || row > max || col < min || col > max)
            return arr;
    	if(arr[row][col] == 'r')
    		arr[row][col] = color;

        if(checkCell(row+1,col,arr,color) !=0) {
        	System.out.println((row+1) + " "+ col);
        	 arr[row+1][col] = color;
        	 replaceColor(row+1,col,arr,color);	
        }
           
        if(checkCell(row,col-1,arr,color) != 0) {
        	System.out.println(row + " " + (col-1));
        	arr[row][col-1] = color;
        	replaceColor(row,col-1,arr,color);	
        	
        }
        	
        if(checkCell(row,col+1,arr,color) != 0) {
        	System.out.println(row + " " + (col+1));
        	arr[row][col+1] = color;
        	replaceColor(row,col+1,arr,color);	

        	
        }
        	
        if(checkCell(row-1,col,arr,color) != 0) {
        	System.out.println(row-1 + " " + col);
        	arr[row-1][col] = color;
        	replaceColor(row-1,col,arr,color);
        	
        }
        
          return arr;      
        
  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Image im = new Image();
        char [][] arr = {{'r','g','g','g','g','g','r'},{'y','r','r','r','r','r','y'},{'y','y','r','r','r','y','y'},{'b','b','b','r','b','b','b'},{'y','y','r','r','r','y','y'},{'y','r','r','r','r','r','y'},{'r','g','g','g','g','g','r'}};
        
        char result [][] = new char[7][7];
        System.out.println("Enter the color to fill");
        char color = sc.nextLine().charAt(0);
        System.out.println("Enter the cell to fill with:");
        int row = sc.nextInt();
        int col = sc.nextInt();
        result = im.replaceColor(row-1,col-1,arr,color); 
        //arr[2][2] = color;
        for(int i=0;i<7;i++) {
            for(int j=0;j<7;j++)
                System.out.print(result[i][j] + " ");
            System.out.println("");
        }

	}

}
