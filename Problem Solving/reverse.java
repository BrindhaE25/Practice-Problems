import java.util.*;
import java.io.*;

class reverse {
	public static void main(String args[]) {
		//ArrayList <String> arr = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String str = sc.nextLine();
		System.out.println(str);
		StringBuffer rev = str.split("\\.");
		System.out.println(str.length());
		for(int i=0;i<rev.length;i++) {
			rev[i].setCharAt(0,'k');
			System.out.println(rev[i].charAt(0)); }
		System.out.println("Print something");
	}
}