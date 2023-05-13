//Given a sorted array arr[] with possibly duplicate elements, the task is to find indexes of the first and last occurrences of an element x in the given array.
//
//Examples:
//
//Input : arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}, x = 5
//Output : First Occurrence = 2
//         Last Occurrence = 5
public class FirstAndLastElement {

    public static void main(String args[]) {
        int arr[] = new int[]{1, 3, 5, 5, 5, 5, 7, 123, 125};
        int target = 5;
        int result[] = binarySearch(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int result[] = new int[2];
        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == target) {
                if(arr[low] == target) {
                    arr[0] = low;
                    arr[1] = mid;
                    return arr;
                }
                else if(arr[high] == target) {
                    arr[0] = mid;
                    arr[1] = high;
                    return arr;
                }
                else if(arr[low] < target)
                    low = (low + mid)/2;
                else if(arr[high] > target)
                    high = (mid + high)/2;

            }
            else if(arr[mid] < target)
                low = mid + 1;
            else if(arr[mid] > target)
                high = mid - 1;
        }
        return new int[]{-1,-1};
    }
}
