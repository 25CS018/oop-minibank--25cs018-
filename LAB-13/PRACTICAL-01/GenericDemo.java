class Box<T> {

    // Stores a value of generic type T
    private T value;

    // Constructor
    Box(T value) {
        this.value = value;
    }

    // Returns the stored value
    public T get() {
        return value;
    }
}

public class Main {

    // Generic method to return the first element
    static <T> T first(T[] arr) {
        return arr[0];
    }

    public static void main(String[] args) {

        // Create a Box object to store a String
        Box<String> nameBox = new Box<>("Riya");

        // Retrieve the stored name
        String name = nameBox.get();

        // Print the name
        System.out.println("My name is " + name);

        // Create an Integer array
        Integer[] numbers = {10, 20, 30};

        // Call the generic first() method
        System.out.println("First number is " + first(numbers));

        // Create a String array
        String[] names = {"Riya", "Bansi", "Aarav"};

        // Call the same generic method with String array
        System.out.println("First name is " + first(names));
    }
}
