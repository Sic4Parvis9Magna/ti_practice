package practice.structures.queues;

import lombok.experimental.FieldDefaults;
import practice.structures.stacks.DefaultStack;
import practice.structures.stacks.LLBasedStack;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class TwoStackBasedQueue<T> implements DefaultQueue<T>{
    DefaultStack<T> input;
    DefaultStack<T> output;
    final int CAPACITY;

    public TwoStackBasedQueue(){
        this(5);
    }

    public TwoStackBasedQueue(int capacity){
        input = new LLBasedStack<>();
        output = new LLBasedStack<>();
        this.CAPACITY = capacity;
    }

    @Override
    public boolean offer(T item) {
      if(input.size() == CAPACITY)  return false;
      input.push(item);
      return true;
    }

    @Override
    public Optional<T> poll() {
        if(output.isEmpty() && input.isEmpty())return Optional.empty();
        if(output.isEmpty() && !input.isEmpty()){
            while (input.size()>0 ){
                input.pop().
                        ifPresent(t -> output.push(t));
            }
            return output.pop();
        }else{

            return output.pop();
        }
    }

    @Override
    public Optional<T> peek() {
        if(output.isEmpty() && input.isEmpty())return Optional.empty();
        if(output.isEmpty() && !input.isEmpty()){
           while (input.size()>0 ){
                input.pop().
                        ifPresent(t -> output.push(t));
            }
            return output.peek();
        }else{
            return output.peek();
        }

    }

    @Override
    public int capacity() {
        return CAPACITY;
    }
}
