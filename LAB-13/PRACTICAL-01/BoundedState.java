public class BoundedState {
    // Generic method with a bounded type parameter
    // N extends Number means N can only be Number or its subclasses
    // Example: Integer, Double, Float, Long, etc.
    static <N extends Number> double average(N[] values) {
        // Check whether the array is null or empty
        // If yes, return 0.0
        if (values == null || values.length == 0) {
            return 0.0;
        }
        // Variable to store the sum of all numbers
        double sum = 0.0;
        // Visit each element of the array one by one
        for (N value : values) {
            // Convert each number into double and add it to sum
            sum += value.doubleValue();
        }
        // Calculate and return the average
        // Average = Sum / Total number of elements
        return sum / values.length;
    }
    public static void main(String[] args) {
        // Integer array
        Integer[] ints = {1,2,3,4,5,6,7,8,9,10};
        // Double array
        Double[] doubles = {1.0,2.3,4.5,2.2};
        // Long array
        Long[] longs = {1L,100L,23L};
        // Calculate and print the average of Integer values
        System.out.println("Integers avg:" + average(ints));
        // Calculate and print the average of Double values
        System.out.println("Doubles avg:" + average(doubles));
        // Calculate and print the average of Long values
        System.out.println("Longs avg:" + average(longs));
    }
}
