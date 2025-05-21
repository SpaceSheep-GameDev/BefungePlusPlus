import java.util.Random;
import java.util.Scanner;

public class Evaluator {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static boolean string = false;
    public static void evaluate(char c, Pointer pointer, char[][] map) {
        if (!string) {
            if (c == '<') {
                pointer.setDirection(Pointer.LEFT);
            }
            if (c == '>') {
                pointer.setDirection(Pointer.RIGHT);
            }
            if (c == 'v') {
                pointer.setDirection(Pointer.DOWN);
            }
            if (c == '^') {
                pointer.setDirection(Pointer.UP);
            }
            if (c == '@') {
                Main.running = false;
            }
            if (c == ',') {
                System.out.print((char) Stack.get());
                Stack.pop();
            }
            if (c == '.') {
                System.out.print(Stack.get());
                Stack.pop();
            }
            if (c == '1') {
                Stack.put(1);
            }
            if (c == '2') {
                Stack.put(2);
            }
            if (c == '3') {
                Stack.put(3);
            }
            if (c == '4') {
                Stack.put(4);
            }
            if (c == '5') {
                Stack.put(5);
            }
            if (c == '6') {
                Stack.put(6);
            }
            if (c == '7') {
                Stack.put(7);
            }
            if (c == '8') {
                Stack.put(8);
            }
            if (c == '9') {
                Stack.put(9);
            }
            if (c == '+') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(i+j);
            }
            if (c == '-') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(i-j);
            }
            if (c == '*') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(i*j);
            }
            if (c == '/') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(i/j);
            }
            if (c == '%') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(i%j);
            }
            if (c == '!') {
                int i = Stack.get();
                Stack.pop();
                Stack.put(i == 0 ? 1 : 0);
            }
            if (c == '?') {
                int dir = random.nextInt(4);
                pointer.setDirection(dir);
            }
            if (c == '`') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(j > i ? 1 : 0);
            }
            if (c == '#') {
                pointer.move();
                return;
            }
            if (c == '~') {
                Stack.put(scanner.next().toCharArray()[0]);
            }
            if (c == '&') {
                Stack.put(scanner.nextInt());
            }
            if (c == ':') {
                Stack.duplicate();
            }
            if (c == '$') {
                Stack.pop();
            }
            if (c == 'g') {
                int y = Stack.get();
                Stack.pop();
                int x = Stack.get();
                Stack.pop();
                Stack.put(map[y][x]);
            }
            if (c == 'p') {
                int y = Stack.get();
                Stack.pop();
                int x = Stack.get();
                Stack.pop();
                int v = Stack.get();
                Stack.pop();
                map[y][x] = (char) v;
            }
            if (c == '\\') {
                Stack.swap();
            }
            if (c == '_') {
                int val = Stack.get();
                Stack.pop();
                if (val != 0) {
                    pointer.setDirection(Pointer.LEFT);
                } else {
                    pointer.setDirection(Pointer.RIGHT);
                }
            }
            if (c == '|') {
                int val = Stack.get();
                Stack.pop();
                if (val != 0) {
                    pointer.setDirection(Pointer.UP);
                } else {
                    pointer.setDirection(Pointer.DOWN);
                }
            }
        } if (c == '"') {
            string = !string;
            return;
        } if (string) {
            Stack.put(c);
        }
    }
}
