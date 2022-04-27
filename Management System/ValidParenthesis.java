import java.util.*;
public class ValidParenthesis {
	public void validParenthesis(int openP, int closeP, String res) {
		if(openP == 0 && closeP == 0)
			System.out.println(res);
		
		if(openP > closeP) 
			return;
		if(openP > 0)
			validParenthesis(openP-1,closeP,res + "(");
		if(closeP > 0)
			validParenthesis(openP,closeP-1,res + ")");
				}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ValidParenthesis vp = new ValidParenthesis();
		int n = sc.nextInt();
		String res = " ";
		vp.validParenthesis(n,n,res);

	}

}
