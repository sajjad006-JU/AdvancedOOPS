// 2. Extract the words and their frequencies from a text file. Then store them as key value 
// pairs in a TreeMap. Sort them in descending order using Comparator. Now, display the 
// greatest and the least key value pairs from the collection.
// Sajjad Ahmed Shaaz, 002410501093
import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        TreeMap<String, Integer> map = new TreeMap<>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.toLowerCase().split("\\W+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }
        br.close();

        // Sort descending by frequency
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Sorted (desc): " + list);

        System.out.println("Max: " + list.get(0));
        System.out.println("Min: " + list.get(list.size() - 1));
    }
}