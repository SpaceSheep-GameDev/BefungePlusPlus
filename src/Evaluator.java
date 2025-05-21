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
            else if (c == '>') {
                pointer.setDirection(Pointer.RIGHT);
            }
            else if (c == 'v') {
                pointer.setDirection(Pointer.DOWN);
            }
            else if (c == '^') {
                pointer.setDirection(Pointer.UP);
            }
            else if (c == '@') {
                Main.running = false;
            }
            else if (c == ',') {
                System.out.print((char) Stack.get());
                Stack.pop();
            }
            else if (c == '.') {
                System.out.print(Stack.get());
                Stack.pop();
            }
            else if (c == '0') {
                Stack.put(0);
            }
            else if (c == '1') {
                Stack.put(1);
            }
            else if (c == '2') {
                Stack.put(2);
            }
            else if (c == '3') {
                Stack.put(3);
            }
            else if (c == '4') {
                Stack.put(4);
            }
            else if (c == '5') {
                Stack.put(5);
            }
            else if (c == '6') {
                Stack.put(6);
            }
            else if (c == '7') {
                Stack.put(7);
            }
            else if (c == '8') {
                Stack.put(8);
            }
            else if (c == '9') {
                Stack.put(9);
            }
            else if (c == '+') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(i+j);
            }
            else if (c == '-') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(j-i);
            }
            else if (c == '*') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(j*i);
            }
            else if (c == '/') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(j/i);
            }
            else if (c == '%') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(j%i);
            }
            else if (c == '!') {
                int i = Stack.get();
                Stack.pop();
                Stack.put(i == 0 ? 1 : 0);
            }
            else if (c == '?') {
                int dir = random.nextInt(4);
                pointer.setDirection(dir);
            }
            else if (c == '`') {
                int i = Stack.get();
                Stack.pop();
                int j = Stack.get();
                Stack.pop();
                Stack.put(j > i ? 1 : 0);
            }
            else if (c == '#') {
                pointer.move();
                return;
            }
            else if (c == '~') {
                Stack.put(scanner.next().toCharArray()[0]);
            }
            else if (c == '&') {
                Stack.put(scanner.nextInt());
            }
            else if (c == ':') {
                Stack.duplicate();
            }
            else if (c == '$') {
                Stack.pop();
            }
            else if (c == 'g') {
                int y = Stack.get();
                Stack.pop();
                int x = Stack.get();
                Stack.pop();
                Stack.put((int) map[y][x]);
            }
            else if (c == 'p') {
                int y = Stack.get();
                Stack.pop();
                int x = Stack.get();
                Stack.pop();
                int v = Stack.get();
                Stack.pop();
                map[y][x] = (char) v;
            }
            else if (c == '\\') {
                Stack.swap();
            }
            else if (c == '_') {
                int val = Stack.get();
                Stack.pop();
                if (val != 0) {
                    pointer.setDirection(Pointer.LEFT);
                } else {
                    pointer.setDirection(Pointer.RIGHT);
                }
            }
            else if (c == '|') {
                int val = Stack.get();
                Stack.pop();
                if (val != 0) {
                    pointer.setDirection(Pointer.UP);
                } else {
                    pointer.setDirection(Pointer.DOWN);
                }
            }
            else if (c =='r') {
                Stack.flip();
            }
            else if (c == 's') {
                Stack.clear();
            }
            else if (c == 'c') {
                int y = Stack.get();
                Stack.pop();
                int x = Stack.get();
                Stack.pop();
                map[y][x] = ' ';
            }
            else if (c == 'f') {
                int function = Stack.get();
                Stack.pop();
                Functions.evaluate(function, pointer, map);
            }
        } if (c == '"') {
            string = !string;
            return;
        } if (string) {
            Stack.put(c);
        }
    }
}
