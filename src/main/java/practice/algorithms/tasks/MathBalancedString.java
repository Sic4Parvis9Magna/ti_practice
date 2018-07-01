package practice.algorithms.tasks;

import practice.structures.stacks.DefaultStack;
import practice.structures.stacks.LLBasedStack;

import java.util.Arrays;
import java.util.List;

public interface MathBalancedString {
    List<String> RIGTH_BRACKETS = Arrays.asList(")","}","]");
    List<String> LEFT_BRACKETS =Arrays.asList("(","{","[");

    static int checkBrackets(String content){
        DefaultStack<String> stack = new LLBasedStack<>();
        for (int i = 0; i < content.length() ; i++) {
            String symbol = Character.toString(content.charAt(i));
            if(LEFT_BRACKETS.contains(symbol)){
                stack.push(symbol);
            } else if(RIGTH_BRACKETS.contains(symbol)){
                if(!stack.isEmpty()
                        && isCorrectClosure(stack.peek().get(),symbol)){
                    stack.pop();
                }else {
                    return i;
                }
            }
        }

        if(stack.isEmpty()) return  -1;
        else return content.length();
    }

    static boolean isCorrectBrackets(String text){
        return checkBrackets(text) == -1;
    }

    static boolean isCorrectClosure(String left, String right){
        for (int i =0 ; i < RIGTH_BRACKETS.size();i++) {
            if(left.equals(LEFT_BRACKETS.get(i))
                    && right.equals(RIGTH_BRACKETS.get(i)))
                return true;
        }
        return false;
    }
}
