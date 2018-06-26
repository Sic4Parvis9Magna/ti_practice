package practice.structures.stacks;

import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;


@FieldDefaults(level = PRIVATE)
class ArrayBasedStackTest {

    DefaultStack<String> stack;
    String str1;
    String str2;
    String str3;
    final static int ADDED_INTO = 3;

    @BeforeEach
    void setUp() {
        stack = new ArrayBasedStack<>(3);
        str1 = "One";
        str2 = "Two";
        str3 = "Three";
        stack.push(str1)
                .push(str2)
                .push(str3);
    }

    @Test
    @DisplayName("Pop a top element of stack")
    void pop() {
        assertThat(stack.size(), is(ADDED_INTO));
        stack.pop();
        assertThat(stack.size(), is(ADDED_INTO - 1));
        stack.pop();
        assertThat(stack.size(), is(ADDED_INTO - 2));
        stack.pop();
        assertThat(stack.isEmpty(), is(true));

    }

    @Test
    @DisplayName("Peek a top element of stack")
    void peek() {
        assertThat(stack.peek().get(), is("Three"));
        stack.pop();
        assertThat(stack.peek().get(), is("Two"));
        stack.pop();
        assertThat(stack.peek().get(), is("One"));
        stack.pop();
        assertThat(stack.peek().isPresent(), is(false));
    }

    @Test
    @DisplayName("Push to the top of stack.")
    void push() {
        assertThat(stack.size(), is(ADDED_INTO));
        stack.push("Four");
        assertThat(stack.size(), is(ADDED_INTO + 1));
        assertThat(stack.peek().get(), is("Four"));
    }

    @Test
    @DisplayName("Is an empty stack ?")
    void isEmpty() {
        assertThat(stack.isEmpty(), is(false));
        stack.pop();
        stack.pop();
        stack.pop();
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    @DisplayName("Check size of stack")
    void size() {
        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.size(), is(ADDED_INTO));
    }
}