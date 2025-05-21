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
            default:
                System.out.println("[INTERPRETER WARNING] FUNCTION ID INVALID: "+f); // DEFAULT PRINT MESSAGE
        }
    }
}
