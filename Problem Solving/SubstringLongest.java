import java.util.*;

class SubstringLongest {
	
	public static void main(String args[] ) {
		String [] strs = {"flower","flow","flight"};
		/*for(int i=0;i<strs.length;i++)
			System.out.println(strs[i].charAt(i)); */
		String sb = "";
        int len = strs[0].length();
        for(int i=0;i<len;i++) {
            for(String str : strs) {
            	int res = Character.compare(str.charAt(i),strs[0].charAt(i));
            	System.out.println(res + " "+ str.length() +" "+ i);
            	if(i == str.length() || str.charAt(i) != strs[0].charAt(i))
                    break;
            }
            sb = sb.concat(String.valueOf(strs[0].charAt(i)));
            System.out.println(sb);
             

            }
        System.out.println(sb);
                          
        }
        
                        
    }

