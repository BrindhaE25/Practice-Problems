import java.util.*;

public class OperatorPrecedence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = sc.next();
		int result = 0;
		int arr[] = new int[s.length()];
		int front = -1;
		int rear=-1;
		for(int i=0; i< s.length();i++) {
			//System.out.println(s.charAt(i));
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if(front == rear && front == -1) {
					front++;
					//System.out.println(s.charAt(i));
					arr[rear+1] = Integer.valueOf(s.charAt(i)) - 48;
					rear++;
					//System.out.println(arr[rear]);
				}
				else {
					arr[rear+1] = Integer.valueOf(s.charAt(i)) - 48;
					rear++;
					//System.out.println(arr[rear]);
				}
			}
			else {
				//System.out.println(arr[front] + " " + arr[front+1]);
				if(s.charAt(i) == '+')
					result = arr[front] + arr[front+1];
				else if(s.charAt(i)== '-')
					result = arr[front] - arr[front+1];
				else if(s.charAt(i)== '*')
					result = arr[front] * arr[front+1];
				else if(s.charAt(i)== '/')
					result = arr[front] / arr[front+1];
				arr[front+1] = result;
				//System.out.println(result);
				front = front + 1;
			}
				
			
		}
		System.out.println(result);

	}

}
