import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	
	static Scanner fs;
	
	public static void main(String[] args) {
		fs = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int p = fs.nextInt();
			int q = fs.nextInt();
			boolean invalid = true;
			for (long num = p; num <= q; num++) {
				if (1 <= num && num <= 3) {
					if (num == 1) {
						invalid = false;
						out.print(num + " ");
					}
				} else {
					if (isKaprekar(num)) {
						invalid = false;
						out.print(num + " ");
					}
				}
			}
			if (invalid) {
				out.print("INVALID RANGE");
			}
			out.println();
		}
		fs.close();
		out.close();
	}
	
	static boolean isKaprekar(long x) {
		int numDigits = (int) Math.log10(x) + 1;
		long sq = x * x;
		String str = String.valueOf(sq);
		String firstHalf = str.substring(0, str.length() - numDigits);
		String secondHalf = str.substring(str.length() - numDigits);
		long newFirst = Long.parseLong(firstHalf);
		long newSecond = Long.parseLong(secondHalf);
		return (newFirst + newSecond) == x;
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static int[] readArray(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = fs.nextInt();
		}
		return a;
	}
}
