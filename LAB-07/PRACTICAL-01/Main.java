// Import annotation classes
import java.lang.annotation.*;
// Import Reflection API to access class fields
import java.lang.reflect.Field;
// Import List and ArrayList
import java.util.*;
// Custom annotation to check whether a field is empty
@Retention(RetentionPolicy.RUNTIME) // Annotation available during runtime
@Target(ElementType.FIELD)          // Annotation can be applied to fields
@interface NotBlank {
}
// Custom annotation to check maximum length
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    // Stores the maximum allowed length
    int value();
}
// Class representing a signup form
class SignupForm {
    // Username must not be empty and maximum length is 20
    @NotBlank
    @MaxLength(20)
    String username;
    // Email must not be empty and maximum length is 50
    @NotBlank
    @MaxLength(50)
    String email;
    // Password must not be empty and maximum length is 10
    @NotBlank
    @MaxLength(10)
    String password;
    // Constructor to initialize form values
    SignupForm(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
// Validator class to check form fields
class Validator {
    // Static method to validate an object
    static List<String> validate(Object obj) {
        // List to store validation error messages
        List<String> errors = new ArrayList<>();
        // Get all fields of the given object
        Field[] fields = obj.getClass().getDeclaredFields();
        // Loop through each field
        for (Field field : fields) {
            // Allows access to private or restricted fields
            field.setAccessible(true);
            try {
                // Get the value of the current field
                Object value = field.get(obj);
                // Check whether @NotBlank annotation is present
                if (field.isAnnotationPresent(NotBlank.class)) {
                    // Check whether the field is null or empty
                    if (value == null ||
                        value.toString().trim().isEmpty()) {
                        // Add error message if field is blank
                        errors.add(
                            field.getName() + " must not be blank"
                        );
                    }
                }
                // Check whether @MaxLength annotation is present
                if (field.isAnnotationPresent(MaxLength.class)) {
                    // Get the MaxLength annotation
                    MaxLength annotation =
                        field.getAnnotation(MaxLength.class);
                    // Get maximum allowed characters
                    int max = annotation.value();
                    // Check whether field exceeds maximum length
                    if (value != null &&
                        value.toString().length() > max) {
                        // Add error message if length is exceeded
                        errors.add(
                            field.getName() +
                            " must have maximum " + max +
                            " characters"
                        );
                    }
                }
            }
            // Handle errors while accessing fields
            catch (IllegalAccessException e) {
                errors.add(
                    "Cannot access field: " + field.getName()
                );
            }
        }
        // Return all validation errors
        return errors;
    }
}
// Main class - program execution starts here
public class Main {
    public static void main(String[] args) {
        // Create SignupForm object with sample input
        SignupForm form = new SignupForm(
            "",
            "verylongemailaddress123456789@example.com",
            "123456789012345"
        );
        // Call validate() method to check all fields
        List<String> errors = Validator.validate(form);
        // Check whether the form has any errors
        if (errors.isEmpty()) {
            // Display if all fields are valid
            System.out.println("Form is valid");
        } else {
            // Display all validation errors
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
