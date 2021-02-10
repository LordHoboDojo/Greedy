import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Path
{
	private Point[] points;
	private double  minX, minY; //min X and Y values, for setting canvas scale
	private double  maxX, maxY; //maxes

	public Point[] getPoints() {
		return points;
	}

	/** construct a path from a given file */
	public Path(String fileName) throws FileNotFoundException {
		//TODO
		Scanner sc = new Scanner(new File(fileName));
		int n = sc.nextInt();
		points = new Point[n];
		for (int i=0; i<n; i++){
			points[i] = new Point(sc.nextDouble(),sc.nextDouble());
			if (i == 0) {
				maxX = points[i].getX();
				maxY = points[i].getY();
			}
			else{
				maxY = Math.max(maxY, points[i].getY());
				maxX = Math.max(maxX,points[i].getX());
			}
			if (i == 0) {
				minX = points[i].getX();
				minY = points[i].getY();
			}
			else{
				minY = Math.min(minY, points[i].getY());
				minX = Math.min(minX,points[i].getX());
			}
		}
	}

	/** returns the distance traveled going point to point, in order given in file */
	public double getDistance()
	{
		//TODO
		double res = 0;
		for (int i =0; i< points.length-1;i++){
			res += points[i].getDistance(points[i+1]);
		}
		return res; //replace
	}

	@Override
	public String toString()
	{
		//TODO
		StringBuilder res = new StringBuilder();
		for (Point p: points){
			res.append(p).append("\n");
		}
		return res.toString();
	}

	public double getMinX() {
		return minX;
	}

	public void setMinX(double minX) {
		this.minX = minX;
	}

	public double getMinY() {
		return minY;
	}

	public void setMinY(double minY) {
		this.minY = minY;
	}

	public double getMaxX() {
		return maxX;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public double getMaxY() {
		return maxY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	public int getNumPoints() {
		return points.length;
	}

	public Point getPoint(int i) {
		return points[i];
	}
}
