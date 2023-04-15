//Given an integer array nums and an integer k, return the kth largest element in the array.
//        Note that it is the kth largest element in the sorted order, not the kth distinct element.
//        Input: nums = [3,2,1,5,6,4], k = 2
//        Output: 5
//        Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//        Output: 4
public class KthLargestElement {

    public static void main(String[] args) {
        Integer[] arr = {-10,-5,-11,-13,-4,-15};
        int k = 2;
        quickSort(arr,0,arr.length-1);
        System.out.println("Output " + arr[k-1]);
    }

    private static void quickSort(Integer[] arr, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1, high);
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        int i = low;
        int pivot = arr[low];

        for(int j=low+1;j <= high; j++) {
            if(arr[j] > pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr,i, low);
        return i;
    }

    private static void swapElements(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
