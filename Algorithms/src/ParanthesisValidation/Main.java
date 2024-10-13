package ParanthesisValidation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String p1 = "(())";
        String p2 = "(()";
        String p3 = "(()))";
        String p4 = "({[{]}})";
        String p5 = "([{]})";
        String p6 = "((()))";

        //System.out.println(isValid(p1));
        //System.out.println(isValid(p2));
        //System.out.println(isValid(p3));
        //System.out.println(isValid(p4));
        System.out.println(isValid(p6));
    }

    public static boolean isValid(String s) {
        //only count for closing parenthesis.
        Stack<Character> stack = new Stack<>(); //stack won't have any of the same value
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '('); // values represents the opening clauses.
        map.put('}', '{');
        map.put(']', '[');

        for(char c : s.toCharArray()) { // stream through string text
            if(map.containsValue(c)) { // check if there is an opening parenthesis; this 'if' will only work for stacking the opening parenthesis.
                // Bec. once this if executed 'else if' is not going to be executed.
                stack.push(c); // if there is one push it to stack
                //stack has the opening parenthesis by order.
            }
            else if(map.containsKey(c)) { // check if there is closing parenthesis; this 'if' only works for closing parenthesis.
                if(stack.isEmpty() || map.get(c) != stack.pop()) {
                    //if stack is empty that means there is no opening parenthesis
                    //or check map values and if they don't match with stack's last pushed values
                    //return false;
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
