import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    static String[] lines;

    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("barebonesCode.txt")));
        System.out.println(content);
        content = content.replace("\n", "").replace("\r", "");
        lines = content.split(";");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
    }
}
