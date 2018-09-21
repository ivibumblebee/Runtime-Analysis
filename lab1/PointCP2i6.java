package lab1;

public class PointCP2i6 implements PointCP6{
	// Instance variables ************************************************
	/**
	 * Contains C(artesian) or P(olar) to identify the type of coordinates that are
	 * being dealt with.
	 */
	private char typeCoord;

	/**
	 * Contains the current value of Rho
	 */
	private double Rho;

	/**
	 * Contains the current value of Theta
	 */
	private double Theta;

	// Constructors ******************************************************

	/**
	 * Constructs a coordinate object
	 */
	public PointCP2i6(char type, double cor1, double cor2) {
		if (type != 'C' && type != 'P') {
			throw new IllegalArgumentException();
		} else if (type == 'P') {
			this.Rho = cor1;
			this.Theta = cor2;
		} else {
			this.Rho = (Math.sqrt(Math.pow(cor1, 2) + Math.pow(cor2, 2)));
			this.Theta = Math.toDegrees(Math.atan2(cor2, cor1));
		}
		typeCoord = type;

	}

	// Instance methods **************************************************

	public double getX() {
		return (Math.cos(Math.toRadians(Theta)) * Rho);
	}

	public double getY() {
		return (Math.sin(Math.toRadians(Theta)) * Rho);
	}

	public double getRho() {
		return Rho;
	}

	public double getTheta() {
		return Theta;
	}

	/**
	 * Converts Cartesian coordinates to Polar coordinates.
	 */
	public PointCP6 convertStorageToPolar() {
		return this;
	}

	/**
	 * Converts Polar coordinates to Cartesian coordinates.
	 */
	public PointCP6 convertStorageToCartesian() {
		return new PointCP3i6('C', getX(), getY());
	}

	/**
	 * Calculates the distance in between two points using the Pythagorean theorem
	 * (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA The first point.
	 * @param pointB The second point.
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
	 * Rotates the specified point by the specified number of degrees. Not required
	 * until E2.30
	 *
	 * @param point    The point to rotate
	 * @param rotation The number of degrees to rotate the point.
	 * @return The rotated image of the original point.
	 */
	public PointCP6 rotatePoint(double rotation) {
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		double newX = (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y);
		double newY = (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y);

		return new PointCP2i6('P', (Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2))),
				Math.toDegrees(Math.atan2(newY, newX)));
	}

	/**
	 * Returns information about the coordinates.
	 *
	 * @return A String containing information about the coordinates.
	 */
	public String toString() {
		return "Stored as Polar Coordinates; Cartesian  (" + getX() + "," + getY() + "), Polar [" + getRho() + ","
				+ getTheta() + "]" + "\n";
	}
}
