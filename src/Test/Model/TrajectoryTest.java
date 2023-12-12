package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class TrajectoryTest {

    Trajectory trajectory;
    ArrayList<Point> points = new ArrayList<>();

    @BeforeEach
    void setUp() {
        points.add(new Point("2.000  1976091.0  3974537.2  4564998.2  1.671  4.251  4.931"));
        points.add(new Point("3.000  1976106.2  3974538.9  4565022.1  3.707  6.415  7.780"));
        points.add(new Point("4.000  1976141.1  3974530.0  4565022.4  4.244  9.116  10.318"));
        trajectory = new Trajectory(points);
    }

    @Test
    void getPoints() {
        Assertions.assertEquals(points, trajectory.getPoints());
    }

    @Test
    void setPoints() {
        ArrayList<Point> points1 = new ArrayList<>();
        points1.add(new Point("5.000  1976148.1  3974530.9  4565030.2  6.209  11.678  13.072"));
        points1.add(new Point("6.000  1976060.7  3974622.9  4565015.4  6.970  13.928  16.196"));
        points1.add(new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861"));
        trajectory.setPoints(points1);
        Assertions.assertEquals(points1, trajectory.getPoints());
        Assertions.assertNotEquals(points, trajectory.getPoints());
    }

    @Test
    void addPoint() {
        trajectory.addPoint(new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861"));
        Assertions.assertNotEquals(points, trajectory.getPoints());
        points.add(new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861"));
        Assertions.assertEquals(points, trajectory.getPoints());
        trajectory.addPoint(0, new Point("6.000  1976060.7  3974622.9  4565015.4  6.970  13.928  16.196"));
        points.add(0, new Point("6.000  1976060.7  3974622.9  4565015.4  6.970  13.928  16.196"));
        Assertions.assertEquals(points, trajectory.getPoints());
        trajectory.addPoint(1, new Point("6.000  1976060.7  3974622.9  4565015.4  6.970  13.928  16.196"));
        points.add(1, new Point("6.000  1976060.7  3974622.9  4565015.4  6.970  13.928  16.196"));
        Assertions.assertEquals(points, trajectory.getPoints());
    }

    @Test
    void size() {
        Assertions.assertEquals(points.size(), trajectory.size());
        trajectory.addPoint(new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861"));
        Assertions.assertEquals(points.size() + 1, trajectory.size());
        trajectory = new Trajectory();
        Assertions.assertEquals(0, trajectory.size());
    }

    @Test
    void addAll() {
        ArrayList<Point> points1 = new ArrayList<>();
        points1.add(new Point("5.000  1976148.1  3974530.9  4565030.2  6.209  11.678  13.072"));
        points1.add(new Point("6.000  1976060.7  3974622.9  4565015.4  6.970  13.928  16.196"));
        points1.add(new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861"));
        trajectory.addAll(points1);
        Assertions.assertNotEquals(points, trajectory.getPoints());
        points.addAll(points1);
        Assertions.assertEquals(points, trajectory.getPoints());
    }

    @Test
    void removePoint() {
        trajectory.removePoint(0);
        Assertions.assertNotEquals(points, trajectory.getPoints());
        Assertions.assertEquals(points.get(1), trajectory.getPoint(0));
        Assertions.assertNotEquals(points, trajectory.getPoints());
        Assertions.assertEquals(points.get(1), trajectory.getPoint(0));
        points.remove(0);
        Assertions.assertEquals(points, trajectory.getPoints());
        trajectory.removePoint(new Point("4.000  1976141.1  3974530.0  4565022.4  4.244  9.116  10.318"));
        Assertions.assertNotEquals(points, trajectory.getPoints());
        points.remove(new Point("4.000  1976141.1  3974530.0  4565022.4  4.244  9.116  10.318"));
        Assertions.assertEquals(points, trajectory.getPoints());
    }

    @Test
    void clear() {
        trajectory.clear();
        Assertions.assertEquals(new ArrayList<Point>(), trajectory.getPoints());
    }

    @Test
    void getPoint() {
        Assertions.assertEquals(points.get(1), trajectory.getPoint(1));
    }

    @Test
    void setPoint() {
        trajectory.setPoint(1, new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861"));
        Assertions.assertNotEquals(points.get(1), trajectory.getPoint(1));
        points.set(1, new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861"));
        Assertions.assertEquals(points, trajectory.getPoints());
    }

    @Test
    void contains() {
        Assertions.assertFalse(trajectory.contains(new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861")));
        trajectory.setPoint(1, new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861"));
        Assertions.assertTrue(trajectory.contains(new Point("7.000  1976117.6  3974596.9  4565109.3  8.188  16.455  18.861")));
    }

    @Test
    void testToString() {
        Assertions.assertEquals("""
                Trajectory
                Size: 3
                Points:
                Point {time=2.0, x=1976091.0, y=3974537.2, z=4564998.2, vX=1.671, vY=4.251, vZ=4.931}
                Point {time=3.0, x=1976106.2, y=3974538.9, z=4565022.1, vX=3.707, vY=6.415, vZ=7.78}
                Point {time=4.0, x=1976141.1, y=3974530.0, z=4565022.4, vX=4.244, vY=9.116, vZ=10.318}
                """,trajectory.toString());
        trajectory.removePoint(0);
        Assertions.assertEquals("""
                Trajectory
                Size: 2
                Points:
                Point {time=3.0, x=1976106.2, y=3974538.9, z=4565022.1, vX=3.707, vY=6.415, vZ=7.78}
                Point {time=4.0, x=1976141.1, y=3974530.0, z=4565022.4, vX=4.244, vY=9.116, vZ=10.318}
                """,trajectory.toString());
        trajectory.clear();
        Assertions.assertEquals("""
                Trajectory
                Size: 0
                Points:
                """,trajectory.toString());
    }
}