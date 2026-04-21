// 2. Extract the words and their frequencies from a text file. Then store them as key value 
// pairs in a TreeMap. Sort them in descending order using Comparator. Now, display the 
// greatest and the least key value pairs from the collection.
// Sajjad Ahmed Shaaz, 002410501093
import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws Exception {
        TreeMap<String, Integer> map = new TreeMap<>();

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.toLowerCase().split("\\W+");
            for (String word : words) {
                if (!word.isEmpty())
                    map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        br.close();

        System.out.println("TreeMap (alphabetical): " + map);

        // Sort by frequency descending using Comparator
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Sorted by frequency:    " + list);
        System.out.println("Greatest frequency: " + list.get(0));
        System.out.println("Least frequency:    " + list.get(list.size() - 1));

        // TreeMap's native greatest/least by key
        System.out.println("Greatest key: " + map.lastEntry());
        System.out.println("Least key:    " + map.firstEntry());
    }
}
