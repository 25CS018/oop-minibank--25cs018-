import java.io.*;
// Student class implements Serializable
// Serializable allows objects to be saved into a file
class Student implements Serializable {
    // Unique ID used during serialization and deserialization
    private static final long serialVersionUID = 1L;
    // Student details
    String name;
    int marks;
    // transient means this variable will not be saved in the file
    transient String password;
    // Constructor to initialize student details
    Student(String name, int marks, String password) {
        this.name = name;
        this.marks = marks;
        this.password = password;
    }
    // Converts student details into a readable string
    public String toString() {
        return "name: " + name
                + " marks: " + marks
                + " password: " + password;
    }
}
// Main class required by online Java compilers
public class Main {
    public static void main(String[] args) {
        // Create an array of Student objects
        Student[] list = {
            new Student("riya", 90, "riya"),
            new Student("princee", 120, "princee"),
            new Student("radadiya", 100, "radadiya")
        };
        // File name where student objects will be saved
        String file = "dhruvi.dat";
        // -----------------------------------
        // PART 1: SERIALIZATION (SAVING DATA)
        // -----------------------------------
        try {
            // Create ObjectOutputStream to write objects into a file
            // FileOutputStream creates or opens the file
            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(file));
            // Write the complete Student array into the file
            out.writeObject(list);
            // Close the output stream
            out.close();
            // Display successful saving message
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
           // Display error if saving fails
            e.printStackTrace();
        }
        // Display original student list
        System.out.println("\nOriginal List:");
        for (Student s : list) {
            // Print each student's details
            System.out.println(s);
        }
        // -----------------------------------
        // PART 2: DESERIALIZATION (LOADING DATA)
        // -----------------------------------
        try {
            // Create ObjectInputStream to read objects from the file
            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(file));
            // Read the saved object and convert it into Student array
            Student[] load = (Student[]) in.readObject();
            // Close the input stream
            in.close();
            // Display loaded student objects
            System.out.println("\nLoaded Objects:");
            for (Student s : load) {
                // Print each loaded student's details
                System.out.println(s);
            }
        } catch (IOException | ClassNotFoundException e) {
            // Display error if loading fails
            e.printStackTrace();
        }
    }
}
