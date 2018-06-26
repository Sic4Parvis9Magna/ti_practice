package practice.structures.stacks;

import lombok.experimental.FieldDefaults;
import practice.structures.lists.OutOfIntegerRangeException;

import java.util.Arrays;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class ArrayBasedStack<T> implements DefaultStack<T> {
    T[] array;
    int size;

    public ArrayBasedStack() {
        this(10);
    }

    public ArrayBasedStack(int initSize) {
//        array = Arrays.copyOf(array,initSize);
        array = (T[])(new Object[initSize]);
    }

    @Override
    public Optional<T> pop() {
        if (size == 0) return Optional.empty();
        Optional<T> result = peek();
        array[size-1] = null;
        size--;
        return result;
    }

    @Override
    public Optional<T> peek() {
        if (size == 0) return Optional.empty();
        return Optional.ofNullable(array[size-1]);
    }

    @Override
    public DefaultStack<T> push(T item) {
        if (size == array.length) array = resize(this.array);
        array[size] = item;
        size++;
        return this;
    }

    private T[] resize(T[] array) {
        int oldSize = array.length;
        double newSize = oldSize * 1.5;
        if (newSize > Integer.MAX_VALUE) throw new OutOfIntegerRangeException();
        return Arrays.copyOf(array, (int) newSize);

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
