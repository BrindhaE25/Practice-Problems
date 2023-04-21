class KThClosestElement {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; //12, 16, 22, 30, 39, 42, 45, 48, 50, 53, 55, 56
        int k = -1;
        int n = arr.length - 1;

        int pivot = binarySearch(0, n, k, arr);
        printResult(pivot, pivot + 4, arr);
    }

    private static void printResult(int low, int high, int[] arr) {
        System.out.print("Result ");
        for (int iter = low; iter < high; iter++)
            System.out.print(arr[iter] + " ");
    }

    private static int binarySearch(int low, int high, int k, int[] arr) {
        if (arr[low] > k) // k is smaller than array's first element
            return low;
        else if (arr[high] < k) // k is greater than array's last element
            return high - 3;
        else {
            while(true) {
                int mid = (low + high) / 2;
                if (arr[mid] <= k && arr[mid + 1] > k) {
                    return getPivot(k, arr, mid);
                } else if (arr[mid] < k) {
                    low = mid;
                } else if (arr[mid] > k) {
                    high = mid;
                }
            }
        }
    }

    private static int getPivot(int k, int[] arr, int mid) {
        int count = 1;
        int result = -1;
        int low = mid;
        int high = mid + 1;
        while (count < 5 && low > -1 && high < arr.length) {
            if (Math.abs(arr[low] - k) <= Math.abs(arr[high] - k)) {
                count = count + 1;
                result = low;
                low = low - 1;
            } else {
                count = count + 1;
                high = high + 1;
            }
        }
        return result;
    }

}
