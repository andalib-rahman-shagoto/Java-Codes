import java.util.*;
public class StackDemo
{
  public static void main(String[] args)
  {
    
  }
}

// ArrayStack class which will implement
// Or use the features of Stack interface
class ArrayStack implements Stack
{
  Object [] arr;
  int size; // To maintain the size of stack
  
  public ArrayStack() // Constructing the stack
  {
    arr = new Object[5]; // default size of stack is 5
    size = 0; // Initially empty sized stack
  }
  
  public void push(Object elem)
  {
    if(size == arr.length)
    {
      System.out.println("Stack Overflow!");
      return;
    }
    
    arr[size] = elem;
    size++;
  }
  
  public Object pop()
  {
    if(size == 0) // Means empty stack
    {
      System.out.println("Stack Underflow!");
      return null;
    }
    
    Object temp = arr[size-1];
    arr[size-1] = null;
    size--;
    return temp;
  }
  
  public Object peek()
  {
    if(size == 0) // Means empty stack
    {
      System.out.println("Stack Underflow!");
      return null;
    }
    return arr[size-1];
  }
}

// ListStack class which will also implement Staack
class ListStack implements Stack
{
  Node head;
  
  public ListStack()
  {
    head = null;
  }
  
  public void push(Object elem)
  {
    // Creating a node in front
    // Which will point from head
    Node newHead = new Node(elem, head);
    // Changing the old head with the newly added one
    head = newHead;
  }
  
  public Object peek()
  {
    if(head == null)
    {
      System.out.println("Stack Underflow!");
      return null;
    }
    return head.element;
  }
  
  public Object pop()
  {
    if(head == null)
    {
      System.out.println("Stack Underflow!");
      return null;
    }
    Node temp = head;
    head = head.next;
    temp.next = null;
    return temp.element;
  }
}

class Node
{
  Object element;
  Node next;
  
  public Node(Object o, Node n)
  {
    element = o;
    next = n;
  }
}

// An interface or an abstract class,
//whose methods will be overridden through another class
interface Stack
{
  // Some public methods
  public void push(Object e);
  public Object pop();
  public Object peek();
}