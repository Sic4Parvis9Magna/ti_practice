package practice.structures.lists;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class DSCLinkedListTest {

    DefaultLinkedList<String> myStruct;
    static final int FIRST_ADDED = 3;

    @BeforeEach
    void setUp(){
        SimpleNode<String> node1 = new SimpleNode<>();
        node1.setData("One");
        myStruct = new DSCLinkedList<>();
        SimpleNode<String> node2 = new SimpleNode<>();
        node2.setData("Two");
        SimpleNode<String> node3 = new SimpleNode<>();
        node3.setData("Three");
        myStruct.add(node1)
                .add(node2)
                .add(node3);
    }

    @Test
    @DisplayName("Add new nodes to structure")
    void add() {

        myStruct.add(new SimpleNode<String>().setData("Four"));
        assertThat(myStruct.getHead().getData(), is("Four"));
        myStruct.add(new SimpleNode<String>().setData("Five"));
        assertThat(myStruct.getHead().getData(), is("Five"));
    }

    @Test
    @DisplayName("Seek nodes by index")
    void getByIndex() {
        assertThat(myStruct.getByIndex(0).isPresent(), is(true));
        assertThat(myStruct.getByIndex(0).get().getData(), is("Three"));
        assertThat(myStruct.getByIndex(1).isPresent(), is(true));
        assertThat(myStruct.getByIndex(1).get().getData(), is("Two"));
        assertThat(myStruct.getByIndex(2).isPresent(), is(true));
        assertThat(myStruct.getByIndex(2).get().getData(), is("One"));
    }

    @Test
    @DisplayName("delete node from head")
    void deleteFromHead() {
        assertThat(myStruct.getHead().getData(), is("Three"));
        myStruct.deleteFromHead();
        assertThat(myStruct.getHead().getData(), is("Two"));
    }

    @Test
    @DisplayName("delete node from tail")
    void deleteFromTail() {
        assertThat(myStruct.getTail().getData(), is("One"));
        myStruct.deleteFromTail();
        assertThat(myStruct.getTail().getData(), is("Two"));
    }

    @Test
    @DisplayName("delete node with index")
    void deleteWhereIndex() {
        assertThat(myStruct.getByIndex(1).isPresent(), is(true));
        assertThat(myStruct.getByIndex(1).get().getData(), is("Two"));
        assertThat(myStruct.getByIndex(2).isPresent(), is(true));
        assertThat(myStruct.getByIndex(2).get().getData(), is("One"));
        myStruct.deleteWhereIndex(1);
        assertThat(myStruct.getByIndex(1).isPresent(), is(true));
        assertThat(myStruct.getByIndex(1).get().getData(), is("One"));

    }

    @Test
    @DisplayName("delete node with certain data")
    void deleteWhereData() {
        String data = "One";
        myStruct.add(new SimpleNode<String>().setData(data));
        assertThat(myStruct.getByIndex(2).get().getData(), is("One"));
        assertThat(myStruct.getByIndex(3).get().getData(), is("One"));
        assertThat(myStruct.getLength(),is(FIRST_ADDED+1));
        assertThat(myStruct.deleteWhereData(data),is(2));
        assertThat(myStruct.getLength(),is(FIRST_ADDED-1));

    }

    @Test
    @DisplayName("Get head of List")
    void getHead() {
        assertThat(myStruct.getHead().getData(), is("Three"));
    }

    @Test
    @DisplayName("Get tail of List")
    void getTail() {
        assertThat(myStruct.getTail().getData(), is("One"));
    }

    @Test
    @DisplayName("Get length of List")
    void getLength() {
        assertThat(myStruct.getLength(), is(FIRST_ADDED));
    }
}