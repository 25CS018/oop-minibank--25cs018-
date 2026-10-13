
import java.io.IOException;
import java.util.List;


public class LogAnlzr {
    public static void main(String[] args) throws IOException{
        Path dir=Paths.get("logs");
        Files.createDirectories(dir);
        Files.write("a.txt", List<E>.of("INFO start","ERR"), options)
    }
}
