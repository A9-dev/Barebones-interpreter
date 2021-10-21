import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("barebonesCode.txt")));
        content = content.replace("\n", "").replace("\r", "");
        String[] lines = content.split(";");
        parse(lines);
    }

    static void parse(String[] lines) {
        String[][] linesSplit = new String[lines.length][1];
        for (int i = 0; i < lines.length; i++) {
            System.out.println(Arrays.toString(lines[i].split(" ")));
            linesSplit[i] = lines[i].split(" ");

        }
        System.out.println(Arrays.deepToString(linesSplit));

    }

}
