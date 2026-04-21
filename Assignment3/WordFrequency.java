// 2. Extract the words and their frequencies from a text file. Then store them as key value 
// pairs in a TreeMap. Sort them in descending order using Comparator. Now, display the 
// greatest and the least key value pairs from the collection.
// Sajjad Ahmed Shaaz, 002410501093
import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        // Step 1: Read file and count frequencies into a regular map first
        Map<String, Integer> freqCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        freqCount.put(word, freqCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: input.txt not found.");
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        if (freqCount.isEmpty()) {
            System.out.println("No words found in file.");
            return;
        }

        // Step 2: Store in TreeMap (natural ascending key order by default)
        TreeMap<String, Integer> treeMap = new TreeMap<>(freqCount);
        System.out.println("TreeMap (natural key order, ascending):");
        treeMap.forEach((k, v) -> System.out.println("  " + k + " -> " + v));

        // Step 3: Sort descending by frequency using Comparator (on a List)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(treeMap.entrySet());
        Comparator<Map.Entry<String, Integer>> descFreq = (a, b) -> {
            int cmp = b.getValue() - a.getValue(); // descending frequency
            return cmp != 0 ? cmp : a.getKey().compareTo(b.getKey()); // tie-break alphabetically
        };
        sortedList.sort(descFreq);

        System.out.println("\nSorted by frequency (descending):");
        sortedList.forEach(e -> System.out.println("  " + e.getKey() + " -> " + e.getValue()));

        // Step 4: Greatest and least by FREQUENCY
        System.out.println("\n--- By Frequency ---");
        System.out.println("Greatest (highest freq): " + sortedList.get(0));
        System.out.println("Least    (lowest freq):  " + sortedList.get(sortedList.size() - 1));

        // Step 5: Greatest and least by KEY (TreeMap's native feature)
        System.out.println("\n--- By Key (TreeMap native) ---");
        System.out.println("Greatest key: " + treeMap.lastKey() + " -> " + treeMap.lastEntry().getValue());
        System.out.println("Least key:    " + treeMap.firstKey() + " -> " + treeMap.firstEntry().getValue());
    }
}
