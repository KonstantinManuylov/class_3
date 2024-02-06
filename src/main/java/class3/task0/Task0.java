package class3.task0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Перепишите код, воспользовавшись механизмом try-with-resources
 */
public class Task0 {

    public void rwLine(Path pathRead, Path pathWrite) {
        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}