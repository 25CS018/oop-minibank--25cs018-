// Abstract class representing a general Employee
abstract class Employee {
    // Protected variables to store employee name and ID
    protected String name;
    protected int id;
    // Constructor to initialize employee name and ID
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    // Abstract method to calculate monthly salary
    abstract double monthlySalary();
}
// PartTime class inherits the Employee class
class PartTime extends Employee {
    // Private variables to store working hours and hourly rate
    private double hour;
    private double rate;
    // Constructor to initialize employee details, hours and rate
    public PartTime(String name, int id, double hour, double rate) {
        super(name, id);
        // Calling parent class constructor
        this.hour = hour;
        this.rate = rate;
    }
    // Overriding monthlySalary() to calculate part-time salary
    @Override
    public double monthlySalary() {
        return hour * rate;
    }
}
// Intern class inherits the Employee class
class Intern extends Employee {
    // Private variable to store intern stipend
    private double stipend;
    // Constructor to initialize intern details and stipend
    public Intern(String name, int id, double stipend) {
        super(name, id); // Calling parent class constructor
        this.stipend = stipend;
    }
    // Overriding monthlySalary() to return the stipend
    @Override
    public double monthlySalary() {
        return stipend;
    }
}
// FullTime class inherits the Employee class
class FullTime extends Employee {
    // Private variable to store fixed monthly salary
    private double fixed;
    // Constructor to initialize employee details and fixed salary
    public FullTime(String name, int id, double fixed) {
        super(name, id); 
        // Calling parent class constructor
        this.fixed = fixed;
    }
    // Overriding monthlySalary() to return fixed salary
    @Override
    public double monthlySalary() {
        return fixed;
    }
}
// Main class of the program
public class Payroll {
    // Main method: execution starts from here
    public static void main(String[] args) {
        // Creating an array of Employee objects
        // Storing FullTime, PartTime and Intern objects
        Employee[] e = {
            new FullTime("riya", 10, 10000),
            new PartTime("radadiya", 2, 24, 500),
            new Intern("bam", 3, 5000)
        };
        // Variable to store total payroll amount
        double total = 0;
        // Variable to store individual employee salary
        double salary = 0;
        // Loop through each employee in the array
        for (Employee i : e) {
            // Calculate the monthly salary of current employee
            salary = i.monthlySalary();
            // Add current salary to total payroll
            total += salary;
            // Display employee name, ID and monthly salary
            System.out.println(
                "name:" + i.name +
                " id:" + i.id +
                " salary:" + i.monthlySalary()
            );
            // Check whether the current employee is an Intern
            if (i instanceof Intern) {
                // Display message for intern stipend
                System.out.println(
                    "this is not salary it is only stipend"
                );
            }
        }
        // Display the total payroll amount
        System.out.println("payroll:" + total);
    }
}
