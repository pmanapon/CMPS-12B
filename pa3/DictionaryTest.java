//-----------------------------------------------------------------------------
// DictionaryTest.java
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 2-8-2018
// pa3
// Tests Dictionary ADT.
//-----------------------------------------------------------------------------

public class DictionaryTest{

   public static void main(String[] args){
 
      //Test insert()
      Dictionary A = new Dictionary();
      A.insert("1","a");
      A.insert("2","b");
      A.insert("3","c");
      A.insert("4","d");
      //A.insert("2","b");  //throw DuplicateKeyException
      //A.insert("2","c");  //throw DuplicateKeyException
      System.out.println(A);
      
      //Test delete()
      A.delete("2");
      A.delete("4");
      //A.delete("5");  //throwKeyNotFoundException
      A.insert("5","e");
      A.delete("5");
      //A.delete("5");    //throwKeyNotFoundException
      System.out.println(A);

      //Test size()
      Dictionary B = new Dictionary();
      System.out.println(B.size());
      B.insert("1","a");
      B.insert("2","b");
      System.out.println(B.size());
      B.insert("3","c");
      B.delete("1");
      System.out.println(B.size());   
      B.delete("2");
      System.out.println(B.size()); 
      B.delete("3");
      System.out.println(B.size());

      //Test makeEmpty()
      Dictionary C = new Dictionary();
      C.insert("1","a");
      C.insert("2","b");
      C.insert("3","c");
      C.insert("4","d");
      C.insert("5","e");
      System.out.println(C);
      System.out.println(C.size());
      C.makeEmpty();
      System.out.println(C);
      System.out.println(C.size());

      //Test
      Dictionary D = new Dictionary();
      D.insert("1","a");
      D.insert("2","b");
      D.insert("3","c");
      D.insert("4","d");
      String test;
      test = D.lookup("2");
      System.out.println("key=2 "+(test==null?"not found":("value = "+test)));
      test = D.lookup("5");
      System.out.println("key=2 "+(test==null?"not found":("value = "+test)));
      D.insert("5","e");
      D.delete("2");
      test = D.lookup("2");
      System.out.println("key=2 "+(test==null?"not found":("value = "+test)));
      test = D.lookup("5");
      System.out.println("key=2 "+(test==null?"not found":("value = "+test)));

   }
}