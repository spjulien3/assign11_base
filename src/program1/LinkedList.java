package program1;/*
This class define a linked list that stores integer values.
*/

import javax.lang.model.util.ElementScanner7;
import java.util.Objects;

public class LinkedList
{
   private Node head, tail;
   private int size;
  
   //constructor to create a list object with head, tail, and size. 
   public LinkedList()
   {
      head = null;
      tail = null;
      size = 0;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (tail == null) 
         head = tail = new Node(data);//empty list
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to last node
      }
      size++; //increase list size by one
   }

   public int getFirst() {
       if(head == null)
           throw new IllegalStateException("Attempt to get first element from empty list");
       return head.data;
   }
   
   //================= your part to complete ==============
   
   //method add first node
   public void addFirstNode(int data)
   {
       Node tempNode = new Node(data);
       tempNode.next = head;
       head = tempNode;
       size++;
       if (tail==null){
           tail=head;
       }
   }
      
   //method add node at index
   public void addAtIndex(int index, int data)
   {
       if( index < 0 || index >size){
           throw new  IndexOutOfBoundsException("AddAtIndex Index is out of bounds: " + index);
       }
       else {
           if (index == 0){
               addFirstNode(data);
           }
           else if (index == size){
               addLastNode(data);
           }
           else {
               Node newNode = new Node(data);
               Node current = head;
               for (int i = 0; i < index-1 ; i++) {
                   current= current.next;
                   newNode.next = current.next;
                   current.next = newNode;

               }

           }
       }
       size++;
   }
      
   //method remove first node
   public void removeFirstNode()
   {
       if (tail == null){
           throw new IllegalStateException("Cannot remove first Node from empty list");
       }
       head = head.next;

       if (head ==null){
           tail = null;
       }
       size--;

   }
      
   //method remove last node
   public void removeLastNode() {
       if (tail == null) {
           throw new IllegalStateException("Cannot remove last Node from empty list");
       } else {
           if (size == 1) {
               head = null;
               tail = null;
           } else {
               Node current = head;
               for (int i = 0; i < size-2; i++) {
                   current = current.next;
               }
               current.next = null;
               tail = current;
           }
           size--;
       }
   }
      
   //method remove node at index
   public void removeAtIndex(int index) {
       if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException("AddAtIndex Index is out of bounds: " + index);
       }
       else {
           if (index == 0) {
               removeFirstNode();
           } else if (index == size - 1) {
               removeLastNode();
           } else {
               Node previous = head;
               for (int i = 0; i < index - 1; i++) {
                   previous = previous.next;
               }
               Node current = previous.next;
               previous.next = current.next;
               size--;

           }

       }
   }

   //================= end of your part ==============

//   //method to print out the list
//   public void printList()
//   {
//      Node temp;
//      temp = head;
//      while (temp != null)
//      {
//         System.out.print(temp.data + "   ");
//         temp = temp.next;
//      }
//   }

    @Override
    public String toString() {
       String out = "";
        Node temp;
        temp = head;
        while (temp != null)
        {
            out += temp.data + "   ";
            temp = temp.next;
        }
        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList that = (LinkedList) o;
//        System.out.println(size == that.size);
//        System.out.println(Objects.equals(head, that.head));
//        System.out.println(Objects.equals(tail, that.tail));
//        System.out.println();
        return size == that.size &&
                Objects.equals(head, that.head) &&
                Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(head, tail, size);
    }

    //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
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

