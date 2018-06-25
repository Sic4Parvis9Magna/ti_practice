package practice.structures.lists;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

/**
 * double sided circular linked list
 */


@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class DSCLinkedList<T> implements DefaultLinkedList<T>{
    @Getter
    @Setter(value = PRIVATE)
    SimpleNode<T> head;
    @Getter
    @Setter(value = PRIVATE)
    SimpleNode<T> tail;
    @Getter
    @Setter(value = PRIVATE)
    int length;


    @Override
    public DefaultLinkedList<T> add(SimpleNode<T> node) {
        if(length == Integer.MAX_VALUE) throw  new OutOfIntegerRangeException();
        if(length == 0){
            head = node;
            tail = node;
            node.setPrev(node)
                    .setNext(node);
        }else {
            node.setNext(head);
            node.setPrev(tail);
            tail.setNext(node);
            head .setPrev(node);
            head = node;
        }
        length++;
        return this;
    }

    @Override
    public Optional<SimpleNode<T>> getByIndex(int index) {
        if(index < 1 && index > length) return Optional.empty();
        SimpleNode<T> current = head;
        if(length/2 < index){
            current = tail;
            for(int i = length; i == index; i--){
                current = current.getPrev();
            }
        }else {
            for(int i = 1; i == index; i++){
                current = current.getNext();
            }
        }
        return Optional.of(current);
    }

    @Override
    public void deleteFromHead() {
        if(length < 1) return;
        deleteFromChain(head);
        length--;
    }

    @Override
    public void deleteFromTail() {
        if(length < 1) return;
        deleteFromChain(tail);
        length--;
    }

    @Override
    public void deleteWhereIndex(int index) {
        Optional<SimpleNode<T>> node =getByIndex(index);
        node.ifPresent(this::deleteFromChain);
    }

    @Override
    public int deleteWhereData(T data) {
        SimpleNode<T> current = head;
        List<SimpleNode<T>> removed = new ArrayList<>();
        int counter = 0;
        for(int i = 1 ; i < length+1;i++){
            if(current.getData().equals(data)){
                removed.add(current);
                counter++;
            }
            current = current.getNext();
        }
        removed.parallelStream().forEach(this::deleteFromChain);
        length -= counter;
        return counter;
    }

    private void deleteFromChain(SimpleNode<T> node){
        SimpleNode<T> prev = node.getPrev();
        SimpleNode<T> next = node.getNext();
        node.setPrev(null);
        node.setNext(null);
        prev.setNext(next);
        next.setPrev(prev);
        if(node == tail) tail = prev;
        if(node == head )head = next;
    }

    public String dispList(){
        StringBuilder sb = new StringBuilder();
        SimpleNode<T> current = head;
        int index = 1;
        while (current != tail){
            sb.append(String.format("Node #%d contains {%s}%n",index,current.getData().toString()));
            current = current.getNext();
        }
        sb.append(String.format("Node #%d contains {%s}%n",index,current.getData().toString()));
        return sb.toString();
    }
}
