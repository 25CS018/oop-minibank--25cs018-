import java.util.Scanner;
// Driver class contains the main method
public class Driver {
    public static void main(String[] args) {
        // Creates an array to store chat log messages
        String[] logs = {
            "10:05 alice Hello there",
            "10:10 bob Good morning",
            "WrongLine"
        };
        // Creates a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);
        // Asks the user to enter a keyword to search in chat logs
        System.out.println("Enter keyword:");
        // Reads the keyword entered by the user
        String keyword = sc.nextLine();
        // Calls searchLogs() method of ChatFilter class
        // Searches for the entered keyword in the chat messages
        ChatFilter.searchLogs(logs, keyword);
        // Closes the Scanner object
        sc.close();
    }
}
