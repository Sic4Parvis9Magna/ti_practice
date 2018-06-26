package practice.structures.queues;

import lombok.experimental.FieldDefaults;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

@FieldDefaults(level = PRIVATE)
class LLBasedQueueTest {
    DefaultQueue<String> myQueue1;
    DefaultQueue<String> myQueue2;
    final static int ADDED_INTO = 3;
    String str1 = "One";
    String str2 = "Two";
    String str3 = "Three";

    @BeforeEach
    void setUp() {
        myQueue1 = new LLBasedQueue<String>(3);
        myQueue2 = new LLBasedQueue<String>(6);
        myQueue1.offer(str1);
        myQueue1.offer(str2);
        myQueue1.offer(str3);
        myQueue2.offer(str1);
        myQueue2.offer(str2);
        myQueue2.offer(str3);
    }

    @Test
    @DisplayName("Offer to add an item to queue")
    void offer() {
        assertThat(myQueue1.capacity(), is(ADDED_INTO) );
        assertThat(myQueue1.offer("Four"), is(false));
        assertThat(myQueue2.capacity(), is(ADDED_INTO*2) );
        assertThat(myQueue2.offer("Four"), is(true));
    }

    @Test
    @DisplayName("Poll an item from queue")
    void poll() {
        assertThat(myQueue1.peek().isPresent(), is(true) );
        assertThat(myQueue1.peek().get(), is("One") );
        assertThat(myQueue1.poll().get(), is("One") );
        assertThat(myQueue1.peek().isPresent(), is(true) );
        assertThat(myQueue1.peek().get(), is("Two") );

    }

    @Test
    @DisplayName("Peek an item from queue")
    void peek() {
        assertThat(myQueue1.peek().isPresent(), is(true) );
        assertThat(myQueue1.peek().get(), is("One") );

    }

    @Test
    @DisplayName("Get a queue's capacity")
    void capacity() {
        assertThat(myQueue1.capacity(), is(ADDED_INTO) );
        assertThat(myQueue2.capacity(), is(ADDED_INTO*2) );
    }
}