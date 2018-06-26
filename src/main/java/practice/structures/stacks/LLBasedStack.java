package practice.structures.stacks;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import practice.structures.lists.DSCLinkedList;
import practice.structures.lists.DefaultLinkedList;
import practice.structures.lists.SimpleNode;

import java.util.Optional;



@FieldDefaults(level = AccessLevel.PRIVATE)
public class LLBasedStack<T> implements DefaultStack<T>{
    DefaultLinkedList<T> defaultLinkedList;

    public LLBasedStack(){
        defaultLinkedList = new DSCLinkedList<>();
    }

    @Override
    public Optional<T> pop() {
       Optional<T> result = peek();
       if(result.isPresent() && size()>0) defaultLinkedList.deleteFromHead();
       return result;
    }

    @Override
    public Optional<T> peek() {
        if(isEmpty()) return Optional.empty();
        return Optional.ofNullable(defaultLinkedList.getHead().getData());
    }

    @Override
    public DefaultStack<T> push(T item) {
        defaultLinkedList.add(new SimpleNode<>(item));
        return this;
    }

    @Override
    public boolean isEmpty() {
        return defaultLinkedList.getLength() == 0;
    }

    @Override
    public int size() {
        return defaultLinkedList.getLength();
    }
}
