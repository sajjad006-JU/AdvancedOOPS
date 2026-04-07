// 1. Subham has n sweets, where the ith sweet is of type Sandesh (say) while (i+1)th type is 
// Pithe (say). So, the types need to be encoded by numerals for the assignment. He noticed 
// that he started to gain weight.  
// His classmate Biprarshi advised him to only eat n / 2 of the sweets and distribute the rest 
// among friends. Subham still wishes to taste the maximum number of different types of 
// sweets while not ignoring his classmate’s suggestion. 
// So, if there are n sweets of k different varieties then Subham can have a maximum of n/2 
// sweets of x (<=k) different types of y different combinations.  
// Write an appropriate Java code using collections framework such that the system takes n 
// (even or odd) and k as input and provides the value of x along with at least some of the y 
// combinations if not all
// Sajjad Ahmed Shaaz, 002410501093

import java.util.*;

public class Sweets {
    public static void main(String[] args) {
        int n = 10; // total sweets
        int k = 6;  // distinct types

        int maxTypes = Math.min(k, n / 2);
        System.out.println("Maximum different types (x): " + maxTypes);

        // Example sweets (types encoded as numbers)
        int[] sweets = {1,2,3,4,5,6,1,2,3,4};

        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int sweet : sweets) {
            if (set.size() < maxTypes && !set.contains(sweet)) {
                set.add(sweet);
                result.add(sweet);
            }
        }

        System.out.println("One possible combination: " + result);
    }
}