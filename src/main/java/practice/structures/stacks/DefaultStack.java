package practice.structures.stacks;

import java.util.Optional;

public interface DefaultStack<T> {

    Optional<T> pop();
    Optional<T> peek();
    DefaultStack<T> push(T item);
    boolean isEmpty();
    int size();

}
