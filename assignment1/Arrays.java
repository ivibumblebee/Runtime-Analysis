package assignment1;

import java.util.Random;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;

/**
 * This class tests the performance of constructing large collections 
 * of Integers and iterating over those collections.
 * 
 * @author Ivana Erlich ierli042@uottawa.ca (8682437)
 * @author David Dearden pdear036@uottawa.ca (300039831)
 * @version September 2018
 */
public class Arrays {

	/**
	 * The number of items to test with
	 */
	static final int TEST_SIZE = 225000000;

	/**
	 * The number of items to test with in a human-friendly format
	 */
	static final String TEST_SIZE_FORMATTED = "225,000,000";

	/**
	 * The number of times to run each test (for averaging results)
	 */
	static final int NUM_TESTS = 10;

	/**
	 * A random number generator object
	 */
	static Random rng = new Random();

	/**
	 * The <b>main</b> of the application. 
	 * This method runs the tests for the various collections.
	 */
	public static void main(String[] args){

		constructionTest("Array", false);
		constructionTest("ArrayList", false);
		constructionTest("Vector", false);
		constructionTest("ArrayList", true);
		constructionTest("Vector", true);

		sumTest("Array");
		sumTest("ArrayList");
		sumTest("Vector");

	}

	/**
	 * Tests the construction performance by timing the process and averaging the results. 
	 * 
	 * @param type the type of collection to use (Array, ArrayList, or Vector)
	 * @param setInitSize if true, the collection is created with a an initial size of TEST_SIZE
	 */
	private static void constructionTest(String type, boolean setInitSize) {

		// Initialize some variables
		Integer[] intArray = new Integer[0];
		AbstractCollection<Integer> intCollection = new ArrayList<Integer>();
		long start, finish, runtime, average = 0;

		if (setInitSize && "Array" != type) { 
			System.out.println("Testing " + type + " with an initial capacity of " + TEST_SIZE_FORMATTED + "...");
		} else {
			System.out.println("Testing " + type + " with " + TEST_SIZE_FORMATTED + " integers...");
		}

		for (int k = 0; k < NUM_TESTS; k++) {
			// Re-Initialize the set for the requested type
			if ("ArrayList" == type) { intCollection = new ArrayList<Integer>(setInitSize ? TEST_SIZE : 1); }
			else if ("Vector" == type) { intCollection = new Vector<Integer>(setInitSize ? TEST_SIZE : 1); }
			else if ("Array" == type) { intArray = new Integer[TEST_SIZE]; }

			start = System.currentTimeMillis();
			// Fill the list with random integers between 0 and 9
			for (int i = 0; i < TEST_SIZE; i++) {
				if ("Array" == type) { intArray[i] = rng.nextInt(10); }
				else { intCollection.add(rng.nextInt(10)); }
			}
			finish = System.currentTimeMillis();

			runtime = finish - start;
			System.out.print((k + 1) + ") " + runtime + "ms ");

			// Add the runtime to the average variable so that the average can be calculated after all the tests finish
			average += runtime;
		}
		// Computer the average over all the tests
		average /= NUM_TESTS;

		System.out.println("\nAverage time to fill with " + TEST_SIZE_FORMATTED + " integers over " + NUM_TESTS + " tests: " + average + "ms\n");

	}

	/**
	 * Tests the interation performance by timing the process and averaging the results. 
	 * 
	 * @param type the type of collection to use (Array, ArrayList, or Vector)
	 */
	private static void sumTest(String type) {

		// Initialize some variables
		Integer[] intArray = new Integer[0];
		AbstractCollection<Integer> intCollection = new ArrayList<Integer>();
		long start, finish, runtime, average = 0;
		int sum;
		Iterator<Integer> iterator;

		System.out.println("Testing " + type + " with sum of " + TEST_SIZE_FORMATTED + " integers...");

		for (int k = 0; k < NUM_TESTS; k++) {
			// Re-Initialize the set for the requested type
			if ("ArrayList" == type) { intCollection = new ArrayList<Integer>(TEST_SIZE); }
			else if ("Vector" == type) { intCollection = new Vector<Integer>(TEST_SIZE); }
			else if ("Array" == type) { intArray = new Integer[TEST_SIZE]; }
			sum = 0;

			// Fill the list with random integers between 0 and 9
			for (int i = 0; i < TEST_SIZE; i++) {
				if ("Array" == type) { intArray[i] = rng.nextInt(10); }
				else { intCollection.add(rng.nextInt(10)); }
			}

			// Time the summation
			start = System.currentTimeMillis();
			if ("Array" == type) {
				for (int i = 0; i < TEST_SIZE; i++) { sum += intArray[i]; }
			} else {
				iterator = intCollection.iterator();
				while (iterator.hasNext()) { sum += iterator.next(); }
			}
			finish = System.currentTimeMillis();

			runtime = finish - start;
			System.out.print((k + 1) + ") " + runtime + "ms ");

			// Add the runtime to the average variable so that the average can be calculated after all the tests finish
			average += runtime;
		}
		// Computer the average over all the tests
		average /= NUM_TESTS;

		System.out.println("\nAverage time to sum with " + TEST_SIZE_FORMATTED + " integers over " + NUM_TESTS + " tests: " + average + "ms\n");

	}

}