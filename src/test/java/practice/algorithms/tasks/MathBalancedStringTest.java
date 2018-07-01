package practice.algorithms.tasks;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class MathBalancedStringTest {

    @Test
    @DisplayName(" Checking the math correctness of using brackets")
    void checkBrackets() {
        String correct = "{abc}68[t86 (bde)]";
        assertThat(MathBalancedString.checkBrackets(correct),is(-1));
        assertThat(MathBalancedString.isCorrectBrackets(correct), is(true));
        String incorrect = "{} 67 ( dff{ 52 )} lol";
        assertThat(MathBalancedString.checkBrackets(incorrect),is(incorrect.indexOf(")")));
        assertThat(MathBalancedString.isCorrectBrackets(incorrect), is(false));
    }

    @Test
    @DisplayName("Checks brackets compatibility")
    void isCorrectClosure() {
        String[] left = {"(","[","{"};
        String[] right = {")","]","}"};
        for (int i = 0; i < left.length; i++){
            assertThat(MathBalancedString.
                    isCorrectClosure(left[i],right[i]), is(true));
            assertThat(MathBalancedString.
                    isCorrectClosure(right[i],left[i]), is(false));
        }

    }
}