import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static boolean running = true;
    public static int X_SIZE;
    public static int Y_SIZE;
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        X_SIZE = Integer.parseInt(args[0]);
        Y_SIZE = Integer.parseInt(args[1]);
        for (int i = 2; i < args.length; i++) {
            String s = args[i];
            builder.append(s);
        }
        String path = builder.toString();
        char[][] file = load(path);
        assert file != null;
        Pointer pointer = new Pointer();
        while (running) {
            try {
                Evaluator.evaluate(pointer.get(file), pointer, file);
                pointer.move();
            } catch (RuntimeException e) {
                System.out.println("[INTERPRETER WARNING] SOMETHING UNKNOWN HAS GONE WRONG: "+e.getMessage());
            }
        }
        System.out.println();
        System.out.println("The program has finished execution.");
    }
    public static char[][] load(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            char[][] file = new char[Y_SIZE][X_SIZE];
            String line;
            int num = 0;
            while ((line = reader.readLine()) != null) {
                if (num >= Y_SIZE) {
                    break;
                }
                char[] chars = line.toCharArray();
                for (int i = 0; i < X_SIZE; i++) {
                    if (i >= chars.length) {
                        file[num][i] = ' ';
                        continue;
                    }
                    file[num][i] = chars[i];
                }
                num++;
            }
            return file;
        } catch(Exception e) {
            return null;
        }
    }
    public static int factorial(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}
