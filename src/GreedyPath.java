import java.io.FileNotFoundException;

public class GreedyPath extends Path {
    /**
     * construct a path from a given file
     *
     * @param fileName
     */
    Point[] greedyPoints;
    public GreedyPath(String fileName) throws FileNotFoundException {
        super(fileName);
        greedyPoints = new Point[super.getNumPoints()];
        findPath();
    }
    public void findPath(){
        int currentIndex = 0;
        super.getPoint(0).setVisited(true);
        greedyPoints[0] = super.getPoint(0);
        for (int i =1; i< super.getNumPoints();i++){
            int index = getMinDistanceIndex(currentIndex);
            currentIndex = index;
            greedyPoints[i] = super.getPoint(index);
            super.getPoint(index).setVisited(true);
        }

    }
    public int getMinDistanceIndex(int currentIndex){
        int minIndex = 0;
        double minDistance = Integer.MAX_VALUE;
        for (int i =0;  i<super.getNumPoints();i++){
            if (i != currentIndex && !super.getPoint(i).isVisited()){
                double dist = super.getPoint(currentIndex).getDistance(super.getPoint(i));
                if (dist < minDistance){
                    minDistance = dist;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
    @Override
    public double getDistance()
    {
        //TODO
        double res = 0;
        for (int i =0; i< greedyPoints.length-1;i++){
            res += greedyPoints[i].getDistance(greedyPoints[i+1]);
        }
        return res; //replace
    }
    @Override
    public String toString()
    {
        //TODO
        StringBuilder res = new StringBuilder();
        for (Point p: greedyPoints){
            res.append(p).append("\n");
        }
        return res.toString();
    }
    @Override
    public Point getPoint(int i) {
        return greedyPoints[i];
    }
}
