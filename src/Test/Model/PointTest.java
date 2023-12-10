package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class PointTest {

    static Point point;
    static Point point1;
    static Point point2;

    @BeforeAll
    static void setPoint(){
        point = new Point(2.000, 1976091.0, 3974537.2, 4564998.2, 1.671, 4.251, 4.931);
        point1 = new Point("3.000  1976106.2  3974538.9  4565022.1  3.707  6.415  7.780");
        point2 = new Point("4.000  1976141.1  3974530.0  4565022.4  4.244  9.116  10.318");
    }
    @Test
    void getTime() {
        Assertions.assertEquals(point.getTime(), 2.);
    }

    @Test
    void setTime() {
        point.setTime(3.);
        Assertions.assertEquals(point.getTime(), 3.);
        point.setTime(Double.MAX_VALUE);
        Assertions.assertEquals(point.getTime(), Double.MAX_VALUE);
        point.setTime(Double.MIN_VALUE);
        Assertions.assertEquals(point.getTime(), Double.MIN_VALUE);
        point.setTime(null);
        Assertions.assertNull(point.getTime());
    }

    @Test
    void getX() {
        Assertions.assertEquals(point.getX(), 1976091.0);
    }

    @Test
    void setX() {
        point.setX(3.);
        Assertions.assertEquals(point.getX(), 3.);
        point.setX(Double.MAX_VALUE);
        Assertions.assertEquals(point.getX(), Double.MAX_VALUE);
        point.setX(Double.MIN_VALUE);
        Assertions.assertEquals(point.getX(), Double.MIN_VALUE);
        point.setX(null);
        Assertions.assertNull(point.getX());
    }

    @Test
    void getY() {
        Assertions.assertEquals(point.getY(), 3974537.2);
    }

    @Test
    void setY() {
        point.setY(3.);
        Assertions.assertEquals(point.getY(), 3.);
        point.setY(Double.MAX_VALUE);
        Assertions.assertEquals(point.getY(), Double.MAX_VALUE);
        point.setY(Double.MIN_VALUE);
        Assertions.assertEquals(point.getY(), Double.MIN_VALUE);
        point.setY(null);
        Assertions.assertNull(point.getY());
    }

    @Test
    void getZ() {
        Assertions.assertEquals(point.getZ(), 4564998.2);
    }

    @Test
    void setZ() {
        point.setZ(3.);
        Assertions.assertEquals(3., point.getZ() );
        point.setZ(Double.MAX_VALUE);
        Assertions.assertEquals(point.getZ(), Double.MAX_VALUE);
        point.setZ(Double.MIN_VALUE);
        Assertions.assertEquals(point.getZ(), Double.MIN_VALUE);
        point.setZ(null);
        Assertions.assertNull(point.getZ());
    }

    @Test
    void getvX() {
        Assertions.assertEquals(1.671, point.getvX());
    }

    @Test
    void setvX() {
        point.setvX(3.);
        Assertions.assertEquals(point.getvX(), 3.);
        point.setvX(Double.MAX_VALUE);
        Assertions.assertEquals(point.getvX(), Double.MAX_VALUE);
        point.setvX(Double.MIN_VALUE);
        Assertions.assertEquals(point.getvX(), Double.MIN_VALUE);
        point.setvX(null);
        Assertions.assertNull(point.getvX());
    }

    @Test
    void getvY() {
        Assertions.assertEquals(point.getvY(), 4.251);
    }

    @Test
    void setvY() {
        point.setvY(3.);
        Assertions.assertEquals(point.getvY(), 3.);
        point.setvY(Double.MAX_VALUE);
        Assertions.assertEquals(point.getvY(), Double.MAX_VALUE);
        point.setvY(Double.MIN_VALUE);
        Assertions.assertEquals(point.getvY(), Double.MIN_VALUE);
        point.setvY(null);
        Assertions.assertNull(point.getvY());
    }

    @Test
    void getvZ() {
        Assertions.assertEquals(point.getvZ(), 4.931);
    }

    @Test
    void setvZ() {
        point.setvZ(3.);
        Assertions.assertEquals(point.getvZ(), 3.);
        point.setvZ(Double.MAX_VALUE);
        Assertions.assertEquals(point.getvZ(), Double.MAX_VALUE);
        point.setvZ(Double.MIN_VALUE);
        Assertions.assertEquals(point.getvZ(), Double.MIN_VALUE);
        point.setvZ(null);
        Assertions.assertNull(point.getvZ());
    }




    @Test
    void testToString() {
        Assertions.assertEquals(point.toString(),
                "time=" + point.getTime() +
                        ", x=" + point.getX() +
                        ", y=" + point.getY() +
                        ", z=" + point.getZ() +
                        ", vX=" + point.getvX() +
                        ", vY=" + point.getvY() +
                        ", vZ=" + point.getvZ() +
                        '}');
    }

    @Test
    void testEquals() {
        point1 = point;
        Assertions.assertEquals(point, point);
        Assertions.assertEquals(point, point1);
        Assertions.assertNotEquals(point, point2);
        Assertions.assertNotEquals(point, null);
    }
}