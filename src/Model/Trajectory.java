package Model;

import java.util.*;

public class Trajectory extends LinkedList<Point> implements Iterable<Point> {
    private Point firstPoint;
    private Point lastPoint;
    private int size = 0;

    public Trajectory() {
        firstPoint = null;
        lastPoint = null;
    }

    @Override
    public Point getFirst() {
        return firstPoint;
    }

    @Override
    public Point getLast() {
        return lastPoint;
    }

    @Override
    public Point removeFirst() {
        if (firstPoint == null) {
            throw new NoSuchElementException();
        }
        if (firstPoint.child == null) {
            firstPoint = null;
            lastPoint = null;
        } else {
            firstPoint.child.setParent(null);
            firstPoint = firstPoint.getChild();
        }
        size--;
        return null;
    }

    @Override
    public Point removeLast() {
        if (lastPoint == null) {
            throw new NoSuchElementException();
        }
        if (lastPoint.getParent() == null){
            lastPoint = null;
            firstPoint = null;
        } else{
            lastPoint.parent.child = null;
            lastPoint = lastPoint.getParent();
        }
        size--;
        return null;
    }

    @Override
    public void addFirst(Point point) {
        if (firstPoint == null) {
            firstPoint = point;
            lastPoint = point;
        } else {
            point.setChild(firstPoint);
            firstPoint = point;
        }
        size++;
    }

    @Override
    public void addLast(Point point) {
        if (lastPoint == null) {
            firstPoint = point;
        } else {
            lastPoint.setChild(point);
        }
        lastPoint = point;
        size++;
    }

    @Override
    public boolean contains(Object o) {
        TrajectoryIterator iterator = new TrajectoryIterator();
        while (iterator.hasNext()){
            if (iterator.current.equals(o)) return true;
            iterator.next();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Point point) {
        if (this.contains(point)) return false;
        if (!(firstPoint == null)) {
            lastPoint.setChild(point);
        } else {
            firstPoint = point;
        }
        lastPoint = point;
        size++;
        return true;
    }


    @Override
    public void clear() {
        TrajectoryIterator iterator = new TrajectoryIterator();
        while (iterator.hasNext()){
            iterator.current.setParent(null);
        }
        size = 0;
        firstPoint = null;
        lastPoint = null;
    }

    @Override
    public Point get(int index) {
        if (index >= size){
            throw new NoSuchElementException();
        }
        TrajectoryIterator iterator = new TrajectoryIterator();
        for (int i = 0; i<index; i++) {
            iterator.next();
        }
        return iterator.current;
    }

    @Override
    public Point set(int index, Point element) {
        if (index >= size){
            throw new NoSuchElementException();
        }
        TrajectoryIterator iterator = new TrajectoryIterator();
        for (int i = 0; i<index; i++) {
            iterator.next();
        }
        iterator.current = element;
        return iterator.current;
    }

    @Override
    public void add(int index, Point element) {
        if (index >= size){
            throw new NoSuchElementException();
        }
        TrajectoryIterator iterator = new TrajectoryIterator();
        for (int i = 0; i<index; i++) {
            iterator.next();
        }
        iterator.current.child.setParent(element);
        iterator.current.parent.setChild(element);
    }

    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        TrajectoryIterator iterator = new TrajectoryIterator();
        for (int i = 0; i < size; i++){
            arr[i] = iterator.current;
            iterator.next();
        }
        return arr;
    }



    @Override
    public Iterator<Point> iterator() {
        return new TrajectoryIterator();
    }

    private class TrajectoryIterator implements Iterator<Point> {

        protected Point current;

        public TrajectoryIterator() {
            this.current = firstPoint;
        }

        @Override
        public boolean hasNext() {
            return !(firstPoint.child == null);
        }

        @Override
        public Point next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current = current.getChild();
            return current;
        }

        @Override
        public void remove() {
            if (current.getParent() == null) {
                throw new IllegalStateException();
            } else if (current.getChild() == null) {
                current = current.getParent();
                current.child = null;
            } else {
                current.getParent().child = current.getChild();
                current = current.getParent();
            }
            size--;
        }
    }
}
