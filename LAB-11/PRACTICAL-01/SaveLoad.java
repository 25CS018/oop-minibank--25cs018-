import java.io.*;

class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    int marks;
    transient String password;

    Student(String name, int marks, String password) {
        this.name = name;
        this.marks = marks;
        this.password = password;
    }

    public String toString() {
        return "name: " + name + " marks: " + marks + " password: " + password;
    }
}

public class SaveLoad {

    public static void main(String[] args) {

        Student[] list = {
            new Student("dhruvi", 90, "Dhruvi"),
            new Student("princee", 120, "princee"),
            new Student("radadiya", 100, "radadiya")
        };

        String file = "dhruvi.txt";

        try {
            ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream(file));

            out.writeObject(list);
            out.close();

            System.out.println("Save.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nList:");

        for (Student s : list) {
            System.out.println(s);
        }

        try {
            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream(file));

            Student[] load = (Student[]) in.readObject();

            in.close();

            System.out.println("\nLoaded objects:");

            for (Student s : load) {
                System.out.println(s);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}