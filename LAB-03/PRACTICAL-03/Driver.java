public class Driver {
    public static void main(String[] args) {
       // Creates three Fraction objects with different numerator and denominator values
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 7);
        // Prints f2 and checks whether it is equal to f1
        // Fraction(2,4) is simplified to 1/2, so the result is true
        System.out.println("new Fraction(2,4) prints " + f2 + " and equals new Fraction(1,2): " + f2.equals(f1));
        // Prints f3 and checks whether it is equal to f1
        // Fraction(3,7) is not equal to Fraction(1,2), so the result is false
        System.out.println("new Fraction(3,7) prints " + f3 + " and equals new Fraction(1,2): " + f3.equals(f1));
        // Checks whether all three Fraction objects are equal
        // Both conditions must be true to return true
        System.out.println("All fractions are equal: " + (f1.equals(f2) && f2.equals(f3)));
    }
}
