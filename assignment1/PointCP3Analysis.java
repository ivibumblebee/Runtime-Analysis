package assignment1;

import java.util.Random;

/**
 * This class analyzes the performance of the PointCP2 class. 
 * 
 * @author Ivana Erlich ierli042@uottawa.ca (8682437)
 * @author David Dearden pdear036@uottawa.ca (300039831)
 * @version September 2018
 */
public class PointCP3Analysis {
	
	/**
	 * The number of objects to create and test
	 */
	static final int NUM_OBJECTS = 5000000;

	/**
	 * The <b>main</b> of the application. 
	 * Tests the performance of the PointCP3 class by timing the creation of PointCP3 objects
	 * and timing the object's methods.
	 * 
	 * @param args command line parameters
	 */
	public static void main(String[] args) {
		
		// Set up
		Random random = new Random();
		PointCP3[] points = new PointCP3[NUM_OBJECTS];
		char[] types = new char[NUM_OBJECTS];
		double[] rhos = new double[NUM_OBJECTS];
		double[] thetas = new double[NUM_OBJECTS];
		long start;
		long finish;
		for (int i = 0; i < NUM_OBJECTS; i++) {
			if (random.nextInt(2) == 0) {
				types[i] = 'C';
			} else {
				types[i] = 'P';
			}
			rhos[i] = random.nextFloat() * NUM_OBJECTS;
			thetas[i] = random.nextFloat() * 360;
		}

		// Analysis for instantiation
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i] = new PointCP3(types[i], rhos[i], thetas[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for instantiation: " + (finish - start) + "ms");

		// Analysis for getX()
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].getX();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getX(): " + (finish - start) + "ms");

		// Analysis for getY()
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].getY();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getY(): " + (finish - start) + "ms");

		// Analysis for getRho()
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].getRho();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getRho(): " + (finish - start) + "ms");

		// Analysis for getTheta()
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].getTheta();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getTheta(): " + (finish - start) + "ms");

		// Analysis for convertStorageToPolar()
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].convertStorageToPolar();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for convertStorageToPolar(): " + (finish - start) + "ms");

		// Analysis for convertStorageToCartesian()
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].convertStorageToCartesian();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for convertStorageToCartesian(): " + (finish - start) + "ms");

		// Analysis for getDistance(PointC6 pointB)
		PointCP3[] points2 = new PointCP3[NUM_OBJECTS];
		for (int i = 0; i < NUM_OBJECTS; i++) {
			if (random.nextInt(2) == 0) {
				points2[i] = new PointCP3('C', random.nextFloat() * NUM_OBJECTS, random.nextFloat() * 360);
			} else {
				points2[i] = new PointCP3('P', random.nextFloat() * NUM_OBJECTS, random.nextFloat() * 360);
			}
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].getDistance(points2[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getDistance(PointC6 pointB): " + (finish - start) + "ms");

		// Analysis for rotatePoint(double rotation)
		float[] degrees = new float[NUM_OBJECTS];
		for (int i = 0; i < NUM_OBJECTS; i++) {
			degrees[i] = random.nextFloat() * NUM_OBJECTS;
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].rotatePoint(degrees[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for rotatePoint(double rotation): " + (finish - start) + "ms");

		// Analysis for toString()
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			points[i].toString();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for toString(): " + (finish - start) + "ms\n\n");

	}

}
