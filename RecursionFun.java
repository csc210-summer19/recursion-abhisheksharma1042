/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Abhishek Sharma
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String temp = "";
		if (n <= 999) {
			temp += n;
			return temp;
		} else {

			temp += intWithCommas(n / 1000) + ",";
			if (n % 1000 < 100) {
				temp += "0";
			}
			if (n % 1000 < 10) {
				temp += "0";
			}
			temp += n % 1000;

		}
		return temp;
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		int temp = -9999999;
		if (index >= len) {
			return;
		} else {
			temp = x[index];
			x[index] = x[len - 1];
			x[len - 1] = temp;
			reverseArray(x, index + 1, len - 1);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int max = -99999;
		int min = 999999;

		max = arrayRangeMax(a, 0);
		min = arrayRangeMin(a, 0);

		return max - min;
	}

	/**
	 * ---------------------------------- Description: helper to find max for
	 * arrayRange
	 * 
	 * @param a -> array of numbers , index
	 *
	 * @return max
	 */
	private int arrayRangeMax(int[] a, int index) {
		if (index < a.length) {
			return Math.max(a[index], arrayRangeMax(a, index + 1));
		} else {
			return a[0];
		}

	}

	/**
	 * Description: helper to find min for arrayRange
	 * 
	 * @param a -> array of numbers , index
	 *
	 * @return min
	 */
	private int arrayRangeMin(int[] a, int index) {
		if (index < a.length) {
			return Math.min(a[index], arrayRangeMin(a, index + 1));
		} else {
			return a[0];
		}

	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index

		return isSorted(nums, 0);
	}

	/**
	 * ---------------------------------- Description: helper for isSorted
	 * 
	 * @param nums -> array of numbers, index
	 *
	 * @return
	 */
	private boolean isSorted(int[] nums, int index) {
		if (nums.length <= 1) {
			return true;
		}
		if (index < nums.length - 1) {
			if (nums[index] <= nums[index + 1]) {
				return isSorted(nums, index + 1);
			} else {
				return false;
			}

		} else {
			return true;
		}

	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {

		return search(strs, search, 0);
	}

	/**
	 * 
	 * ---------------------------------- Description: helper for found
	 * 
	 * @param: strs -> array of strings, search -> string to search
	 *
	 * @return
	 */
	private boolean search(String[] strs, String search, int index) {
		if (strs.length == 0) {
			return true;
		}
		if (index < strs.length) {
			if (strs[index].equals(search)) {
				return true;
			} else {
				return search(strs, search, index + 1);
			}
		} else {
			return false;
		}

	}
}
