//-----------------------------------------------------------------------------
// Search.java
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 1-26-2018
// pa2
// Determines the target word is amongst the words in the input file or not.
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Search {

	// mergeSort()
	// sort sub-array word[p...r]
	static void mergeSort(String[] word, int[] lineNumber, int p, int r) {
		int q;
		if (p < r) {
			q = (p + r) / 2;
			// System.out.println(p+" "+q+" "+r);
			mergeSort(word, lineNumber, p, q);
			mergeSort(word, lineNumber, q + 1, r);
			merge(word, lineNumber, p, q, r);
		}
	}

	// merge()
	// merges sorted sub-arrays word[p..q] and A[q+1..r]
	static void merge(String[] word, int[] lineNumber, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L_index = new int[n1];
		int[] R_index = new int[n2];
		String[] L = new String[n1];
		String[] R = new String[n2];
		
		int i, j, k;
		for (i = 0; i < n1; i++) {
			L[i] = word[p + i];
			L_index[i] = lineNumber[p + i];
		}

		for (j = 0; j < n2; j++) {
			R[j] = word[q + j + 1];
			R_index[j] = lineNumber[q + j + 1];
		}

		i = 0;
		j = 0;
		for (k = p; k <= r; k++) {
			if (i < n1 && j < n2) {
				if (L[i].compareTo(R[j]) < 0) {
					word[k] = L[i];
					lineNumber[k] = L_index[i];
					i++;
				} else {
					word[k] = R[j];
					lineNumber[k] = R_index[j];
					j++;
				}
			} else if (i < n1) {
				word[k] = L[i];
				lineNumber[k] = L_index[i];
				i++;
			} else { // j<n2
				word[k] = R[j];
				lineNumber[k] = R_index[j];
				j++;
			}
		}
	}

	// binarySearch()
	// pre: Array word[p..r] is sorted
	static int binarySearch(String[] word, int[] lineNumber, int p, int r, String target) {
		int q;
		if (p > r) {
			return -1;
		} else {
			q = (p + r) / 2;
			if (target.compareTo(word[q]) == 0) {
				return lineNumber[q];
			} else if (target.compareTo(word[q]) < 0) {
				return binarySearch(word, lineNumber, p, q - 1, target);
			} else { // target > word[q]
				return binarySearch(word, lineNumber, q + 1, r, target);
			}
		}
	}

	// main
	public static void main(String[] args) throws IOException {

		// check number of command line arguments
		if (args.length < 2) {
			System.err.println("Usage: Search file target1 [target2 ..]");
			System.exit(1);
		}

		// count the number of lines in file
		Scanner in = new Scanner(new File(args[0]));
		int n = 0;
		while (in.hasNextLine()) {
			in.nextLine();
			n++;
		}
		in.close();

		Scanner in2 = new Scanner(new File(args[0]));
		String[] S = new String[n];
		int[] lineNumber = new int[n];
		int i = 0;
		while (in2.hasNextLine()) {
			S[i] = in2.nextLine();
			i++;
		}
		
		for (i = 0; i < n; i++) {
			lineNumber[i] = i + 1;
		}
		
		in2.close();

		mergeSort(S, lineNumber, 0, S.length - 1);
		int num_target = args.length - 1;
		int result = -1;
		for (i = 1; i <= num_target; i++) {
			result = binarySearch(S, lineNumber, 0, S.length - 1, args[i]);
			if (result > 0) {
				System.out.println(args[i] + " found on line " + result);
			} else {
				System.out.println(args[i] + " not found");
			}
		}
	}
}