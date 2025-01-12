package FindMedianSortedArrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArraysBruteForce(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArraysBruteForce(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
    }

    private static double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            mergedArray[index++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            mergedArray[index++] = nums2[i];
        }

        Arrays.sort(mergedArray); // Array is sorted.

        if(mergedArray.length % 2 == 1){
            return (double) mergedArray[mergedArray.length / 2];
        } else {
            int middle1 = mergedArray[mergedArray.length / 2 - 1]; //[1,2,3,4] don't forget to think with index numbers.
            int middle2 = mergedArray[mergedArray.length / 2];

            return (double) (middle1 + middle2) / 2;
        }
    }
}
