package assignment1;

/**
 * This class contains instances of coordinates in polar format.
 * It also provides the utilities to convert the coordinates to the 
 * cartesian format.  
 * 
 * @author Ivana Erlich ierli042@uottawa.ca (8682437)
 * @author David Dearden pdear036@uottawa.ca (300039831)
 * @version September 2018
 */
public class PointCP2 implements PointCP6 {
	
	// Instance variables ************************************************

	/**
	 * Contains the current value of rho
	 */
	private double rho;

	/**
	 * Contains the current value of theta
	 */
	private double theta;

	// Constructors ******************************************************

	/**
	 * Constructs a coordinate object with the given coordinates.
	 * 
	 * @throws IllegalArgumentException if the type is not 'P' or 'C'
     * 
     * @param type The type of coordinates.  'C' for cartesian or 'P' for polar. 
     * @param cor1 The first coordinate.  When type is 'C', this is the rho value, when type is 'P' this is the x value.
     * @param cor2 The first coordinate.  When type is 'C', this is the theta value, when type is 'P' this is the y value.
	 */
	public PointCP2(char type, double cor1, double cor2) {
		if (type != 'C' && type != 'P') {
			throw new IllegalArgumentException("The type must be either 'C' for cartesian or 'P' for polar.");
		} else if (type == 'P') {
			rho = cor1;
			theta = cor2;
		} else {
			rho = (Math.sqrt(Math.pow(cor1, 2) + Math.pow(cor2, 2)));
			theta = Math.toDegrees(Math.atan2(cor2, cor1));
		}
	}

	// Instance methods **************************************************

	/**
	 * Getter for the x coordinate of this point
     * @return The x value of this point object
	 */
	public double getX() {
		return (Math.cos(Math.toRadians(theta)) * rho);
	}

	/**
	 * Getter for the y coordinate of this point
     * @return The y value of this point object
	 */
	public double getY() {
		return (Math.sin(Math.toRadians(theta)) * rho);
	}

	/**
	 * Getter for the rho value of this point
     * @return The rho value of this point object
	 */
	public double getRho() {
		return rho;
	}

	/**
	 * Getter for the theta value of this point
     * @return The theta value of this point object
	 */
	public double getTheta() {
		return theta;
	}

	/**
	 * Gets an object representing this point with the values stored in polar form.
	 * @return A pointCP2 object with the same coordinates as this point
	 */
	public PointCP2 convertStorageToPolar() {
		return this;
	}

	/**
	 * Gets an object representing this point with the values stored in polar form.
	 * @return A pointCP3 object with the same coordinates as this point
	 */
	public PointCP3 convertStorageToCartesian() {
		return new PointCP3('C', getX(), getY());
	}

	/**
	 * Calculates the distance in between this point and the given point
	 * using the Pythagorean theorem (C ^ 2 = A ^ 2 + B ^ 2). 
	 * 
	 * @param pointB The point to compare against this point.
	 * @return The distance between the two points.
	 */
	public double getDistance(PointCP6 pointB) {
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	/**
	 * Rotates this point by the specified number of degrees. 
	 * 
	 * @param rotation The number of degrees to rotate the point.
	 * @return The rotated image of the this point.
	 */
	public PointCP2 rotatePoint(double rotation) {
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		double newX = (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y);
		double newY = (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y);

		return new PointCP2('P', (Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2))),
				Math.toDegrees(Math.atan2(newY, newX)));
	}

	/**
	 * Returns information about the coordinates.
	 *
	 * @return A String containing information about the coordinates.
	 */
	public String toString() {
		return "Stored as Polar [" + getRho() + "," + getTheta() + "]" + "\n";
	}
	
}
