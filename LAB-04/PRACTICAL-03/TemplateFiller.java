import java.util.regex.*;
// Class to fill placeholders in a template
public class TemplateFiller {
    // Method to replace placeholders with matching values
    public static void fillTemplate(String template, String[] names, String[] values) {
        // Creates a pattern to find words inside curly braces, like {name}
        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        // Creates a matcher to search placeholders in the template
        Matcher matcher = pattern.matcher(template);
        // StringBuilder stores the final result
        StringBuilder result = new StringBuilder();
        // Stores the position of the last matched placeholder
        int last = 0;
        // Finds each placeholder in the template
        while (matcher.find()) {
            // Adds the text before the placeholder
            result.append(template.substring(last, matcher.start()));
            // Gets the placeholder name
            String key = matcher.group(1);
            // Default value if the placeholder is not found
            String value = "[?]";
            // Searches for the placeholder name in the names array
            for (int i = 0; i < names.length; i++) {
                // Checks whether the name matches the placeholder
                if (names[i].equals(key)) 
                    // Gets the matching value from the values array
                    value = values[i];
                    // Stops searching after finding the match
                    break;
                }
            }
            // Adds the replacement value to the result
            result.append(value);
            // Updates the last position after the placeholder
            last = matcher.end();
        }
        // Adds the remaining text after the last placeholder
        result.append(template.substring(last));
        // Prints the final filled template
        System.out.println(result);
    }
}
