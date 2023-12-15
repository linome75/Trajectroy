package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;


class TrajectoryTest {

    Trajectory trajectory;
    ArrayList<Point> points = new ArrayList<>();

    String fileName = "src\\Source\\traject1.txt";


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
    void getFile(){
        trajectory = new Trajectory(fileName);
        Assertions.assertEquals(new File(fileName), trajectory.getFile());
    }

    @Test
    void getFileName(){
        trajectory = new Trajectory(fileName);
        Assertions.assertEquals("traject1.txt", trajectory.getFileName());
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

    @Test
    void creatingFromFile() {
        trajectory = new Trajectory(fileName);
       Assertions.assertEquals("""
               Trajectory
               Size: 29
               Points:
               Point {time=2.0, x=1976091.0, y=3974537.2, z=4564998.2, vX=1.671, vY=4.251, vZ=4.931}
               Point {time=3.0, x=1976106.2, y=3974538.9, z=4565022.1, vX=3.707, vY=6.415, vZ=7.78}
               Point {time=4.0, x=1976141.1, y=3974530.0, z=4565022.4, vX=4.244, vY=9.116, vZ=10.318}
               Point {time=5.0, x=1976148.1, y=3974530.9, z=4565030.2, vX=6.209, vY=11.678, vZ=13.072}
               Point {time=6.0, x=1976060.7, y=3974622.9, z=4565015.4, vX=6.97, vY=13.928, vZ=16.196}
               Point {time=7.0, x=1976117.6, y=3974596.9, z=4565109.3, vX=8.188, vY=16.455, vZ=18.861}
               Point {time=8.0, x=1976110.0, y=3974639.2, z=4565129.4, vX=10.102, vY=18.708, vZ=21.844}
               Point {time=9.0, x=1976109.7, y=3974633.1, z=4565147.3, vX=11.134, vY=21.199, vZ=24.728}
               Point {time=10.0, x=1976212.0, y=3974641.0, z=4565150.8, vX=12.065, vY=23.748, vZ=27.484}
               Point {time=11.0, x=1976136.6, y=3974689.7, z=4565152.9, vX=13.201, vY=26.684, vZ=31.041}
               Point {time=12.0, x=1976139.5, y=3974698.5, z=4565210.6, vX=13.545, vY=28.759, vZ=34.097}
               Point {time=13.0, x=1976180.9, y=3974735.2, z=4565265.2, vX=15.103, vY=31.685, vZ=36.885}
               Point {time=14.0, x=1976201.7, y=3974727.1, z=4565258.6, vX=16.145, vY=34.036, vZ=40.361}
               Point {time=15.0, x=1976211.0, y=3974804.4, z=4565275.6, vX=16.682, vY=37.9, vZ=43.035}
               Point {time=16.0, x=1976235.7, y=3974855.3, z=4565393.1, vX=17.704, vY=39.761, vZ=46.83}
               Point {time=17.0, x=1976253.6, y=3974904.1, z=4565466.0, vX=18.785, vY=43.301, vZ=50.81}
               Point {time=18.0, x=1976285.7, y=3974947.3, z=4565469.1, vX=19.42, vY=46.296, vZ=54.212}
               Point {time=19.0, x=1976278.4, y=3974989.3, z=4565499.5, vX=19.32, vY=49.629, vZ=58.423}
               Point {time=20.0, x=1976335.4, y=3975016.9, z=4565558.3, vX=20.954, vY=52.685, vZ=61.961}
               Point {time=21.0, x=1976390.7, y=3975102.0, z=4565667.6, vX=21.25, vY=55.052, vZ=65.847}
               Point {time=22.0, x=1976363.8, y=3975113.3, z=4565745.3, vX=22.037, vY=58.548, vZ=70.751}
               Point {time=23.0, x=1976390.0, y=3975209.3, z=4565753.2, vX=22.555, vY=62.346, vZ=74.467}
               Point {time=24.0, x=1976350.6, y=3975251.4, z=4565883.0, vX=22.035, vY=65.654, vZ=79.098}
               Point {time=25.0, x=1976423.0, y=3975400.3, z=4565928.5, vX=22.493, vY=69.161, vZ=83.421}
               Point {time=26.0, x=1976459.4, y=3975441.8, z=4566119.1, vX=22.257, vY=73.124, vZ=87.716}
               Point {time=27.0, x=1976440.1, y=3975523.8, z=4566148.4, vX=22.418, vY=76.441, vZ=92.615}
               Point {time=28.0, x=1976473.6, y=3975592.0, z=4566250.5, vX=21.823, vY=80.558, vZ=98.152}
               Point {time=29.0, x=1976515.4, y=3975651.9, z=4566338.7, vX=21.203, vY=83.581, vZ=102.718}
               Point {time=30.0, x=1976500.3, y=3975765.2, z=4566393.5, vX=20.576, vY=88.191, vZ=108.269}
               """, trajectory.toString());
    }
}