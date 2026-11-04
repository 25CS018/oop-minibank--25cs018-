// Import Arrays to create a list easily
import java.util.Arrays;
// Import HashSet to store unique elements
import java.util.HashSet;
// Import LinkedHashSet to maintain insertion order
import java.util.LinkedHashSet;
// Import List and Set interfaces
import java.util.List;
import java.util.Set;
// Main class for online Java compiler
public class Main {
    public static void main(String[] args) {
        // Create a list of visitor login IDs
        // Some visitor IDs are repeated
        List<String> logins = Arrays.asList(
            "a", "b", "c", "a", "c", "d", "e"
        );
        // Create HashSet from the login list
        // HashSet automatically removes duplicate elements
        // It does not maintain insertion order
        Set<String> unique = new HashSet<>(logins);
        // Create LinkedHashSet from the login list
        // It removes duplicates and maintains insertion order
        Set<String> order = new LinkedHashSet<>(logins);
        // Display the total number of unique visitors
        System.out.println("Unique users: " + unique.size());
        // Display heading for the first three distinct visitors
        System.out.println("First three distinct visitors:");
        // Variable to count visitors
        int n = 0;
        // Traverse visitors in their original insertion order
        for (String u : order) {
            // Stop after printing the first three visitors
            if (n++ == 3) {
                break;
            }
            // Print the visitor ID
            System.out.println(u);
        }
        // Print an empty line
        System.out.println();
    }
}
