package lab1;

public interface PointCP6 {
	 public double getX();
	 public double getY();
	 public double getRho();
	 public double getTheta();
	 public void convertStorageToPolar();
	 public void convertStorageToCartesian();
	 public double getDistance(PointCP6 pointB);
	 public PointCP6 rotatePoint(double rotation);
	 public String toString();
}
