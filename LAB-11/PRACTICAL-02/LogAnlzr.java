
// Import required Java libraries
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
// Main class for online Java compiler
public class Main {
    public static void main(String[] args) throws IOException {
        // Create a path for the logs folder
        Path dir = Paths.get("logs");
        // Create the logs folder if it does not exist
        Files.createDirectories(dir);
        // Create a path for the a.txt file inside logs folder
        Path file = dir.resolve("a.txt");
        // Create a list of log messages
        List<String> messages = Arrays.asList(
            "INFO start",
            "INFO application running",
            "ERR file not found",
            "INFO process completed",
            "ERR connection failed"
        );
        // Write log messages into the file
        // CREATE creates the file if it does not exist
        // TRUNCATE_EXISTING replaces old content
        Files.write(
            file,
            messages,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        );
        // Display successful file creation message
        System.out.println("Log file created successfully.");
        // Read all lines from the log file
        List<String> lines = Files.readAllLines(file);
        // Display all log messages
        System.out.println("\nAll Log Messages:");
        for (String line : lines) {
            System.out.println(line);
        }
        // Display only error messages
        System.out.println("\nError Messages:");
        for (String line : lines) {
            // Check whether the line contains ERR
            if (line.contains("ERR")) {
                System.out.println(line);
            }
        }
        // Display completion message
        System.out.println("\nLog analysis completed.");
    }
}
