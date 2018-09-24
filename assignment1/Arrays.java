package assignment1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Arrays {

	/**
	 * The number of items to test with
	 */
	static final int TEST_SIZE = 225000000;
	
	/**
	 * The number of items to test with
	 */
	static final String TEST_SIZE_FORMATTED = "225,000,000";
	
	/**
	 * The number of times to run each test (for averaging)
	 */
	static final int NUM_TESTS = 10;
	
	/**
	 * A random number generator object
	 */
	static Random rng = new Random();
	
	/**
	 * Main method
	 * 
	 */
	public static void main(String[] args){
		
		//testArrayList();
		runTest("Array", false);
		runTest("ArrayList", false);
		runTest("Vector", false);
		runTest("ArrayList", true);
		runTest("Vector", true);
		
	}
	
	public static void runTest(String type, boolean setInitSize) {
		
		// Declare the lists
		ArrayList<Integer> listArrayList;
		Vector<Integer> listVector;
		Integer[] listArray;
		
		long start, finish, runtime, average = 0;
		
		if (setInitSize) { 
			System.out.println("Testing with " + type + " initialized with a size of " + TEST_SIZE_FORMATTED + "...");
		} else {
			System.out.println("Testing with " + type + "...");
		}
		
		for (int k = 0; k < NUM_TESTS; k++) {
			// Initialize the lists
			if (setInitSize && "ArrayList" == type) {
				listArrayList = new ArrayList<Integer>(TEST_SIZE);
			} else {
				listArrayList = new ArrayList<Integer>();
			}
			if (setInitSize && "Vector" == type) {
				listVector = new Vector<Integer>(TEST_SIZE);
			} else {
				listVector = new Vector<Integer>();
			}
			listArray = new Integer[TEST_SIZE];
			
			start = System.currentTimeMillis();
			// Fill the list with random integers between 0 and 9
			for (int i = 0; i < TEST_SIZE; i++) {
				if ("ArrayList" == type) { listArrayList.add(rng.nextInt(10)); }
				else if ("Vector" == type) { listVector.add(rng.nextInt(10)); }
				else if ("Array" == type) { listArray[i] = rng.nextInt(10); }
			}
			finish = System.currentTimeMillis();
			runtime = finish - start;
			System.out.println("Time to fill with " + TEST_SIZE_FORMATTED + " integers: " + runtime + "ms");
			average += runtime;
		}
		average /= NUM_TESTS;
		
		System.out.println("Average time to fill with " + TEST_SIZE_FORMATTED + " integers over " + NUM_TESTS + " tests: " + average + "ms");
		
	}
	
	public static void testArrayList() {
		
		ArrayList<Integer> list;
		long start, finish, runtime, average = 0;
		
		System.out.println("Testing with an ArrayList...");
		
		for (int k = 0; k < NUM_TESTS; k++) {
			list = new ArrayList<Integer>();
			start = System.currentTimeMillis();
			// Fill the list with random integers between 0 and 9
			for (int i = 0; i < TEST_SIZE; i++) {
				list.add(rng.nextInt(10));
			}
			finish = System.currentTimeMillis();
			runtime = finish - start;
			System.out.println("Time to fill with " + TEST_SIZE_FORMATTED + " integers: " + runtime + "ms");
			average += runtime;
		}
		average /= NUM_TESTS;
		
		System.out.println("Average time to fill with " + TEST_SIZE_FORMATTED + " integers over " + NUM_TESTS + " tests: " + average + "ms");
		
	}
	
	public static void testVector() {
		
		Vector<Integer> list;
		long start, finish, runtime, average = 0;
		
		System.out.println("Testing with a Vector...");
		
		for (int k = 0; k < NUM_TESTS; k++) {
			list = new Vector<Integer>();
			start = System.currentTimeMillis();
			// Fill the list with random integers between 0 and 9
			for (int i = 0; i < TEST_SIZE; i++) {
				list.add(rng.nextInt(10));
			}
			finish = System.currentTimeMillis();
			runtime = finish - start;
			System.out.println("Time to fill with " + TEST_SIZE_FORMATTED + " integers: " + runtime + "ms");
			average += runtime;
		}
		average /= NUM_TESTS;
		
		System.out.println("Average time to fill with " + TEST_SIZE_FORMATTED + " integers over " + NUM_TESTS + " tests: " + average + "ms");
		
	}

	public static void testArray() {
		
		Integer[] list;
		long start, finish, runtime, average = 0;
		
		System.out.println("Testing with an Array...");
		
		for (int k = 0; k < NUM_TESTS; k++) {
			list = new Integer[TEST_SIZE];
			start = System.currentTimeMillis();
			// Fill the list with random integers between 0 and 9
			for (int i = 0; i < TEST_SIZE; i++) {
				list[i] = rng.nextInt(10);
			}
			finish = System.currentTimeMillis();
			runtime = finish - start;
			System.out.println("Time to fill with " + TEST_SIZE_FORMATTED + " integers: " + runtime + "ms");
			average += runtime;
		}
		average /= NUM_TESTS;
		
		System.out.println("Average time to fill with " + TEST_SIZE_FORMATTED + " integers over " + NUM_TESTS + " tests: " + average + "ms");
		
	}

}
