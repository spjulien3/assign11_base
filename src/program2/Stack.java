package program2;



import java.util.Objects;

public class Stack {


    // constructor only used internally.
    private Node head;


    private Stack() {}

    // method to create a stack with the given elements
    //  Will take any number of character arguments, the stack
    //      will be initialized to hold those characters.
    //      The first argument will be the top.
    // If the method is called with no arguments, an
    //      empty stack is created.
    // See the code in myTest2 for examples of how to use this method.
    public static Stack of(char ... data) {
        Stack s = new Stack();
        Node p;
        Node q = null;
        for (int i = 0; i < data.length; i++) {
            p = new Node(data[i]);
            if(i > 0)
                q.next = p;
            else
                s.head = p;
            q = p;
        }
        return s;
    }

    /*
            Your code goes in these methods
     */

    /**
     * Push the character 'ch' on top of the stack.
     *
     *
     */
    public void push(char ch) {
        Node newNode = new Node(ch);
        Node tempNode = head;
        head = newNode;
        head.next = tempNode;
    }

    /**
     * Pop the top character on the stack and return it.
     * If the stack is empty, throws an IllegalStateException.
     *
     * @return Element that was on top of the stack.
     */
    public char pop() {
        if (head == null){
            throw new IllegalStateException("Cannot remove first Node from empty list");
        }
        Node tempNode = head;
        head = head.next;

        return tempNode.data;
    }


    /**
     * Return the element on top of the stack without changing the stack.
     * If the stack is empty throws an IllegalStateException.
     *
     * @return Element currently on top of the stack.
     */
    public char peek() {
        if (head == null){
            throw new IllegalStateException("Cannot remove first Node from empty list");
        }
        return head.data;
    }


    /**
     * Returns the number of elements in the stack.
     *
     * @return Number of elements in the stack.
     */
    public int size() {
        if(head==null){
            return 0;
        }
        int size = 0;
        Node current = head;
        while (current.next != null){
            current = current.next;
            size++;
        }
        return size+1;
    }

    /**
     * Returns true if, and only if, the stack is empty.
     *
     * @return true iff  the stack is empty.
     */
    public boolean isEmpty() {
        if (head==null){
            return true;
        }
        return false;
    }



    /*
            End of your code segment
     */

    @Override
    public String toString() {
        String out = "<";
        Node temp;
        temp = head;
        while (temp != null)
        {
            out += temp.data;
            temp = temp.next;
        }
        return out + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack stackChar = (Stack) o;
        return Objects.equals(head, stackChar.head);
    }

    @Override
    public int hashCode() {

        return Objects.hash(head);
    }

    //class to create nodes as objects
    private static class Node
    {
        private char data;  //data field
        private Node next; //link field

        public Node(char item) //constructor method
        {
            data = item;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
//           System.out.println((data == node.data) + "   " + (Objects.equals(next, node.next)));
            return data == node.data &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {

            return Objects.hash(data, next);
        }
    }



}
