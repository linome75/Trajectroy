package Model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Класс точки, поля соответствуют представленным в файле.
Методы: конструкторы, геттеры, сеттеры, equals, toString*/
public class Point {
    private double time;
    private double x;
    private double y;
    private double z;
    private double vX;
    private double vY;
    private double vZ;

    public Point(Double time, Double x, Double y, Double z, Double vX, Double vY, Double vZ) {
        this.time = time;
        this.x = x;
        this.y = y;
        this.z = z;
        this.vX = vX;
        this.vY = vY;
        this.vZ = vZ;
    }

    public Point(String point) {

        try {
            Pattern pattern = Pattern.compile("(\\d+\\.\\d+\\s+){6}\\d+\\.\\d+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(point);
            if (!matcher.matches()){
                throw new IllegalArgumentException("String \"" + point + "\" doesn't match pattern");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        String[] splitInput = point.split(" {2}");
        time = Double.parseDouble(splitInput[0]);
        x = Double.parseDouble(splitInput[1]);
        y = Double.parseDouble(splitInput[2]);
        z = Double.parseDouble(splitInput[3]);
        vX = Double.parseDouble(splitInput[4]);
        vY = Double.parseDouble(splitInput[5]);
        vZ = Double.parseDouble(splitInput[6]);
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Double getvX() {
        return vX;
    }

    public void setvX(Double vX) {
        this.vX = vX;
    }

    public Double getvY() {
        return vY;
    }

    public void setvY(Double vY) {
        this.vY = vY;
    }

    public Double getvZ() {
        return vZ;
    }

    public void setvZ(Double vZ) {
        this.vZ = vZ;
    }

    @Override
    public String toString() {
        return "Point " + "{" + "time=" + time +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", vX=" + vX +
                ", vY=" + vY +
                ", vZ=" + vZ +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return Objects.equals(getTime(), point.getTime()) && Objects.equals(getX(), point.getX()) && Objects.equals(getY(), point.getY()) && Objects.equals(getZ(), point.getZ()) && Objects.equals(getvX(), point.getvX()) && Objects.equals(getvY(), point.getvY()) && Objects.equals(getvZ(), point.getvZ());
    }


}
