//-----------------------------------------------------------------------------
// QueueTest.java
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 3-3-2018
// pa4
// Test Queue ADT.
//-----------------------------------------------------------------------------

public class QueueTest {
	public static void main (String[] args) {
		Queue A = new Queue();

		System.out.println(A.isEmpty());
		A.enqueue((int)1);
		A.enqueue((int)2);
		A.enqueue((int)3);
		A.enqueue((int)4);
		A.enqueue((int)5);
		A.enqueue((int)6);
		System.out.println(A.isEmpty());
		System.out.println("Length A: " + A.length());
		System.out.println(A);

		A.dequeue();
		A.dequeue();
		System.out.println("Length A: " + A.length());
		A.dequeue();
		A.dequeue();
		System.out.println("Peek A: " + A.peek());

		A.dequeueAll();
		System.out.println(A.isEmpty());
		System.out.println("Length A: " + A.length());

		try {
			System.out.println(A.dequeue());
		} catch(QueueEmptyException e) {
			System.out.println("Caught Exception " + e);
			System.out.println("Continuing without interuption");
		}

		Queue B = new Queue();

		System.out.println(B.isEmpty());
		B.enqueue((double)1.1);
		B.enqueue((double)2.2);
		B.enqueue((double)3.3);
		B.enqueue((double)4.4);
		B.enqueue((double)5.5);
		B.enqueue((double)6.6);
		System.out.println(B.isEmpty());
		System.out.println("Length B: " + B.length());
		System.out.println(B);

		B.dequeue();
		System.out.println("Length B: " + B.length());
		B.dequeue();
		B.dequeue();
		System.out.println("Peek B: " + B.peek());

		B.dequeueAll();
		System.out.println(B.isEmpty());
		System.out.println("Length B: " + B.length());

		try {
			System.out.println(B.peek());
		} catch(QueueEmptyException e) {
			System.out.println("Caught Exception " + e);
			System.out.println("Continuing without interuption");
		}
	}
}