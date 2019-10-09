package SortTest;
import java.util.*;

public class SortTestMain {
    public static void main(String []args){
        System.out.println("Sort Test");
        int []num = {11, 21, 33, 42, 13, 56, 22, 63};
        //HeapSort(num);
        shellSort(num);
        System.out.println(Arrays.toString(num));
    }






    public static void ShellSortInsert(int []a, int dk){
        for(int i = dk; i < a.length; i++){
            if(a[i] < a[i-dk]){
                int j;
                int x = a[i];
                a[i] = a[i-dk];
                for (j = i-dk; j>=0 && x<a[j]; j=j-dk){
                    a[j+dk] = a[j];
                }
                a[j + dk] = x;
            }
        }
    }
    public static void shellSort(int []a){
        int dk = 3;
        while (dk >= 1){
            ShellSortInsert(a,dk);
            dk = dk/2;
        }
    }





    //HeapSort
    public static void adjustHeap(int []arr, int i, int length){
        int temp = arr[i];
        for(int k=2*i+1; k<length; k=k*2+1){
            if(k+1 < length && arr[k] <arr[k+1]){
                k++;
            }
            if(arr[k]>temp){
                arr[i] = arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
    public static void swap(int []arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void HeapSort(int []arr){
        for(int i = arr.length/2-1;i>=0;i--){
            adjustHeap(arr, i, arr.length);
        }
        for(int i =arr.length - 1; i>0; i--){
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }
}
