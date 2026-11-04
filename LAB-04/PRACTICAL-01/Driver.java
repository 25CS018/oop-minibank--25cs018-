public class Driver {
    public static void main(String arg[]) {
        // Creates an array to store different passwords
        String[] pws = {
            "welcome",
            "!@#DHRUVi",
            "ertgh@W"
        };
        // Checks and displays the strength of the first password
        PasswordChecker.strength(pws[0]);
        // Checks and displays the strength of the second password
        PasswordChecker.strength(pws[1]);
        // Checks and displays the strength of the third password
        PasswordChecker.strength(pws[2]);
    }
}
