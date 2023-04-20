//        Input: arr = [1,2,3]
//        Output: [1,3,2]
//        Explanation: for 1,2,3 the next lexicographically greater permutation of its integer is 1,3,2
//        Input: arr = [3,2,1]
//        Output: [1,2,3]
//        Works like the dictionary like how the words are ordered
class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {0,1,2,5,3,3,0};
        int iter = arr.length-2;
        int lastElem = arr[arr.length-1];
        int pivot = -1;

        while (iter >= 0) {
            if(arr[iter] < lastElem) {
                pivot = iter;
                break;
            }
            lastElem = arr[iter];
            iter--;
        }

        if(pivot != -1) {
            iter = arr.length - 1;
            while (iter >= 0) {
                if (arr[iter] > arr[pivot]) {
                    swap(iter, pivot, arr);
                    reverse(pivot+1,arr.length-1,arr);
                    break;
                }
                iter--;
            }
        }
        else {
            reverse(0,arr.length-1,arr);
        }
        print(arr);
    }

    private static void swap(int iter, int pivot, int[] arr) {
        int temp = arr[iter];
        arr[iter] = arr[pivot];
        arr[pivot] = temp;
    }

    private static void reverse(int low, int high,int[] arr) {
        while (low <= high) {
            swap(low,high,arr);
            low++;
            high--;
        }
    }

    private static void print(int[] arr) {
        for(int iter = 0; iter < arr.length; iter++)
            System.out.print(arr[iter] + " ");
    }
}
