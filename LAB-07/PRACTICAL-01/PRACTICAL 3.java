
import java.lang.annotation.*;
import java.lang.reflect.*;

// Custom Column annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {

    // Stores the column name
    String name();
}

// Student class
class Student {

    // Match this field with StudentName column
    @Column(name = "StudentName")
    private String name;

    // Match this field with Age column
    @Column(name = "Age")
    private int age;

    // Match this field with Email column
    @Column(name = "Email")
    private String email;

    // Display student details
    public void display() {

        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        // Header row containing column names
        String[] headers = {
            "StudentName", "Age", "Email"
        };

        // Data row containing student information
        String[] data = {
            "Riya", "20", "riya@gmail.com"
        };

        // Create Student object
        Student student = new Student();

        // Get all fields of Student class
        Field[] fields =
            student.getClass().getDeclaredFields();

        // Process every field
        for (Field field : fields) {

            // Check whether field has Column annotation
            if (field.isAnnotationPresent(Column.class)) {

                // Get annotation details
                Column column =
                    field.getAnnotation(Column.class);

                // Get required column name
                String columnName = column.name();

                // Find matching column in header
                int index = -1;

                for (int i = 0; i < headers.length; i++) {

                    if (headers[i].equals(columnName)) {
                        index = i;
                        break;
                    }
                }

                // Handle missing column
                if (index == -1) {

                    System.out.println(
                        "Missing column: " + columnName
                    );

                    // Leave the field with its default value
                    continue;
                }

                try {

                    // Allow access to private fields
                    field.setAccessible(true);

                    // Get value from matching data column
                    String value = data[index];

                    // Convert value according to field type
                    if (field.getType() == String.class) {

                        field.set(student, value);

                    } else if (field.getType() == int.class) {

                        field.setInt(student,
                            Integer.parseInt(value));
                    }

                } catch (Exception e) {

                    System.out.println(
                        "Error processing: " + columnName
                    );
                }
            }
        }

        // Display populated student details
        System.out.println("\nStudent Details:");
        student.display();
    }
}
