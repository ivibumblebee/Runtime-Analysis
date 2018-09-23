package assignment1;

/**
 * This is an interface outlining the methods required for an object
 * that stores a point in either cartesian or polar format. 
 * 
 * @author Ivana Erlich ierli042@uottawa.ca (8682437)
 * @author David Dearden pdear036@uottawa.ca (300039831)
 * @version September 2018
 */
public interface PointCP6 {

	/**
	 * Getter for the x coordinate of this point
	 * @return The x value of this point object
	 */
	public double getX();

	/**
	 * Getter for the y coordinate of this point
	 * @return The y value of this point object
	 */
	public double getY();

	/**
	 * Getter for the rho value of this point
	 * @return The rho value of this point object
	 */
	public double getRho();

	/**
	 * Getter for the theta value of this point
     * @return The theta value of this point object
	 */
	public double getTheta();

	/**
	 * Gets an object representing this point with the values stored in polar form.
	 * @return An object which implements pointCP6 with the same coordinates as the 
	 * object it is called from
	 */
	public PointCP6 convertStorageToPolar();

	/**
	 * Gets an object representing this point with the values stored in cartesian form.
	 * @return An object which implements pointCP6 with the same coordinates as the 
	 * object it is called from
	 */
	public PointCP6 convertStorageToCartesian();

	/**
	 * Calculates the distance in between this point and the given point
	 * using the Pythagorean theorem (C ^ 2 = A ^ 2 + B ^ 2). 
	 * 
	 * @param pointB The point to compare against this point.
	 * @return The distance between the two points.
	 */
	public double getDistance(PointCP6 pointB);

	/**
	 * Rotates this point by the specified number of degrees. 
	 * 
	 * @param rotation The number of degrees to rotate the point.
	 * @return The rotated image of the this point.
	 */
	public PointCP6 rotatePoint(double rotation);

	/**
	 * Returns information about the coordinates.
	 *
	 * @return A String containing information about the coordinates.
	 */
	public String toString();

}
