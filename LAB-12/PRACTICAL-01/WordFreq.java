import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFreq {
    public static void main(String[] args) {

        // Input sentence
        String text = "hello hy how are you in changa with largest forest hello hy";

        // HashMap stores each word and its frequency (count)
        Map<String, Integer> freq = new HashMap<>();

        // Convert the sentence into lowercase and split it into words
        // \\W+ separates words whenever a non-word character occurs
        for (String w : text.toLowerCase().split("\\W+")) {

            // Check whether the word is not empty
            if (!w.isEmpty()) {

                // Increase the word count by 1
                // If the word is new, its initial count becomes 1
                freq.merge(w, 1, Integer::sum);
            }
        }

        // Convert HashMap entries into an ArrayList for sorting
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(freq.entrySet());

        // Sort words according to their frequency
        list.sort(
            Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)

            // Sort in descending order (highest frequency first)
            .reversed()

            // If frequencies are equal, sort words alphabetically
            .thenComparing(Map.Entry::getKey)
        );

        // Display each word and its frequency
        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + "->" + e.getValue());
        }
    }
}
