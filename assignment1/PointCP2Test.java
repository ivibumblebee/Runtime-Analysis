package assignment1;

import java.io.IOException;

/**
 * This class tests the functionality of the PointCP2 class. 
 * 
 * @author Ivana Erlich ierli042@uottawa.ca (8682437)
 * @author David Dearden pdear036@uottawa.ca (300039831)
 * @version September 2018
 */
public class PointCP2Test {
	
	/**
	 * The <b>main</b> of the application. 
	 * Prompt the user and test according the the values given.
	 * 
	 * @param args command line parameters
	 */
	public static void main(String[] args) {
		
		PointCP2 point;
		PointCP2 point2;
		System.out.println("Testing Program for PointCP2");

		// Prompt the user for input
		try {
			point = getInput();
		} catch (IOException ex) {
			System.out.println("Error getting input. Ending program.");
			return;
		}

		System.out.println("\nYou entered:\n" + point);
		PointCP3 cartesianpoint = point.convertStorageToCartesian();
		System.out.println("\nAfter asking to store as Cartesian:\n" + cartesianpoint);
		PointCP2 polarpoint = point.convertStorageToPolar();
		System.out.println("\nAfter asking to store as Polar:\n" + polarpoint);
		System.out.println("\nNow enter another point to compute the distance");
		try {
			point2 = new PointCP2(args[0].toUpperCase().charAt(0), Double.valueOf(args[1]).doubleValue(),
					Double.valueOf(args[2]).doubleValue());
		} catch (Exception e) {
			// If we arrive here, it is because either there were no
			// command line arguments, or they were invalid
			if (args.length != 0) {
				System.out.println("Invalid arguments on command line");
			}

			try {
				point2 = getInput();
			} catch (IOException ex) {
				System.out.println("Error getting input. Ending program.");
				return;
			}
		}
		System.out.println("Origin Point: " + point2);
		System.out.println("\nThe distance between the two points is " + point.getDistance(point2));
		try {
			System.out.println("After rotation, the point would " + point.rotatePoint(getDegrees()));
		} catch (IOException ex) {
			System.out.println("Error getting input. Ending program.");
		}
	}

	/**
	 * This method obtains input from the user and verifies that it is valid. When
	 * the input is valid, it returns a PointCP object.
	 *
	 * @return A PointCP constructed using information obtained from the user.
	 * @throws IOException If there is an error getting input from the user.
	 */
	private static PointCP2 getInput() throws IOException {
		byte[] buffer = new byte[1024]; // Buffer to hold byte input
		boolean isOK = false; // Flag set if input correct
		String theInput = ""; // Input information

		// Information to be passed to the constructor
		char coordType = 'A'; // Temporary default, to be set to P or C
		double a = 0.0;
		double b = 0.0;

		// Allow the user to enter the three different arguments
		for (int i = 0; i < 3; i++) {
			while (!(isOK)) {
				isOK = true; // flag set to true assuming input will be valid

				// Prompt the user
				if (i == 0) { // First argument - type of coordinates
					System.out.print("Enter the type of Coordinates you " + "are inputting ((C)artesian / (P)olar): ");
				} else { // Second and third arguments
					System.out.print("Enter the value of "
							+ (coordType == 'C' ? (i == 1 ? "X " : "Y ") : (i == 1 ? "Rho " : "Theta "))
							+ "using a decimal point(.): ");
				}

				// Get the user's input

				// Initialize the buffer before we read the input
				for (int k = 0; k < 1024; k++) {
					buffer[k] = '\u0020';
				}

				System.in.read(buffer);
				theInput = new String(buffer).trim();

				// Verify the user's input
				try {
					if (i == 0) { // First argument -- type of coordinates
						if (!((theInput.toUpperCase().charAt(0) == 'C') || (theInput.toUpperCase().charAt(0) == 'P'))) {
							// Invalid input, reset flag so user is prompted again
							isOK = false;
						} else {
							coordType = theInput.toUpperCase().charAt(0);
						}
					} else { // Second and third arguments
						// Convert the input to double values
						if (i == 1)
							a = Double.valueOf(theInput).doubleValue();
						else
							b = Double.valueOf(theInput).doubleValue();
					}
				} catch (Exception e) {
					System.out.println("Incorrect input");
					isOK = false; // Reset flag as so not to end while loop
				}
			}

			// Reset flag so while loop will prompt for other arguments
			isOK = false;
		}
		// Return a new PointCP object
		return (new PointCP2(coordType, a, b));
	}

	/**
	 * This method obtains input from the user and verifies that it is valid. When
	 * the input is valid, it returns an integer.
	 *
	 * @return A integer obtained from the user.
	 * @throws IOException If there is an error getting input from the user.
	 */
	private static float getDegrees() throws IOException {
		byte[] buffer = new byte[1024]; // Buffer to hold byte input
		boolean isOK = false; // Flag set if input correct
		String theInput = ""; // Input information

		// Information to be passed to the constructor
		float a = 0;
		while (!(isOK)) {
			isOK = true; // flag set to true assuming input will be valid

			// Prompt the user
			System.out.print("Enter the angle in degree for rotation: ");

			// Get the user's input

			// Initialize the buffer before we read the input
			for (int k = 0; k < 1024; k++) {
				buffer[k] = '\u0020';
			}

			System.in.read(buffer);
			theInput = new String(buffer).trim();

			// Verify the user's input
			try {
				a = Float.parseFloat(theInput);
			} catch (Exception e) {
				System.out.println("Incorrect input");
				isOK = false; // Reset flag as so not to end while loop
			}
		}

		// Return the rotation angle
		return a;
	}
	
}
