package program1;

import java.util.Scanner;

public class myTest
{
   public static void main (String[] args)
   {
      LinkedList myList = new LinkedList(); //create a list object
   
      for (int i=1; i <= 5; i++) //add 5 nodes to the list
      {
         myList.addLastNode(i);
      } 

      //print out the list content
      System.out.println("My test list values are:  " + myList);
      myList.addFirstNode(35);
      System.out.println("New list adding element to first index: " + myList);
      myList.removeFirstNode();//removes new element that was added
      myList.addAtIndex(2,500);
      myList.addLastNode(400);
      System.out.println("New list adding element to index 2: " + myList);
      myList.removeLastNode();
      myList.removeAtIndex(2);
      System.out.println("Removing last node and node at index: " + myList);
      //Will print
      /** My test list values are:  1   2   3   4   5
       New list adding element to first index: 35   1   2   3   4   5
       New list adding element to index 2: 1   2   500   3   4   5   400
       Removing last node and node at index: 1   2   3   4   5
       **/




      //Write code to test each completed method in class LinkedList
       
   } 
}
    
