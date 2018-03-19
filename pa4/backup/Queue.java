//-----------------------------------------------------------------------------
// Queue.java
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 3-3-2018
// pa4
// Implements Queue ADT based on the linked list data structure.
//-----------------------------------------------------------------------------

public class Queue implements QueueInterface {

   // private inner Node class
   private class Node {
      Object item;
      Node next;

      Node(Object x){
         this.item = x;
         next = null;
      }
   }

   // Fields for the IntegerList class
   private Node front;     // reference to first Node in List
   private Node back;
   private int numItems;  // number of items in this IntegerList

   // Queue()
   // constructor for the Queue class
   public Queue(){
      front = null;
      back = null;
      numItems = 0;
   }

   // private helper function -------------------------------------------------

 

   // ADT operations ----------------------------------------------------------

   // isEmpty()
   // pre: none
   // post: returns true if this Queue is empty, false otherwise
   public boolean isEmpty(){
      return (numItems==0);
   }

   // length()
   // pre: none
   // post: returns the length of this Queue.
   public int length(){
      return numItems;
   }

   // enqueue()
   // adds newItem to back of this Queue
   // pre: none
   // post: !isEmpty()
   public void enqueue(Object newItem){
      if(front==null){
         front = new Node(newItem);
         back = front;
         numItems++;
      }else{
         back.next = new Node(newItem);
         back = back.next;
         numItems++;
      }
   }

   // dequeue()
   // deletes and returns item from front of this Queue
   // pre: !isEmpty()
   // post: this Queue will have one fewer element
   public Object dequeue() throws QueueEmptyException{
      if(isEmpty()){
         throw new QueueEmptyException("cannot dequeue() empty queue");
      }else{
         Node N = front;
         front = front.next; //diff?
         numItems--;
         return N.item; 
      }
   }


   // peek()
   // pre: !isEmpty()
   // post: returns item at front of Queue
   public Object peek() throws QueueEmptyException{
      if(isEmpty()){
         throw new QueueEmptyException("cannot peek() empty queue");
      }else{
         return front.item;
      }
   }

   // dequeueAll()
   // sets this Queue to the empty state
   // pre: !isEmpty()
   // post: isEmpty()
   public void dequeueAll() throws QueueEmptyException{
      if(isEmpty()){
         throw new QueueEmptyException("cannot dequeueAll() empty queue");
      }else{
         front = null;
         back = null;
         numItems = 0;
      }
   }

   // toString()
   // overrides Object's toString() method
   public String toString(){
      String r = "";
      Node N = front;
      while(N != null){
         r += N.item + " ";
         N = N.next;
      }
      return r;
   }
}