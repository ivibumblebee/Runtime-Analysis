package assignment1;

import java.util.Random;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;

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
	static final int NUM_TESTS = 3;
	
	/**
	 * A random number generator object
	 */
	static Random rng = new Random();
	
	/**
	 * Main method
	 * This method runs the various tests for part 2 of assignment 1 (Arrays)
	 */
	public static void main(String[] args){
		
		
		/*constructionTest("Array", false);
		constructionTest("ArrayList", false);
		constructionTest("Vector", false);
		constructionTest("ArrayList", true);
		constructionTest("Vector", true);*/
		
		sumTestAll();
		
		sumTest("Array");
		sumTest("ArrayList");
		sumTest("Vector");
		
		
	}
	
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
			System.out.print((k + 1) + ") " + runtime + "ms, Sum: " + sum + " ");
			
			// Add the runtime to the average variable so that the average can be calculated after all the tests finish
			average += runtime;
		}
		// Computer the average over all the tests
		average /= NUM_TESTS;
		
		System.out.println("\nAverage time to sum with " + TEST_SIZE_FORMATTED + " integers over " + NUM_TESTS + " tests: " + average + "ms\n");
		
	}
	
	private static void sumTestAll() {
		
		// Initialize some variables
		Integer[] intArray;
		AbstractCollection<Integer> intArrayList, intVector;
		long start, finish, runtime, arrayAvg = 0, arrayListAvg = 0, vectorAvg = 0;
		int sum;
		Iterator<Integer> iterator;
		
		System.out.println("Sum test with " + TEST_SIZE_FORMATTED + " integers...");
		//System.out.println("Testing " + type + " with sum of " + TEST_SIZE_FORMATTED + " integers...");
		
		for (int k = 0; k < NUM_TESTS; k++) {
			// Re-Initialize the set for the requested type
			intArray = new Integer[TEST_SIZE];
			intArrayList = new ArrayList<Integer>(TEST_SIZE);
			intVector = new Vector<Integer>(TEST_SIZE);
			
			// Fill the lists with random integers between 0 and 9
			for (int i = 0; i < TEST_SIZE; i++) {
				intArray[i] = rng.nextInt(10);
				intArrayList.add(intArray[i]);
				intVector.add(intArray[i]);
			}
			
			// Time the summation
			sum = 0;
			start = System.currentTimeMillis();
			for (int i = 0; i < TEST_SIZE; i++) { sum += intArray[i]; }
			finish = System.currentTimeMillis();
			runtime = finish - start;
			arrayAvg += runtime;
			System.out.println("Test " + (k + 1) + ") " + "Array:     " + runtime + "ms,	Sum: " + sum + " ");
			
			sum = 0;
			iterator = intArrayList.iterator();
			start = System.currentTimeMillis();
			while (iterator.hasNext()) { sum += iterator.next(); }
			finish = System.currentTimeMillis();
			runtime = finish - start;
			arrayListAvg += runtime;
			System.out.println("Test " + (k + 1) + ") " + "ArrayList: " + runtime + "ms,	Sum: " + sum + " ");

			sum = 0;
			iterator = intVector.iterator();
			start = System.currentTimeMillis();
			while (iterator.hasNext()) { sum += iterator.next(); }
			finish = System.currentTimeMillis();
			runtime = finish - start;
			vectorAvg += runtime;
			System.out.println("Test " + (k + 1) + ") " + "Vector:    " + runtime + "ms,	Sum: " + sum + " ");
		}
		// Computer the average over all the tests
		arrayAvg /= NUM_TESTS;
		arrayListAvg /= NUM_TESTS;
		vectorAvg /= NUM_TESTS;
		
		System.out.println("Average time to sum with " + TEST_SIZE_FORMATTED + " integers over " + NUM_TESTS + " tests:");
		System.out.println("Array:     " + arrayAvg + "ms");
		System.out.println("ArrayList: " + arrayListAvg + "ms");
		System.out.println("Vector:    " + vectorAvg + "ms");
		
	}
	
}
