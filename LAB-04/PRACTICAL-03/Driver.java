public class Driver {
    public static void main(String[] args) {
        // Stores the template containing placeholders
        String template = "Dear {name}, order {id} ships {date}.";
        // Stores the names of the placeholders
        String[] names = {"name", "id"};
        // Stores the values for the corresponding placeholders
        String[] values = {"Dhruvi", "A07"};
        // Calls the fillTemplate() method to replace placeholders with values
        TemplateFiller.fillTemplate(template, names, values);
    }
}
