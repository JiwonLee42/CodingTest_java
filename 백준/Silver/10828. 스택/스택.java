import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stacks = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim());

        Map<String, Runnable> commandMap = new HashMap<>();
        commandMap.put("top", () -> {
            pw.println(stacks.empty() ? -1 : stacks.peek());
        });
        commandMap.put("pop", () -> {
            pw.println(stacks.empty() ? -1 : stacks.pop());
        });
        commandMap.put("size", () -> {
            pw.println(stacks.size());
        });
        commandMap.put("empty", () -> {
            pw.println(stacks.empty() ? 1 : 0);
        });

        for (int i = 0; i < n; i++) {
            String[] s_x = br.readLine().split("\\s", 2);
            String command = s_x[0];

            switch (command) {
                case "top":
                    commandMap.get("top").run();
                    break;
                case "pop":
                    commandMap.get("pop").run();
                    break;
                case "size":
                    commandMap.get("size").run();
                    break;
                case "empty":
                    commandMap.get("empty").run();
                    break;
                case "push":
                    if (s_x.length >= 2) {
                        int x = Integer.parseInt(s_x[1]);
                        stacks.push(x);
                    } else {
                        pw.println("Invalid input: " + s_x[0]);
                    }
                    break;
                default:
                    pw.println("Invalid command: " + command);
            }
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
