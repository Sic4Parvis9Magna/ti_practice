package practice.structures.lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SimpleNode<T> {
    T data;
    SimpleNode<T> prev;
    SimpleNode<T> next;

    public SimpleNode(T data){
        this.data = data;
    }

}


