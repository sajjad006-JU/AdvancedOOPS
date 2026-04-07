// 4. You have the number of goals scored by the football teams of the world cup for a year. 
// Store them in a collection. Find the product of all the scores except itself. 
// The product of any prefix or suffix is expected to fit in Java’s int range. Otherwise, remove 
// the very high scorers. 
// Write program to display the products for the corresponding scores as input. The program 
// should run in less than O(n^2) time and should not use /.
// Sajjad Ahmed Shaaz, 002410501093

import java.util.*;

public class ProductArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++)
            left[i] = left[i-1] * arr[i-1];

        right[n-1] = 1;
        for (int i = n-2; i >= 0; i--)
            right[i] = right[i+1] * arr[i+1];

        for (int i = 0; i < n; i++)
            result[i] = left[i] * right[i];

        System.out.println(Arrays.toString(result));
    }
}