import java.util.Scanner;

public class FindNearestPoints {

  public static void main(String[] args) {
 
    double[][] points = createPointsArray();
    int[] closestPointSet = findClosestPoints(points);
    displayClosestPoints(points, closestPointSet[0], closestPointSet[1]);
    
  }


  public static double[][] createPointsArray(){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the number of points: ");
    int numberOfPoints = scan.nextInt();

    double[][] points = new double[numberOfPoints][3];
    System.out.println("Enter " + numberOfPoints + " points: ");
    for (int i = 0; i < points.length; i++){
      points[i][0] = scan.nextDouble();
      points[i][1] = scan.nextDouble();
      points[i][2] = scan.nextDouble();
    }
    return points;
  }

  public static int[] findClosestPoints(double[][] points){
    // p1 and p2 are the indices in the points array
    int p1 = 0, p2 = 1; // Initial two points
    double shortestDistance = distance(points[p1][0], points[p1][1],points[p1][2], points[p2][0], points[p2][1], points[p2][2]); // Initialize shortestDistance
    int[] closestPoint = new int[2];

    // Compute distance for every two points
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        double distance = distance(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1], points[j][2]); // Find distance
        if (shortestDistance > distance) {
          p1 = i; // Update p1
          p2 = j; // Update p2
          shortestDistance = distance; // Update shortestDistance
        }
      }
    }

    closestPoint[0] = p1;
    closestPoint[1] = p2;
    
    return closestPoint;
  }

  public static void displayClosestPoints(double[][] userPoints, int p1, int p2){
    // Display result
    System.out.println("The closest two points are " +
        "(" + userPoints[p1][0] + ", " + userPoints[p1][1] + ", " + userPoints[p1][2] + ") and (" + userPoints[p2][0] + ", " + userPoints[p2][1] + ", " + userPoints[p2][2] + ")");
  }
  /**
   * Compute the distance between two points (x1, y1) and (x2, y2)
   */
  public static double distance(
      double x1, double y1, double z1, double x2, double y2, double z2) {
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
  }
}





