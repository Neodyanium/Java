package DataStructure.Arrays;

import java.util.*;

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {4,1,2,3,1};
        int n = mergeSort(arr,0,arr.length-1);
        System.out.println(n);
    }


    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        count += merge(arr, low, mid, high);
        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int left = low, right = mid + 1;
        count += calculatePoint(arr, low, mid, high);
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
        return count;
    }

    public static int calculatePoint(int[] arr, int low, int mid, int high) {
        int count = 0;
        int p2 = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (p2 <= high &&  arr[i] > 2 * arr[p2])
                p2++;
            count += p2 - (mid + 1);
        }
        return count;
    }
}
