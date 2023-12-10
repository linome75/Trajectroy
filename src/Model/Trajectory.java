package Model;

import java.util.ArrayList;

public class Trajectory {

    private ArrayList<Point> points = new ArrayList<>();

    public Trajectory(ArrayList<Point> points) {
        this.points = points;
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

    public Point removePoint(int index) {
        return this.points.remove(index);
    }

    public boolean removePoint(Point point) {
        return this.points.remove(point);
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
        return this.contains(point);
    }


    @Override
    public String toString() {
        return "Trajectory{" +
                "points=" + points +
                '}';
    }
}