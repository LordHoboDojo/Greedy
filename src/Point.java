public class Point 
{
	private double  x, y;
	private boolean visited;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/** get the Euclidean distance between two points */
	public double getDistance(Point other)
	{
		//TODO
		return Math.sqrt(Math.pow(x-other.x,2)+ Math.pow(y-other.y,2)); //replace
	}
	
	@Override
	public String toString()
	{
		//TODO
		return "(" +x + "," + y + ")";
	}
}
