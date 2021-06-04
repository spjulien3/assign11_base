package program2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test2 {



    @Test
    public void isEmptyEmptyStack() {
        Stack stack0 = Stack.of();
        assertTrue(stack0.isEmpty());
    }

    @Test
    public void isEmptyNonemptyStack() {
        Stack stack1 = Stack.of('a');
        assertFalse(stack1.isEmpty());
    }

    @Test
    public void pushToEmptyStack() {
        Stack st1 = Stack.of();
        st1.push('a');
        Stack st2 = Stack.of('a');
        assertEquals(st2,st1);
    }

    @Test
    public void pushToNonEmptyStack() {
        Stack st1 = Stack.of('a', 'b');
        st1.push('c');
        Stack st2 = Stack.of('c', 'a', 'b');
        assertEquals(st2, st1);
    }

    @Test(expected = IllegalStateException.class)
    public void popEmptyStack() {
        (Stack.of()).pop();
    }

    @Test
    public void popNonemptyStack() {
        Stack st1 = Stack.of('a', 'b', 'c');
        char x = st1.pop();
        Stack st2 = Stack.of('b', 'c');
        assertEquals('a', x);
        assertEquals(st1, st2);
    }


    @Test(expected = IllegalStateException.class)
    public void peekEmptyStack() {
        (Stack.of()).peek();
    }

    @Test
    public void peekNonemptyStack() {
        Stack st1 = Stack.of('a', 'b', 'c');
        char x = st1.peek();
        Stack st2 = Stack.of('a', 'b', 'c');
        assertEquals('a', x);
        assertEquals(st1, st2);
    }

    @Test
    public void sizeEmptyStack() {
        Stack st1 = Stack.of();
        assertEquals(0, st1.size());
    }

    @Test
    public void sizeNonemptyStack() {
        Stack st1 = Stack.of('a', 'b', 'c', 'd');
        assertEquals(4, st1.size());
    }


}
