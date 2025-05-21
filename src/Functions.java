public class Functions {
    public static final int PRINT_ALL = 0;
    public static final int PRINT_ALL_AS_INTEGERS = 1;
    public static final int PUSH_RANDOM_NUMBER = 2;
    public static final int PUSH_RANDOM_NUMBER_WITH_UPPER_BOUND = 3;
    public static final int PUSH_RANDOM_NUMBER_WITH_LOWER_BOUND = 4;
    public static final int PUSH_RANDOM_NUMBER_WITH_BOTH_BOUNDS = 5;
    public static final int PRINT_WITH_LENGTH = 6;
    public static final int PRINT_AS_INTEGER_WITH_LENGTH = 7;
    public static void evaluate(int f, Pointer pointer, char[][] map) {
        switch(f) {
            case PRINT_ALL:
                while (Stack.hasItem()) {
                    Evaluator.evaluate(',', pointer, map);
                }
                break;
            case PRINT_ALL_AS_INTEGERS:
                while (Stack.hasItem()) {
                    Evaluator.evaluate('.', pointer, map);
                }
                break;
            case PUSH_RANDOM_NUMBER:
                Stack.put(Evaluator.random.nextInt(256));
                break;
            case PUSH_RANDOM_NUMBER_WITH_UPPER_BOUND:
                int upperBound = Stack.get();
                Stack.pop();
                Stack.put(Evaluator.random.nextInt(upperBound));
                break;
            case PUSH_RANDOM_NUMBER_WITH_LOWER_BOUND:
                int lowerBound = Stack.get();
                Stack.pop();
                Stack.put(Evaluator.random.nextInt(lowerBound, 256));
                break;
            case PUSH_RANDOM_NUMBER_WITH_BOTH_BOUNDS:
                int upper = Stack.get();
                Stack.pop();
                int lower = Stack.get();
                Stack.pop();
                Stack.put(Evaluator.random.nextInt(lower, upper));
                break;
            case PRINT_WITH_LENGTH:
                int length = Stack.get();
                Stack.pop();
                for (int i = 0; i < length; i++) {
                    char c = (char) Stack.get();
                    Stack.pop();
                    System.out.print(c);
                }
                break;
            case PRINT_AS_INTEGER_WITH_LENGTH:
                int strLen = Stack.get();
                Stack.pop();
                for (int i = 0; i < strLen; i++) {
                    int gotten = Stack.get();
                    Stack.pop();
                    System.out.print(gotten);
                }
                break;
        }
    }
}
