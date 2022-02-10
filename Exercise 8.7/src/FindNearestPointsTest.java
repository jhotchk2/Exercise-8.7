import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FindNearestPointsTest {

  @SuppressWarnings("static-access")
  @Test
  void testFindClosestPoints() {
    FindNearestPoints point = new FindNearestPoints();
    double[][] points = {{-1, 0, 3},
                        {-1, -1, -1},
                        {4, 1, 1},
                        {2, 0.5, 9},
                        {3.5, 2, -1},
                        {3, 1.5, 3},
                        {-1.5, 4, 2},
                        {5.5, 4, -0.5}};
    int[] closestPoint = point.findClosestPoints(points);
    assertEquals(2, closestPoint[0]);
    assertEquals(4, closestPoint[1]);
  }

  @SuppressWarnings("static-access")
  @Test
  void testDistance() {
    FindNearestPoints point = new FindNearestPoints();
    assertEquals(2.29128784747792, point.distance(4, 1, 1, 3.5, 2, -1));
  }

}
