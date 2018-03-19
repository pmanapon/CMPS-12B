//-----------------------------------------------------------------------------
// Dictionary.java
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 2-8-2018
// pa3
// Implements Dictionary ADT based on the linked list data structure.
//-----------------------------------------------------------------------------

public class Dictionary implements DictionaryInterface {

   // private inner Node class
   private class Node {
      String key, value;
      Node next;

      Node(String key_input, String val_input){
         this.key = key_input;
         this.value = val_input;
         next = null;
      }
   }

   // Fields for the Dictionary class
   private Node head;     // reference to first Node in List
   private int numItems;  // number of pairs in this Dictionary

   // Dictionary()
   // constructor for the Dictionary class
   public Dictionary(){
      head = null;
      numItems = 0;
   }


   // private helper function -------------------------------------------------

   // find()
   // returns a reference to the Node at position index in this IntegerList
   private Node findKey(String key){
      Node N = head;
      for(int i=1; i<=numItems; i++){
      	 if(N.key.equals(key)){
      	    return N;
      	 }
         N = N.next;
      }
      return null;
   }


   // ADT operations ----------------------------------------------------------

   // isEmpty()
   // pre: none
   // post: returns true if this Dictionary is empty, false otherwise
   public boolean isEmpty(){
      return(numItems == 0);
   }

   // size()
   // pre: none
   // post: returns the number of pairs in this Dictionary
   public int size() {
      return numItems;
   }

   // lookup()
   // pre: none
   // returns value associated key, or null reference if no such key exists
   public String lookup(String key){

      Node N = findKey(key);
      if (N == null){
         return null;
      }else{
      	 return N.value;
      }
   }

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: lookup(key)==null
   public void insert(String key, String value) 
      throws DuplicateKeyException{

      if (lookup(key)!=null){
      	 throw new DuplicateKeyException("cannot insert duplicate keys");
      }else{
         Node N = new Node(key,value);
         N.next = head;
         head = N;
         numItems++;
      }
   }

   // delete()
   // deletes pair with the given key
   // pre: lookup(key)!=null
   public void delete(String key) throws KeyNotFoundException{
      if (lookup(key)==null){
      	 throw new KeyNotFoundException("cannot delete non-existent key");
      }else if (findKey(key)==head){
         Node N = head;
      	 head = head.next;
      	 N.next = null;
      	 numItems--;
      }else{
         Node P = head;
      	 Node N = P.next;
      	 while (N != findKey(key)){
      	    P = P.next;
      	    N = N.next;	
      	 }
      	 P.next = N.next;
      	 N.next = null;
      	 numItems--;
      }
   }

   // makeEmpty()
   // pre: none
   public void makeEmpty(){
      head = null;
      numItems = 0;
   }

   // toString()
   // returns a String representation of this Dictionary
   // overrides Object's toString() method
   // pre: none
   public String toString(){
      Node N = head;
      String out = new String("");
      while(N != null){
         out = N.key + " " + N.value + "\n" + out;	
         N = N.next;
      }
      return out;
   }
}