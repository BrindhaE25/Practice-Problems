//  Input: arr = [2,0,2,1,1,0]

// Output: [0,0,1,1,2,2]

// Explanation: First all the 0's should come, following all the 1's and then 2's.

import java.util.*;

class  DutchNationalFlag {

    public static void main (String args[]) {
        List<Integer> input = new ArrayList<Integer>();
        List<Integer> inputArr = new ArrayList<Integer>();

        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the inputs by giving spaces");
        String input1 = sc.nextLine();
        String arr[] = input1.split(" ");
        for(String i : arr) {
            if(i.equals("0") || i.equals("1") || i.equals("2")) {
                input.add(Integer.valueOf(i));
                 inputArr.add(Integer.valueOf(i));
            }
            else {
                throw new RuntimeException("Input not accepted");
            }

        }
        dutchNationalFlag.solution1(input);
        dutchNationalFlag.solution2(inputArr);

    }

    public void solution1(List<Integer> input) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0, iter = 0;
        for(Integer i : input) {
            if(i == 0)
                cnt0++;
            if(i == 1)
                cnt1++;
            if(i == 2)
                cnt2++;
        }
        while(cnt0 > 0) {
                input.set(iter,0);
                cnt0--;
                iter++;
            }
             while(cnt1 > 0) {
                input.set(iter,1);
                cnt1--;
                iter++;
            }
             while(cnt2 > 0) {
                input.set(iter,2);
                cnt2--;
                iter++;
            }
            output(input);
    }

    public void solution2(List<Integer> input) {
        int low = 0, high = input.size()-1, mid = (low + high)/2;
        while(mid <= high) {
            if(input.get(low) == 0) 
                low++;
            else if(input.get(low) == 1) {
                swap(low,mid,input);
                mid++;

            }
            else if(input.get(low) == 2) {
                swap(low,high,input);
                high--;
            }

        }
        output(input);
    }

    public void swap(int low, int high, List<Integer> input) {
        int temp = input.get(low);
        input.set(low, input.get(high));
        input.set(high, temp);
    }

    public void output(List<Integer> input) {
        System.out.println("Output");
            for(Integer i : input)
                System.out.print(i + " ");
    }
}
