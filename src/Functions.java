import java.util.ArrayList;

public class Functions {
    public static final int PRINT_ALL = 0;
    public static final int PRINT_ALL_AS_INTEGERS = 1;
    public static final int PUSH_RANDOM_NUMBER = 2;
    public static final int PUSH_RANDOM_NUMBER_WITH_UPPER_BOUND = 3;
    public static final int PUSH_RANDOM_NUMBER_WITH_LOWER_BOUND = 4;
    public static final int PUSH_RANDOM_NUMBER_WITH_BOTH_BOUNDS = 5;
    public static final int PRINT_WITH_LENGTH = 6;
    public static final int PRINT_AS_INTEGER_WITH_LENGTH = 7;
    public static final int SUM_ALL = 8;
    public static final int CALCULATE_STACK_SIZE = 9;
    public static final int EXECUTE_SINGLE_CHARACTER = 10;
    public static final int PUSH_TOP_TO_BOTTOM = 11;
    public static final int PUSH_BOTTOM_TO_TOP = 12;
    public static final int STACK_MAX = 13;
    public static final int STACK_MIN = 14;
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
                if (upperBound <= 0) {
                    System.out.println("[INTERPRETER WARNING] UPPER BOUND MUST BE ABOVE 0. CURRENT VALUE: " + upperBound);
                }
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
                if (upper <= lower) {
                    System.out.println("[INTERPRETER WARNING] UPPER BOUND MUST BE ABOVE LOWER BOUND. CURRENT VALUES: " + upper + ", " + lower);
                }
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
            case SUM_ALL:
                int sum = 0;
                while (Stack.hasItem()) {
                    sum += Stack.get();
                    Stack.pop();
                } Stack.put(sum);
                break;
            case CALCULATE_STACK_SIZE:
                Stack.put(Stack.size()); // DOES NOT ACCOUNT FOR NEW INT
                break;
            case EXECUTE_SINGLE_CHARACTER:
                int charID = Stack.get();
                Stack.pop();
                char characterToExecute = (char) charID;
                Evaluator.evaluate(characterToExecute, pointer, map);
                break;
            case PUSH_TOP_TO_BOTTOM:
                int bottom = Stack.get();
                Stack.pop();
                Stack.placeBottom(bottom);
                break;
            case PUSH_BOTTOM_TO_TOP:
                int top = Stack.getBottom();
                Stack.popBottom();
                Stack.put(top);
                break;
            case STACK_MAX:
                int max = 0;
                ArrayList<Integer> stack = Stack.getAll();
                for (int item : stack) {
                    if (item > max) {
                        max = item;
                    }
                }
                Stack.put(max);
                break;
            case STACK_MIN:
                int min = 0;
                ArrayList<Integer> fullStackForMinOperation = Stack.getAll();
                for (int item : fullStackForMinOperation) {
                    if (item > min) {
                        min = item;
                    }
                }
                Stack.put(min);
                break;
            default:
                System.out.println("[INTERPRETER WARNING] FUNCTION ID INVALID: "+f); // DEFAULT PRINT MESSAGE
        }
    }
}
