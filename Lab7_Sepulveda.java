import java.util.*;

public class Lab7_Sepulveda {

    public static void main(String[]args){

        long beforeLin=0, afterLin=0, afterBin=0, beforeBin=0, afterRec=0, beforeRec=0;
        double arr[] = new double[100000];
        for (int i=0;i<arr.length; i++){
            arr[i]=(Math.random()*arr.length);
        }

        for (int i=0; i<20; i++){
            int index = (int)(Math.random()*arr.length-1);
            double x = arr[index];
            beforeLin += (System.nanoTime())/20;
            linearSearchIterative(arr,x);
            afterLin += (System.nanoTime())/20;
        }
        System.out.println("Nano seconds to run Linear Search: "+(afterLin-beforeLin));

        long beforeSort = System.nanoTime();
        Arrays.sort(arr);
        long afterSort = System.nanoTime();
        System.out.println("Nano seconds to run Arrays.sort(): "+(afterSort - beforeSort));


        for (int i=0; i<20; i++){
            int index = (int)(Math.random()*arr.length-1);
            double x = arr[index];
            beforeBin += (System.nanoTime())/20;
            binarySearchIterative(arr,x);
            afterBin += (System.nanoTime())/20;
        }
        System.out.println("Nano seconds to run Binary Iterative Search: "+(afterBin-beforeBin));

        for (int i=0; i<20; i++){
            int index = (int)(Math.random()*arr.length-1);
            double x = arr[index];
            beforeRec += (System.nanoTime())/20;
            binarySearchRecursion(arr,0,arr.length-1,x);
            afterRec += (System.nanoTime())/20;
        }
        System.out.println("Nano seconds to run Binary Recursive Search: "+(afterRec-beforeRec));


    }

    //print a double array
    public static void printArr(double[]arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }

    //Iterative linear search
    public static int linearSearchIterative(double arr[], double x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    //iterative binary search
    public static int binarySearchIterative(double arr[], double x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int m = low + (high - low) / 2;
            // Check if x is present at mid
            if (arr[m] == x){
                return m;
            }
            // If x greater, ignore left half
            if (arr[m] < x) {
                low = m + 1;
            }
            // If x is smaller, ignore right half
            else {
                high = m - 1;
            }
        }
        // if we reach here, then element was
        // not present
        return -1;
    }

    //recursive binary search
    public static int binarySearchRecursion(double arr[], int low, int high, double x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            // If the element is present at the
            // middle itself
            if (arr[mid] == x) {
                return mid;
                // If element is smaller than mid, then
                // it can only be present in left subarray
            }
            if (arr[mid] > x) {
                return binarySearchRecursion(arr, low, mid - 1, x);
                // Else the element can only be present
                // in right subarray
            } else {
                return binarySearchRecursion(arr, mid + 1, high, x);
            }
        }
        // We reach here when element is not present
        // in array
        return -1;
    }
}
