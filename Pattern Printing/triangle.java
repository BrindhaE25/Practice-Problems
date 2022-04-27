import java.io.*;
import java.util.*;
  
class triangle {
    public static void main(String args[])
    {
    	String str = "geeksforgeeks";
    	int len = str.length();
    	for(int i=0;i<(str.length()/2);i++) {
    		System.out.printf("%" +(i+1) + "s"," ");
    		System.out.printf("%c",str.charAt(i));
    		System.out.printf("%" + (len-i-(i+1)) + "s", " ");
    		System.out.printf("%c",str.charAt(len-i-1));
    		System.out.println();
    		}
    	int k = (int)Math.ceil(len/2);
    	System.out.printf("%" + (k+1) + "s", " ");
    	System.out.printf("%c",str.charAt(k));

    }
}