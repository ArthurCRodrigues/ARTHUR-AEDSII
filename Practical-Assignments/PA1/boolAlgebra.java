public class SimpleBooleanAlgebraEvaluator {

    public static void main(String[] args) {
        String input = "2 0 1 and(not(A) , not(B))";
        boolean result = evaluateBooleanExpression(input);
        System.out.println("Result: " + result);
    }

    private static boolean evaluateBooleanExpression(String input) {
        String[] parts = input.split(" ", 3);

        // Parse the values of the variables A and B
        boolean A = parts[1].equals("1");
        boolean B = parts[2].equals("1");

        // Parse and evaluate the Boolean expression
        String expression = parts[2].substring(2); // Extract the expression after the variables

        return evaluateExpression(expression, A, B);
    }

    private static boolean evaluateExpression(String expression, boolean A, boolean B) {
        expression = expression.trim();

        if (expression.startsWith("and")) {
            String[] args = getArgs(expression.substring(4, expression.length() - 1));
            return evaluateExpression(args[0], A, B) && evaluateExpression(args[1], A, B);
        } else if (expression.startsWith("or")) {
            String[] args = getArgs(expression.substring(3, expression.length() - 1));
            return evaluateExpression(args[0], A, B) || evaluateExpression(args[1], A, B);
        } else if (expression.startsWith("not")) {
            String arg = expression.substring(4, expression.length() - 1);
            return !evaluateExpression(arg, A, B);
        } else {
            // Base case: variable itself
            switch (expression.trim()) {
                case "A": return A;
                case "B": return B;
                default: return false; // Should not happen if input is well-formed
            }
        }
    }

    private static String[] getArgs(String expression) {
        int commaIndex = findCommaOutsideParentheses(expression);
        String arg1 = expression.substring(0, commaIndex).trim();
        String arg2 = expression.substring(commaIndex + 1).trim();
        return new String[]{arg1, arg2};
    }

    private static int findCommaOutsideParentheses(String expression) {
        int depth = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') depth++;
            if (c == ')') depth--;
            if (c == ',' && depth == 0) return i;
        }
        return -1; // Should not happen if input is well-formed
    }
}
