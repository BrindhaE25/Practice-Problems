import java.util.*;
import java.io.*;

class selectionsort {
    
    public void sort() {
        int arr[] = new int[] {70,60,50,40,30,20,10,5};
        int min_index = 0;

        for (int i=0 ; i< arr.length-1; i++) {
            min_index = i;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j] < arr[min_index])
                min_index = j;
            }
            if (min_index != i) {
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i=0;i<arr.length;i++)
        System.out.println(arr[i]);
    }

    public static void main(String args[]){
        selectionsort s = new selectionsort();
        
        s.sort();
        int arr[] = new int[] {70,60,50,40,30,20,10,5};
        int min_index = 0;

        for (int i=0 ; i< arr.length-1; i++) {
            min_index = i;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j] < arr[min_index])
                min_index = j;
            }
            if (min_index != i) {
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i=0;i<arr.length;i++)
        System.out.println(arr[i]);
    
        
}
}