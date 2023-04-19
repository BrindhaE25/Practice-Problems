class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,1,5};
        int iter = arr.length-2;
        int lastElem = arr[arr.length-1];
        int pivot = -1;

        while (iter >= 0) {
            if(arr[iter] < lastElem) {
                pivot = iter;
                break;
            }
            iter--;
        }

        if(pivot != -1) {
            iter = arr.length - 1;
            while (iter >= 0) {
                if (arr[iter] > arr[pivot]) {
                    swap(iter, pivot, arr);
                    break;
                }
                iter--;
            }
        }
        else {
            reverse(arr);
        }
        print(arr);
    }

    private static void swap(int iter, int pivot, int[] arr) {
        int temp = arr[iter];
        arr[iter] = arr[pivot];
        arr[pivot] = temp;
    }

    private static void reverse(int[] arr) {
        int low=0, high = arr.length-1;

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
