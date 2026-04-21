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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (total sweets): ");
        int n = sc.nextInt();
        System.out.print("Enter k (distinct types): ");
        int k = sc.nextInt();

        int limit = n / 2;
        int maxTypes = Math.min(k, limit);

        System.out.println("Maximum different types Subham can taste (x): " + maxTypes);
        System.out.println("He can eat at most " + limit + " sweets.\n");

        // Generate the sweet array: cycle through k types over n sweets
        int[] sweets = new int[n];
        for (int i = 0; i < n; i++) {
            sweets[i] = (i % k) + 1; // types: 1 to k
        }
        System.out.println("Generated sweets array: " + Arrays.toString(sweets));

        // --- Combination 1: pick first occurrence of each of the maxTypes types ---
        Set<Integer> seen = new LinkedHashSet<>();
        List<Integer> combo1 = new ArrayList<>();
        for (int sweet : sweets) {
            if (seen.size() < maxTypes && !seen.contains(sweet)) {
                seen.add(sweet);
                combo1.add(sweet);
            }
        }
        System.out.println("\nCombination 1 (first occurrences): " + combo1);

        // --- Combination 2: pick last occurrence of each of the maxTypes types ---
        // Reverse traversal
        Set<Integer> seen2 = new LinkedHashSet<>();
        LinkedList<Integer> combo2 = new LinkedList<>();
        for (int i = sweets.length - 1; i >= 0; i--) {
            if (seen2.size() < maxTypes && !seen2.contains(sweets[i])) {
                seen2.add(sweets[i]);
                combo2.addFirst(sweets[i]); // maintain order
            }
        }
        System.out.println("Combination 2 (last occurrences):  " + combo2);

        // --- Combination 3: pick maxTypes types from the middle of the array ---
        List<Integer> combo3 = new ArrayList<>();
        Set<Integer> seen3 = new LinkedHashSet<>();
        int mid = n / 2;
        // spiral outward from middle
        for (int offset = 0; offset < n && seen3.size() < maxTypes; offset++) {
            int[] indices = {mid - offset, mid + offset};
            for (int idx : indices) {
                if (idx >= 0 && idx < n && seen3.size() < maxTypes) {
                    if (!seen3.contains(sweets[idx])) {
                        seen3.add(sweets[idx]);
                        combo3.add(sweets[idx]);
                    }
                }
            }
        }
        System.out.println("Combination 3 (from middle outward): " + combo3);

        System.out.println("\nAll combinations respect: size <= " + limit +
                           " sweets, " + maxTypes + " distinct types.");
    }
}
