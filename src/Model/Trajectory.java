package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/*
Класс траектории, построен на ArrayList, также имеет поле файла.
Методы: конструкторы, геттеры, сеттеры, addPoint, removePoint, clear,  contains, size, toStrong.
*/


public class Trajectory {

    private ArrayList<Point> points = new ArrayList<>();

    private String fileName;

    public Trajectory(ArrayList<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public Trajectory() {
    }

    public Trajectory(Trajectory trajectory) {
        this.points = new ArrayList<>(trajectory.getPoints());
        this.fileName = trajectory.getFileName();
    }

    public Trajectory(String fileName) {
        this.fileName = fileName;
        this.points = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                this.addPoint(new Point(line));
            }
            bufferedReader.close();
        } catch (IOException ignored) {

        }

    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public String getFileName(){
        return fileName;
    }

    public File getFile(){
        return new File(fileName);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trajectory that)) return false;
        return Objects.equals(getPoints(), that.getPoints());// && Objects.equals(getFileName(), that.getFileName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoints(), getFileName());
    }
}