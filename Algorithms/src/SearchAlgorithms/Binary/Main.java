package SearchAlgorithms.Binary;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] array = {1,4,6,8,23,43,26,2,53,26,75,256,1452,6474,24523};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        System.out.println(search(target, array));

    }

    public static int search(int target, int[] array) {
        //Array must be sorted!
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; //Middle of the searching area.

            if (array[mid] == target) return mid; //Take an example from the middle of the array.
            else if (array[mid] < target) low = mid + 1; // If middle index value is smaller than the target that means our target is in the right values from the middle; so we increment the value of the low.
            else high = mid - 1; // If not that means target value is in the left values of the array; so we decrement the high value.
        }
        return -1;
    }
}
