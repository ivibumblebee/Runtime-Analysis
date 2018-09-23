package lab1;

import java.util.Random;

public class PointCP2Analysis {
	public static void main(String[] args) {
		// set up
		Random random = new Random();
		PointCP2[] points = new PointCP2[5000000];
		char[] types = new char[5000000];
		double[] rhos = new double[5000000];
		double[] thetas = new double[5000000];
		long start;
		long finish;
		for (int i = 0; i < 5000000; i++) {
			if (random.nextInt(2) == 0) {
				types[i] = 'C';
			} else {
				types[i] = 'P';
			}
			rhos[i] = random.nextFloat() * 5000000;
			thetas[i] = random.nextFloat() * 360;
		}

		// analysis for instantiation
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i] = new PointCP2(types[i], rhos[i], thetas[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for instantiation: " + (finish - start) + "ms");

		// analysis for getX()
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].getX();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getX(): " + (finish - start) + "ms");

		// analysis for getY()
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].getY();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getY(): " + (finish - start) + "ms");

		// analysis for getRho()
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].getRho();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getRho(): " + (finish - start) + "ms");

		// analysis for getTheta()
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].getTheta();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getTheta(): " + (finish - start) + "ms");

		// analysis for convertStorageToPolar()
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].convertStorageToPolar();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for convertStorageToPolar(): " + (finish - start) + "ms");

		// analysis for convertStorageToCartesian()
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].convertStorageToCartesian();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for convertStorageToCartesian(): " + (finish - start) + "ms");

		// analysis for getDistance(PointC6 pointB)
		PointCP2[] points2 = new PointCP2[5000000];
		for (int i = 0; i < 5000000; i++) {
			if (random.nextInt(2) == 0) {
				points2[i] = new PointCP2('C', random.nextFloat() * 5000000, random.nextFloat() * 360);
			} else {
				points2[i] = new PointCP2('P', random.nextFloat() * 5000000, random.nextFloat() * 360);
			}
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].getDistance(points2[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getDistance(PointC6 pointB): " + (finish - start) + "ms");

		// analysis for rotatePoint(double rotation)
		float[] degrees = new float[5000000];
		for (int i = 0; i < 5000000; i++) {
			degrees[i] = random.nextFloat() * 5000000;
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].rotatePoint(degrees[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for rotatePoint(double rotation): " + (finish - start) + "ms");

		// analysis for toString()
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points[i].toString();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for toString(): " + (finish - start) + "ms");

	}
}
