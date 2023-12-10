package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void size() {
        Assertions.assertEquals(points.size(), trajectory.size());
    }

    @Test
    void addPoint() {
    }

    @Test
    void testAddPoint() {
    }

    @Test
    void addAll() {
    }

    @Test
    void removePoint() {
    }

    @Test
    void testRemovePoint() {
    }

    @Test
    void clear() {
    }

    @Test
    void getPoint() {
    }

    @Test
    void setPoint() {
    }

    @Test
    void contains() {
    }

    @Test
    void testToString() {
    }
}