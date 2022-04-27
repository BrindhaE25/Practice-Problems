import java.util.*;

class balancedparanthesis {
	public static void main(String args[]) {
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		map.put(')','(');
		map.put('}','{');
		map.put(']','[');
		String s = "{[(]}";
		int len = s.length();
        ArrayList <Character> arr = new ArrayList<Character>();
        arr.add(s.charAt(0));
        for(int i = 1;i<len;i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ) {
                arr.add(s.charAt(i));    
            }
            else {
                if(arr.get((arr.size()-1))== map.get(s.charAt(i)))
                	arr.remove((arr.size()-1));
            }
        }
        if(arr.size() == 0)
        	System.out.println("true");
        else
        	System.out.println("false");


        
	}
}