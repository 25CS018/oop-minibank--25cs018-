class FileResource implements AutoCloseable {

    public FileResource() {
        System.out.println("Resource opened.");
    }

    public void readFile() throws Exception {
        System.out.println("Reading file...");
        throw new Exception("Error while reading file");
    }

    @Override
    public void close() {
        System.out.println("Resource closed.");
    }
}

public class AutoCloseDemo {

    public static void main(String[] args) {

        try (FileResource file = new FileResource()) {

            file.readFile();

        }
        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program completed.");
    }
}