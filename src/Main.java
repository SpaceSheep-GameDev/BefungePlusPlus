import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static boolean running = true;
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String s : args) {
            builder.append(s);
        }
        String path = builder.toString();
        char[][] file = load(path);
        assert file != null;
        Pointer pointer = new Pointer();
        while (running) {
            Evaluator.evaluate(pointer.get(file), pointer, file);
            pointer.move();
        }
        System.out.println("The program has finished execution.");
    }
    public static char[][] load(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            char[][] file = new char[25][80];
            String line;
            int num = 0;
            while ((line = reader.readLine()) != null) {
                if (num >= 25) {
                    break;
                }
                char[] chars = line.toCharArray();
                for (int i = 0; i < 80; i++) {
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
}
