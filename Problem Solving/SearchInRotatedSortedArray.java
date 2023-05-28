//There is an integer array nums sorted in ascending order (with distinct values).Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//        Example 1:
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
//        Example 2:
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1
//        Example 3:
//        Input: nums = [1], target = 0
//        Output: -1
public class SearchInRotatedSortedArray {

    public static void main(String args[]) {
        int arr[] = new int[]{4,5,6,7,0,1,2};
        int target = 3;
        int index = search(arr, 0, arr.length - 1, target);
        System.out.println(index);
    }

    private static int search(int[] arr, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (low > high) return -1;
        if(arr[low] == target) return low;
        if(arr[high] == target) return high;
        if (arr[mid] == target && arr[mid - 1] > arr[mid]) return mid;
        else {
            if (target < arr[mid]) {
                if (target <= arr[low]) return search(arr, mid + 1, high, target);
                else return search(arr, low, mid - 1, target);
            } else {
                if (target >= arr[high]) search(arr, low, mid - 1, target);
                else return search(arr, mid + 1, high, target);
            }
        }
        return -1;
    }
}
