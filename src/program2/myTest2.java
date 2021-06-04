package program2;

public class myTest2 {
    public static void main(String[] args) {
        Stack st1 = Stack.of('h', 'e', 'l', 'l', 'o');
        System.out.println("greeting stack: " + st1);
        Stack st2 = Stack.of();
        System.out.println("empty stack: " + st2);

        /*
        Put your testing code here.
        Test each method.
         */
        System.out.println(st1.peek());
        System.out.println(st1.pop() + " was removed from the stack : "+ st1);
        System.out.println(st1.size());
        st1.push('p');
        System.out.println(st1);
        System.out.println("Stack 2 is empty: " + st2.isEmpty());
        System.out.println("Stack 1 is empty: " + st1.isEmpty());
    }
}
