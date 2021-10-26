import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class App {
    static Map<String, Integer> variables = new HashMap<String, Integer>();
    Stack<String> whileLoopConStack = new Stack<String>();

    public static void main(String[] args) throws Exception {
        // Main function: extracts code from txt, splits into lines, parses lines,
        // executes parsed lines
        String content = extracted();
        String[] lines = content.split(";");
        String[][] code = parse(lines);
        execute(code);
    }

    private static String extracted() throws IOException {
        // Reads lines from txt and removes \n from every line
        String content = new String(Files.readAllBytes(Paths.get("barebonesCode.txt")));
        content = content.replaceAll("^\s*-", "").replace("\r", "").replace("\n", "");

        System.out.println("roiejasopijseropij");
        System.out.println(content);
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

    private static void execute(String[][] code) {
        for (int i = 0; i < code.length; i++) {
            String opcode = code[i][0];
            String operand = code[i][1];
            ArrayList<String> cars = new ArrayList<String>();

            switch (opcode) {
            case "clear":
                variables.put(operand, 0);

                break;
            case "incr":
                try {
                    variables.replace(operand, variables.get(operand) + 1);
                } catch (Exception e) {
                    System.err.println(String.format(
                            "Error occurred on line %s, most likely due to incrementing before variable declaration",
                            i + 1));
                }

                break;
            case "decr":
                try {
                    variables.replace(operand, variables.get(operand) - 1);
                } catch (Exception e) {
                    System.err.println(String.format(
                            "Error occurred on line %s, most likely due to decrementing before variable declaration",
                            i + 1));
                }

                break;
            case "while":
                try {

                } catch (Exception e) {
                    System.err.println(e);
                }

            default:
                break;
            }
            System.out.println(variables.toString());
        }
    }
}
