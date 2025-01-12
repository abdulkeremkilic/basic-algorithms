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
        String p55 = "([{}])";
        String p6 = "((()))";

        System.out.println(isValid(p1));//true
        System.out.println(isValid(p2));//false
        System.out.println(isValid(p3));//false
        System.out.println(isValid(p4));//false
        System.out.println(isValid(p6));//true
        System.out.println(isValid2(p55));//true
    }

    public static boolean isValid(String s) {
        //only count for closing parenthesis.
        Stack<Character> stack = new Stack<>(); //stack won't have any of the same value
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '('); // values represents the opening clauses.
        map.put('}', '{');
        map.put(']', '[');

        for(char c : s.toCharArray()) { // stream through string text char by char
            if(map.containsValue(c)) { // check if there is an opening parenthesis; this 'if' will only work for stacking the opening parenthesis.
                // Bec. once this if executed 'else if' is not going to be executed.
                stack.push(c); // if there is one push it to stack
                //stack has the opening parenthesis by order.
            }
            else if(map.containsKey(c)) { // check if there is closing parenthesis; this 'if' only works for closing parenthesis.
                if(stack.isEmpty() || map.get(c) != stack.pop()) { // we're popping the value even if it's matching or not
                    //stack's last element should be equal to the element in the iteration which are closing brackets.
                    //if stack is empty that means there is no opening parenthesis
                    //or check map values and if they don't match with stack's last pushed values
                    //return false;
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValid2(String s) {
        int i = -1; //starts from -1 to fill stack up from 0
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') //firstly all iterations will go in here and fill the stack up with opening iterations.
                stack[++i] = ch; //stack for openings; fill up the openings first
            else { // after opening iterations are fully finished code starts to go in this else section.
                if (i >= 0 // i equals to the index where the last opening parenthesis left of.
                        // in this section below; we go back şn the stack and check if our openings meet any closing brackets.
                        && ((stack[i] == '(' && ch == ')') //after the openings we only left of with the closings.
                        || (stack[i] == '{' && ch == '}')
                        || (stack[i] == '[' && ch == ']')))
                    i--; // if there is match found with the current 'i'; we decrease 'i' to search for the right value for next parenthesis.
                    //       (  -   [  -  {  -   }   -   ]   -   )
                else
                    return false;
            }
        }
        return i == -1; //if we're able to go back to -1; that means we matched every opening brackets with a closing one.
    }
}
