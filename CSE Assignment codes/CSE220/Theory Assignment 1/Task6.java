// Task 6
public class Task6
{
  public static void main(String [] args)
  {
    Node head1 = new Node(null, null);
    Node head2 = new Node(null, null);
    
    int [] arr1 = {9,2,1};
    int [] arr2 = {5,9,9,9};
    
    Node tail1 = head1;
    for(int i = 0; i<arr1.length; i++)
    {
      Node newNode = new Node(arr1[i], null);
      tail1.next = newNode;
      tail1 = tail1.next;
    }
    
    Node tail2 = head2;
    for(int i = 0; i<arr2.length; i++)
    {
      Node newNode = new Node(arr2[i], null);
      tail2.next = newNode;
      tail2 = tail2.next;
    }
    
    Node addition = new Node(null, null);
    addition.next = additionList(head1, head2);
    for(Node i = addition.next; i != null; i = i.next)
    {
      System.out.print(i.element+" ");
    }
    System.out.println();
  }
  
  public static Node additionList(Node head1, Node head2)
  {
    head1 = reverse(head1.next);
    head2 = reverse(head2.next);
    
    Node head = null;
    Node tail = head;
    int carry = 0;
    
    while(head1 != null || head2 != null)
    {
      if(head1 != null && head2 != null)
      {
        int val = ((Integer)head1.element + (Integer)head2.element + carry) % 10;
        carry = ((Integer)head1.element + (Integer)head2.element + carry) / 10;
        Node newNode = new Node(val, null);
        
        if(head == null)
        {
          head = newNode;
          tail = head;
        }
        else
        {
          tail.next = newNode;
          tail = newNode;
        }
        
        head1 = head1.next;
        head2 = head2.next;
      }
      
      else if(head1 == null)
      {
        int val = ((Integer)head2.element + carry) % 10;
        carry = ((Integer)head2.element + carry) / 10;
        Node newNode = new Node(val, null);
        
        if(head == null)
        {
          head = newNode;
          tail = head;
        }
        else
        {
          tail.next = newNode;
          tail = newNode;
        }
        
        head2 = head2.next;
      }
      
      else if(head2 == null)
      {
        int val = ((Integer)head1.element + carry) % 10;
        carry = ((Integer)head1.element + carry) / 10;
        Node newNode = new Node(val, null);
        
        if(head == null)
        {
          head = newNode;
          tail = head;
        }
        else
        {
          tail.next = newNode;
          tail = newNode;
        }
        
        head1 = head1.next;
      }
    }
    
    if(carry > 0)
    {
      Node newNode = new Node(carry, null);
      tail.next = newNode;
      tail = newNode;
    }
    
    return reverse(head);
  }
  
  public static Node reverse(Node head)
  {
    Node newHead = null;
    Node n = head;
    while(n != null)
    {
      Node nextNode = n.next;
      n.next = newHead;
      newHead = n;
      n = nextNode;
    }
    
    return newHead;
  }
}

class Node
{
  Object element;
  Node next;
  
  public Node(Object e, Node n)
  {
    element = e;
    next = n;
  }
}