public class ChatFilter {
    // Method to search chat logs for a given keyword
    public static void searchLogs(String[] logs, String keyword) {
        // Variable to count the number of matching messages
        int count = 0;
        // StringBuilder stores all matching chat messages
        StringBuilder sb = new StringBuilder();
        // Iterates through each line in the logs array
        for (String line : logs) {
            // Splits each line into maximum 3 parts using spaces
            // Part 1 = Time, Part 2 = User, Part 3 = Message
            String[] parts = line.split(" ", 3);
            // Skips the line if it contains fewer than 3 parts
            if (parts.length < 3) {
                continue;
            }
            // Stores the time from the first part
            String time = parts[0];
            // Stores the username from the second part
            String user = parts[1];
            // Stores the message from the third part
            String message = parts[2];
            // Checks whether the message contains the given keyword
            // Converts both strings to lowercase for case-insensitive searching
            if (message.toLowerCase().contains(keyword.toLowerCase())) {
                // Increases the count when a matching message is found
                count++;
                // Adds the matching message to StringBuilder
                sb.append(time + " " + user + ": " + message + "\n");
            }
        }
        // Prints the total number of matching messages
        System.out.println("Matches: " + count);
        // Prints all matching chat messages
        System.out.println(sb);
    }
}
