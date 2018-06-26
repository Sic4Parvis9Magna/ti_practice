package practice.structures.queues;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import practice.structures.lists.DSCLinkedList;
import practice.structures.lists.DefaultLinkedList;
import practice.structures.lists.SimpleNode;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LLBasedQueue<T> implements DefaultQueue<T> {
    DefaultLinkedList<T> struct;
    final int CAPACITY;

    public LLBasedQueue() {
        this(10);
    }

    public LLBasedQueue(int capacity) {
        struct = new DSCLinkedList<>();
        this.CAPACITY = capacity;
    }

    @Override
    public boolean offer(T item) {
        if (struct.getLength() == CAPACITY) {
            return false;
        } else {
            struct.add(new SimpleNode<>(item));
            return true;
        }

    }

    @Override
    public Optional<T> poll() {
        Optional<T> result = peek();
        struct.deleteFromTail();
        return result;
    }

    @Override
    public Optional<T> peek() {
        if (struct.getLength() == 0) return Optional.empty();
        return Optional.ofNullable(struct.getTail().getData());

    }

    @Override
    public int capacity() {
        return CAPACITY;
    }
}
