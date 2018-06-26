package practice.structures.queues;

import java.util.Optional;

public interface DefaultQueue<T> {
    boolean offer(T item);
    Optional<T> poll();
    Optional<T> peek();
    int capacity();

}
