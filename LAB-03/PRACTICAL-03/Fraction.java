
import java.util.Objects;
// Fraction class represents a fraction with numerator and denominator
public class Fraction {
    // Private variables to store numerator and denominator
    private int num;
    private int den;
    // Constructor to initialize numerator and denominator
    public Fraction(int num, int den) {
        // Checks whether denominator is zero
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        // Makes denominator positive by changing the sign of numerator
        if (den < 0) {
            num = -num;
            den = -den;
        }
        // Finds the greatest common divisor (GCD) of numerator and denominator
        int gcd = gcd(Math.abs(num), den);
        // Simplifies the fraction by dividing both values by GCD
        this.num = num / gcd;
        this.den = den / gcd;
    }
    // Finds the greatest common divisor using recursion
    private int gcd(int a, int b) {
        // Returns a when b becomes zero; otherwise calls gcd again
        return b == 0 ? a : gcd(b, a % b);
    }
    // Converts the Fraction object into a readable string
    @Override
    public String toString() {
        return num + "/" + den;
    }
    // Compares two Fraction objects to check whether they are equal
    @Override
    public boolean equals(Object o) {
        // Checks if both references point to the same object
        if (this == o) {
            return true;
        }
        // Checks whether the given object belongs to Fraction class
        if (!(o instanceof Fraction)) {
            return false;
        }
        // Typecasts the object into Fraction class
        Fraction f = (Fraction) o;
        // Compares numerator and denominator of both fractions
        return this.num == f.num && this.den == f.den;
    }
    // Generates a hash code based on numerator and denominator
    @Override
    public int hashCode() {
        // Returns hash code using num and den values
        return Objects.hash(num, den);
    }
}
