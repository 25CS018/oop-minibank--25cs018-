public class Driver {
    public static void main(String[] args) {
        // Creating an array of Point objects
        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(1, 2),
            new Point(5, 6),
            new Point(3, 4),
            new Point(7, 8)
        };
        // Variable to count distinct (unique) points
        int distinctCount = 0;
        // Outer loop checks each point in the array
        for (int i = 0; i < points.length; i++) {
            // Initially assume the point is not repeated
            boolean alreadySeen = false;
            // Inner loop checks previous points for duplicates
            for (int j = 0; j < i; j++) {
                // Check whether the current point matches a previous point
                if (points[i].equals(points[j])) {
                    // If matched, mark it as already seen
                    alreadySeen = true;

                    // Stop checking further
                    break;
                }
            }

            // If the point is not repeated, increase the count
            if (!alreadySeen) {
                distinctCount++;
            }
        }

        // Display the total number of distinct points
        System.out.println("Distinct: " + distinctCount);
    }
}
