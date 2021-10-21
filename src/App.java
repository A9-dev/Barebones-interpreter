import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws Exception {
        String content = extracted();
        String[] lines = content.split(";");
        String[][] code = parse(lines);
        execute(code);
    }

    private static void execute(String[][] code) {
        for (int i = 0; i < code.length; i++) {
            String opcode = code[i][0];
            String operand = code[i][1];

            switch (opcode) {
            case "clear":
                System.out.println(String.format("clear: %s", operand));

                break;
            case "incr":
                System.out.println(String.format("incr: %s", operand));

                break;
            case "decr":
                System.out.println(String.format("decr: %s", operand));

                break;

            default:
                break;
            }
        }

    }

    private static String extracted() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("barebonesCode.txt")));
        content = content.replace("\n", "").replace("\r", "");
        return content;
    }

    public static String[][] parse(String[] lines) {
        // Creating 2d array for opcode and operand per line
        String[][] linesSplit = new String[lines.length][1];
        for (int i = 0; i < lines.length; i++) {
            System.out.println(String.format("Adding to 2d array: %s", Arrays.toString(lines[i].split(" "))));
            linesSplit[i] = lines[i].split(" ");

        }
        System.out.println(String.format("Final array: %s", Arrays.deepToString(linesSplit)));
        return linesSplit;
    }

}
