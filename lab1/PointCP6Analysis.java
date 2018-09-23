package lab1;

import java.util.Random;

public class PointCP6Analysis {
	public static void main(String[] args) {
		// set up
		Random random = new Random();
		PointCP6[] points2 = new PointCP6[5000000];
		PointCP6[] points3 = new PointCP6[5000000];
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

		// analysis for instantiation with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i] = new PointCP2(types[i], rhos[i], thetas[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for instantiation with concrete class PointCP2 : " + (finish - start) + "ms");

		// analysis for instantiation with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i] = new PointCP3(types[i], rhos[i], thetas[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for instantiation with concrete class PointCP2 : " + (finish - start) + "ms");

		// analysis for getX() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].getX();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getX() with concrete class PointCP2 : " + (finish - start) + "ms");

		// analysis for getX() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].getX();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getX() with concrete class PointCP3: " + (finish - start) + "ms");

		// analysis for getY() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].getY();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getY() with concrete class PointCP2: " + (finish - start) + "ms");

		// analysis for getY() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].getY();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getY( )with concrete class PointCP3: " + (finish - start) + "ms");

		// analysis for getRho() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].getRho();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getRho() with concrete class PointCP2: " + (finish - start) + "ms");

		// analysis for getRho() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].getRho();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getRho() with concrete class PointCP3: " + (finish - start) + "ms");

		// analysis for getTheta() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].getTheta();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getTheta() with concrete class PointCP2: " + (finish - start) + "ms");

		// analysis for getTheta() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].getTheta();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for getTheta() with concrete class PointCP3: " + (finish - start) + "ms");

		// analysis for convertStorageToPolar() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].convertStorageToPolar();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for convertStorageToPolar() with concrete class PointCP2: " + (finish - start) + "ms");

		// analysis for convertStorageToPolar() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].convertStorageToPolar();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for convertStorageToPolar() with concrete class PointCP3: " + (finish - start) + "ms");

		// analysis for convertStorageToCartesian() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].convertStorageToCartesian();
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for convertStorageToCartesian() with concrete class PointCP2: " + (finish - start) + "ms");

		// analysis for convertStorageToCartesian() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].convertStorageToCartesian();
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for convertStorageToCartesian() with concrete class PointCP3: " + (finish - start) + "ms");

		// analysis for getDistance(PointC6 pointB) with concrete class PointCP2
		PointCP6[] points2other = new PointCP6[5000000];
		for (int i = 0; i < 5000000; i++) {
			if (random.nextInt(2) == 0) {
				points2other[i] = new PointCP2('C', random.nextFloat() * 5000000, random.nextFloat() * 360);
			} else {
				points2other[i] = new PointCP2('P', random.nextFloat() * 5000000, random.nextFloat() * 360);
			}
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].getDistance(points2other[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for getDistance(PointC6 pointB) with concrete class PointCP2: " + (finish - start) + "ms");

		// analysis for getDistance(PointC6 pointB) with concrete class PointCP3
		PointCP6[] points3other = new PointCP6[5000000];
		for (int i = 0; i < 5000000; i++) {
			if (random.nextInt(2) == 0) {
				points3other[i] = new PointCP3('C', random.nextFloat() * 5000000, random.nextFloat() * 360);
			} else {
				points3other[i] = new PointCP3('P', random.nextFloat() * 5000000, random.nextFloat() * 360);
			}
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].getDistance(points3other[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println(
				"Time for getDistance(PointC6 pointB with concrete class PointCP3): " + (finish - start) + "ms");

		// analysis for rotatePoint(double rotation) with concrete class PointCP2
		float[] degrees2 = new float[5000000];
		for (int i = 0; i < 5000000; i++) {
			degrees2[i] = random.nextFloat() * 5000000;
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].rotatePoint(degrees2[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for rotatePoint(double rotation) with concrete class PointCP2: " + (finish - start) + "ms");

		// analysis for rotatePoint(double rotation) with concrete class PointCP3
		float[] degrees3 = new float[5000000];
		for (int i = 0; i < 5000000; i++) {
			degrees3[i] = random.nextFloat() * 5000000;
		}
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].rotatePoint(degrees3[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for rotatePoint(double rotation) with concrete class PointCP3: " + (finish - start) + "ms");

		// analysis for toString() with concrete class PointCP2
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points2[i].toString();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for toString() with concrete class PointCP2: " + (finish - start) + "ms");

		// analysis for toString() with concrete class PointCP3
		start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			points3[i].toString();
		}
		finish = System.currentTimeMillis();
		System.out.println("Time for toString() with concrete class PointCP3: " + (finish - start) + "ms");

	}
}
