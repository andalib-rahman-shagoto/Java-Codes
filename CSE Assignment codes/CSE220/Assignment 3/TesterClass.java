// Lab Assignment 3
// Andalib Rahman Shagoto
// 20101195
// Section - 11
public class TesterClass
{
  public static void main(String [] args)
  {
    int [] arr = {1,2,3,4,5};
    
    // Task 2 - Part 1
    DoublyList db1 = new DoublyList();
    
    DoublyList db2 = new DoublyList(arr);
    
    // Task 2 - Part 2
    System.out.println("Task 2 - Part 2:");
    db1.showList();
    db2.showList();
    
    // Task 2 - Part 3
    System.out.println("Task 2 - Part 3:");
    Node newElement1 = new Node(1, null, null);
    db2.insert(newElement1);
    
    newElement1 = new Node(6, null, null);
    db2.insert(newElement1);
    db2.showList();
    
    // Task 2 - Part 4
    System.out.println("Task 2 - Part 4:");
    db2 = new DoublyList(arr);
    db2.insert(1,3);
    
    db2.insert(6, 3);
    db2.showList();
    
    // Task 2 - Part 5
    System.out.println("Task 2 - Part 5:");
    db2 = new DoublyList(arr);
    db2.remove(2);
    db2.showList();
    
    // Task 2 - Part 6
    System.out.println("Task 2 - Part 6:");
    db2 = new DoublyList(arr);
    db2.removeKey(1);
    db2.showList();
  }
}

// ------------------- DoublyList Class & Methods -------------------

class DoublyList
{
  // Task 1 - Part ii
  Node head;
  
  // Task 2 - Part 1
  public DoublyList()
  {
    head = new Node(null, null, null);
  }
  
  public DoublyList(int [] arr)
  {
    head = new Node(null, null, null);
    Node tail = head;
    for(int i = 0; i<arr.length; i++)
    {
      Node newNode = new Node(arr[i], null, null);
      tail.next = newNode;
      newNode.prev = tail;
      tail = tail.next;
    }
    
    tail.next = head;
    head.prev = tail;
  }
  
  public DoublyList(DoublyList db)
  {
    head = new Node(null, null, null);
    Node tail = head;
    for(Node i = db.head.next; i!=db.head; i = i.next)
    {
      Node newNode = new Node(i.element, null, null);
      tail.next = newNode;
      newNode.prev = tail;
      tail = tail.next;
    }
    
    tail.next = head;
    head.prev = tail;
  }
  
  // Task 2 - Part 2
  public void showList()
  {
    if(head.next == null)
    {
      System.out.println("Empty List");
      return;
    }
    
    for(Node i = head.next; i!=head; i = i.next)
    {
      System.out.print(i.element+" ");
    }
    System.out.println();
  }
  
  // Task 2 - Part 3
  public void insert(Node newElement)
  {
    for(Node i = head.next; i!=head; i = i.next)
    {
      if(i.element == newElement.element)
      {
        System.out.println("Element already exists");
        return;
      }
    }
    
    Node tail = head.prev;
    tail.next = newElement;
    newElement.next = head;
    newElement.prev = tail;
    head.prev = newElement;
  }
  
  // Task 2 - Part 4
  public void insert(int newElement, int index)
  {
    int count = 0;
    for(Node i = head.next; i!=head; i = i.next)
    {
      if(i.element == (Object)newElement)
      {
        System.out.println("Element already exists");
        return;
      }
      count++;
    }
    
    if(index < 0 || index > count)
    {
      System.out.println("Invalid index");
      return;
    }
    
    count = 0;
    Node newNode = new Node(newElement, null, null);
    for(Node i = head.next; i!=head; i = i.next)
    {
      if(count == index)
      {
        Node prevNode = i.prev;
        newNode.prev = i.prev;
        newNode.next = i;
        prevNode.next = newNode;
        i.prev = newNode;
        return;
      }
      count++;
    }
    
    Node tail = head.prev;
    tail.next = newNode;
    newNode.next = head;
    newNode.prev = tail;
    head.prev = newNode;
  }
  
  // Task 2 - Part 5
  public void remove(int index)
  {
    int count = 0;
    for(Node i = head.next; i!=head; i = i.next)
    {
      count++;
    }
    
    if(index < 0 || index >= count)
    {
      System.out.println("Invalid index");
      return;
    }
    
    count = 0;
    for(Node i = head.next; i!=head; i = i.next)
    {
      if(count == index)
      {
        Node prevNode = i.prev;
        Node nextNode = i.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        i = null;
        return;
      }
      
      count++;
    }
  }
  
  // Task 2 - Part 6
  public int removeKey(int deleteKey)
  {
    for(Node i = head.next; i!=head; i = i.next)
    {
      if((Object)deleteKey == i.element)
      {
        Node prevNode = i.prev;
        Node nextNode = i.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        return deleteKey;
      }
    }
    
    return 0;
  }
}

// ------------------- Node Class -------------------

// Task 1 - Part i
class Node
{
  Object element;
  Node prev;
  Node next;
  
  public Node(Object e, Node p, Node n)
  {
    element = e;
    prev = p;
    next = n;
  }
}