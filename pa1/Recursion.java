//-----------------------------------------------------------------------------
// Recursion.java
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 1-19-2018
// pa1
//-----------------------------------------------------------------------------

class Recursion {
	// reverseArray1()
	// Places the leftmost n elements of X[] into the rightmost n positions in
	// Y[] in reverse order
	static void reverseArray1(int[] X, int n, int[] Y) {
		if (n > 0) {
			Y[X.length - n] = X[n - 1];
			reverseArray1(X, n - 1, Y);
		}
	}

	// reverseArray2()
	// Places the rightmost n elements of X[] into the leftmost n positions in
	// Y[] in reverse order.
	static void reverseArray2(int[] X, int n, int[] Y) {
		if (n > 0) {
			Y[n - 1] = X[X.length - n];
			reverseArray2(X, n - 1, Y);
		}
	}

	// reverseArray3()
	// Reverses the subarray X[i...j].
	static void reverseArray3(int[] X, int i, int j) {
		if (j - i > 0) {
			int temp = X[i];
			X[i] = X[j];
			X[j] = temp;
			reverseArray3(X, i + 1, j - 1);
		}
	}

	// maxArrayIndex()
	// returns the index of the largest value in int array X
	static int maxArrayIndex(int[] X, int p, int r) {
		if (r - p == 0) {
			return p;
		} else {
			int q = (p + r) / 2;
			int maxIndex_L = maxArrayIndex(X, p, q);
			int maxIndex_R = maxArrayIndex(X, q + 1, r);
			if (X[maxIndex_L] > X[maxIndex_R])
				return maxArrayIndex(X, p, q);
			else
				return maxArrayIndex(X, q + 1, r);
		}
	}

	// minArrayIndex()
	// returns the index of the smallest value in int array X
	static int minArrayIndex(int[] X, int p, int r) {
		if (r - p == 0) {
			return p;
		} else {
			int q = (p + r) / 2;
			int minIndex_L = minArrayIndex(X, p, q);
			int minIndex_R = minArrayIndex(X, q + 1, r);
			if (X[minIndex_L] < X[minIndex_R])
				return minArrayIndex(X, p, q);
			else
				return minArrayIndex(X, q + 1, r);
		}
	}

	// main()
	public static void main(String[] args) {
		
		int[] A = { -1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7 };
		int[] B = new int[A.length];
		int[] C = new int[A.length];
		int minIndex = minArrayIndex(A, 0, A.length - 1);
		int maxIndex = maxArrayIndex(A, 0, A.length - 1);

		for (int x : A) System.out.print(x + " ");
		System.out.println();

		System.out.println("minIndex = " + minIndex);
		System.out.println("maxIndex = " + maxIndex);

		reverseArray1(A, A.length, B);
		for (int x : B) System.out.print(x + " ");
		System.out.println();

		reverseArray2(A, A.length, C);
		for (int x : C) System.out.print(x + " ");
		System.out.println();

		reverseArray3(A, 0, A.length - 1);
		for (int x : A) System.out.print(x + " ");
		System.out.println();

	}
}
/* Output:
 -1 2 6 12 9 2 -5 -2 8 5 7
 minIndex = 6
 maxIndex = 3
 7 5 8 -2 -5 2 9 12 6 2 -1
 7 5 8 -2 -5 2 9 12 6 2 -1
 7 5 8 -2 -5 2 9 12 6 2 -1
 */