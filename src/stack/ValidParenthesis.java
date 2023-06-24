package stack;


import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        //iterating over the string
        for(int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);

            if(currentCharacter == '{') {
                stack.push('}');
            } else if (currentCharacter == '(') {
                stack.push(')');
            } else if (currentCharacter == '[') {
                stack.push(']');
            } else {
                if(stack.empty()) {
                    return false;
                }
                // top element from the stack
                char topCharacter = stack.pop();
                if(topCharacter != currentCharacter) {
                    return false;
                }
            }
        }


        if(stack.empty()) {
            return true;
        }
        return false;
    }
}
