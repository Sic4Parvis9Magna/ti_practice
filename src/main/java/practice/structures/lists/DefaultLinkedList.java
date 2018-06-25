package practice.structures.lists;

import java.util.Optional;

public interface DefaultLinkedList<T> {
    DefaultLinkedList<T> add(SimpleNode<T> node);
    SimpleNode<T> getHead();
    SimpleNode<T> getTail();
    int getLength();
    Optional<SimpleNode<T>> getByIndex(int index);
    void deleteFromHead();
    void deleteFromTail();
    void deleteWhereIndex(int index);
    int deleteWhereData(T data);
    String dispList();

}
