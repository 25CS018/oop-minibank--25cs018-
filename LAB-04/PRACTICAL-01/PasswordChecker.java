import java.util.regex.Pattern;
// PasswordChecker class checks the strength of a password
public class PasswordChecker {
    // Private variable to store the password
    private String passWord;
    // Constructor to initialize the password
    public PasswordChecker(String passWord) {
        this.passWord = passWord;
    }
    // Checks whether the password contains at least one uppercase letter
    public static boolean hashUpperCase(String passWord) {
        // Returns false if password is null
        if (passWord == null) return false;
        // Checks for uppercase letters from A to Z
        return Pattern.matches(".*[A-Z].*", passWord);
    }
    // Checks whether the password contains at least one digit
    public static boolean hashDigit(String passWord) {
        // Returns false if password is null
        if (passWord == null) return false;
        // Checks for digits from 0 to 9
        return Pattern.matches(".*[0-9].*", passWord);
    }
    // Checks whether the password has at least 8 characters
    public static boolean minLength(String passWord) {
        // Returns false if password is null
        if (passWord == null) return false;
        // Checks whether password length is 8 or more
        return passWord.length() >= 8;
    }
    // Checks whether the password contains a special character
    public static boolean hashSpecial(String passWord) {
        // Returns false if password is null
        if (passWord == null) return false;
        // Checks the password using a regular expression
        return Pattern.matches(".^[a-zA-Z0-9]", passWord);
    }
    // Checks the overall strength of the password
    public static boolean strength(String passWord) {
        // Variable to count how many password conditions are passed
        int passes = 0;
        // Increases count if password has minimum 8 characters
        if (minLength(passWord)) passes++;
        // Increases count if password contains a digit
        if (hashDigit(passWord)) passes++;
        // Increases count if password contains an uppercase letter
        if (hashUpperCase(passWord)) passes++;
        // Increases count if password contains a special character
        if (hashSpecial(passWord)) passes++;
        // Displays Weak if no conditions are passed
        if (passes == 0)
            System.out.println("Weak");
        // Displays Medium if 2 or 3 conditions are passed
        else if (passes > 1 && passes < 4)
            System.out.println("Medium");
        // Displays Strong in other cases
        else
            System.out.println("Strong");
        // Returns true only if all 4 conditions are passed
        return passes == 4;
    }
}
