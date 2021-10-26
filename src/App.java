import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    static Map<String, Integer> variables = new HashMap<String, Integer>();

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
        content = content.replace("\r", "").replace("\n", "").replaceAll(";\s*", ";");

        System.out.println(content);
        return content;
    }

    public static String[][] parse(String[] lines) {
        String[][] linesSplit = new String[lines.length][1];
        for (int i = 0; i < lines.length; i++) {
            linesSplit[i] = lines[i].split(" ");
        }
        return linesSplit;
    }

    private static void execute(String[][] code) {
        for (int i = 0; i < code.length; i++) {
            String opcode = code[i][0];
            String operand = "";

            if (!opcode.equals("end")) {
                operand = code[i][1];
            }

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

                    Integer endLine = 0;
                    while (variables.get(operand) != 0) {
                        Integer depth = 0;
                        for (int j = i + 1; j < code.length; j++) {
                            if (code[j][0].equals("while")) {
                                depth += 1;
                            } else if (code[j][0].equals("end")) {
                                if (depth == 0) {
                                    endLine = j;

                                } else {
                                    depth -= 1;
                                }
                            }
                        }
                        String[][] newArray = Arrays.copyOfRange(code, i + 1, endLine);
                        execute(newArray);

                    }
                    i = endLine;

                } catch (Exception e) {
                    System.err.println(e);

                }

                break;
            case "end":
                try {

                } catch (Exception e) {
                    System.err.println(e);
                }

            default:
                break;
            }
            System.out.println(variables.toString());
            try {

                if (variables.get("X") == -10) {
                    System.exit(1);
                }
            } catch (Exception e) {

            }
        }
    }
}
