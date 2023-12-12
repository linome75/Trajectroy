package Model;

import java.util.ArrayList;

public class Trajectory {

    private ArrayList<Point> points = new ArrayList<>();

    public Trajectory(ArrayList<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public Trajectory() {
    }
    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public int size() {
        return points.size();
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public void addPoint(int index, Point point) {
        this.points.add(index, point);
    }

    public void addAll(ArrayList<Point> array) {
        this.points.addAll(array);
    }

    public void removePoint(int index) {
        this.points.remove(index);
    }

    public void removePoint(Point point) {
        this.points.remove(point);
    }

    public void clear() {
        this.points.clear();
    }

    public Point getPoint(int index) {
        return this.points.get(index);
    }

    public void setPoint(int index, Point point) {
        points.set(index, point);
    }

    public boolean contains(Point point) {
        return points.contains(point);
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Trajectory\n");
        out.append("Size: ").append(this.size()).append("\nPoints:\n");
        points.forEach((point -> out.append(point.toString()).append("\n")));
        return out.toString();
    }
}