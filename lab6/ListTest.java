//-----------------------------------------------------------------------------
// ListTest.java
// Pattawut Manapongpun
// pmanapon
// CMPS-12M
// Date: 2-26-2018
// Tests List ADT.
//-----------------------------------------------------------------------------


public class ListTest{

   public static void main(String[] args){
      List<Integer> A = new List<Integer>();
      List<String> B = new List<String>();
      List<String> C = new List<String>();
      List<List<String>> D = new List<List<String>>();
      int i, j, k;

      A.add(1, 10);
      A.add(2, 20);
      A.add(3, 30);

      B.add(1, "one");
      B.add(2, "two");
      B.add(3, "three");

      C.add(1, "ten");
      C.add(2, "twenty");

      D.add(1, B);
      D.add(2, C);

      try{
         A.add(5, 50);
      }catch(ListIndexOutOfBoundsException e){
         System.out.println("Caught Exception: ");
         System.out.println(e);
         System.out.println("Continuing without interuption");
      }

      System.out.println(A);
      System.out.println(B);
      System.out.println(C);
      System.out.println(D);

      System.out.println("A.equals(A) is "+A.equals(A));
      System.out.println("A.equals(B) is "+A.equals(B));
      System.out.println("A.equals(C) is "+A.equals(C));

      System.out.println(A.size());
      System.out.println(B.size());
      System.out.println(C.size());
      System.out.println(D.size());

      A.remove(1);
      B.remove(2);
      C.remove(2);

      try{
         C.remove(2);
      }catch(ListIndexOutOfBoundsException e){
         System.out.println("Caught Exception: ");
         System.out.println(e);
         System.out.println("Continuing without interuption");
      }

      System.out.println("A.get(2) is "+A.get(2));
      System.out.println("B.get(1) is "+B.get(1));
      System.out.println("C.get(1) is "+C.get(1));

      try{
         System.out.println(A.get(20));
      }catch(ListIndexOutOfBoundsException e){
         System.out.println("Caught Exception: ");
         System.out.println(e);
         System.out.println("Continuing without interuption");
      }

   }
}