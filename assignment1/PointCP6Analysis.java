package assignment1;

import java.util.Random;

/**
 * This class analyzes the performance of the PointCP6 interface. 
 * 
 * @author Ivana Erlich ierli042@uottawa.ca (8682437)
 * @author David Dearden pdear036@uottawa.ca (300039831)
 * @version September 2018
 */
public class PointCP6Analysis {

	/**
	 * The number of objects to create and test
	 */
	static final int NUM_OBJECTS = 5000000;

	/**
	 * The <b>main</b> of the application. 
	 * Tests the performance of the PointCP6 interface by timing the creation of objects
	 * and timing the object's methods.
	 * 
	 * @param args command line parameters
	 */
	public static void main(String[] args) {
		
		// Set up
		Random random = new Random();
		PointCP6[] pointsCP2 = new PointCP6[NUM_OBJECTS];
		PointCP6[] pointsCP3 = new PointCP6[NUM_OBJECTS];
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

		// Analysis for instantiation with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i] = new PointCP2(types[i], rhos[i], thetas[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for instantiation with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for instantiation with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i] = new PointCP3(types[i], rhos[i], thetas[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for instantiation with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for getX() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].getX();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getX() with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for getX() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].getX();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getX() with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for getY() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].getY();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getY() with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for getY() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].getY();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getY() with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for getRho() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].getRho();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getRho() with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for getRho() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].getRho();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getRho() with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for getTheta() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].getTheta();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getTheta() with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for getTheta() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].getTheta();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getTheta() with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for convertStorageToPolar() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].convertStorageToPolar();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for convertStorageToPolar() with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for convertStorageToPolar() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].convertStorageToPolar();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for convertStorageToPolar() with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for convertStorageToCartesian() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].convertStorageToCartesian();
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for convertStorageToCartesian() with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for convertStorageToCartesian() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].convertStorageToCartesian();
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for convertStorageToCartesian() with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for getDistance(PointC6 pointB) with concrete class PointCP2
		PointCP6[] pointsCP2other = new PointCP6[NUM_OBJECTS];
		for (int i = 0; i < NUM_OBJECTS; i++) {
			if (random.nextInt(2) == 0) {
				pointsCP2other[i] = new PointCP2('C', random.nextFloat() * NUM_OBJECTS, random.nextFloat() * 360);
			} else {
				pointsCP2other[i] = new PointCP2('P', random.nextFloat() * NUM_OBJECTS, random.nextFloat() * 360);
			}
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].getDistance(pointsCP2other[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for getDistance(PointC6 pointB) with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for getDistance(PointC6 pointB) with concrete class PointCP3
		PointCP6[] pointsCP3other = new PointCP6[NUM_OBJECTS];
		for (int i = 0; i < NUM_OBJECTS; i++) {
			if (random.nextInt(2) == 0) {
				pointsCP3other[i] = new PointCP3('C', random.nextFloat() * NUM_OBJECTS, random.nextFloat() * 360);
			} else {
				pointsCP3other[i] = new PointCP3('P', random.nextFloat() * NUM_OBJECTS, random.nextFloat() * 360);
			}
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].getDistance(pointsCP3other[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for getDistance(PointC6 pointB) with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for rotatePoint(double rotation) with concrete class PointCP2
		float[] degrees2 = new float[NUM_OBJECTS];
		for (int i = 0; i < NUM_OBJECTS; i++) {
			degrees2[i] = random.nextFloat() * NUM_OBJECTS;
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].rotatePoint(degrees2[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for rotatePoint(double rotation) with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for rotatePoint(double rotation) with concrete class PointCP3
		float[] degrees3 = new float[NUM_OBJECTS];
		for (int i = 0; i < NUM_OBJECTS; i++) {
			degrees3[i] = random.nextFloat() * NUM_OBJECTS;
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].rotatePoint(degrees3[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for rotatePoint(double rotation) with concrete class PointCP3: " + (finish - start) + "ms");

		// Analysis for toString() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP2[i].toString();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for toString() with concrete class PointCP2: " + (finish - start) + "ms");

		// Analysis for toString() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_OBJECTS; i++) {
			pointsCP3[i].toString();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for toString() with concrete class PointCP3: " + (finish - start) + "ms\n\n");

	}

}
