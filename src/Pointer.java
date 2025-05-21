public class Pointer {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    private int direction;
    private int x;
    private int y;
    public Pointer() {
        x = 0;
        y = 0;
        direction = RIGHT;
    }
    public void setDirection(int dir) {
        direction = dir;
    }
    public char get(char[][] field) {
        return field[y][x];
    }
    public void move() {
        if (direction == LEFT) {
            x -= 1;
        }
        else if (direction == RIGHT) {
            x += 1;
        }
        else if (direction == UP) {
            y -= 1;
        }
        else if (direction == DOWN) {
            y += 1;
        }
        if (x < 0) {
            x = 79;
        }
        if (x >= 80) {
            x = 0;
        }
        if (y >= 25) {
            y = 0;
        }
        if (y < 0) {
            y = 24;
        }
    }
}
