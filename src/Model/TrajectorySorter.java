package Model;

import java.util.ArrayList;
import java.util.Comparator;

public class TrajectorySorter {
    private final Trajectory trajectory;

    public TrajectorySorter(Trajectory trajectory) {
        this.trajectory = new Trajectory(trajectory);
    }

    public Trajectory sortByTime() {
        ArrayList<Point> points = new ArrayList<>(trajectory.getPoints());
        Trajectory sortedTrajectory = new Trajectory(trajectory);
        sortedTrajectory.clear();
        points.sort(new TimeComparator());
        sortedTrajectory.setPoints(points);
        return sortedTrajectory;
    }

    private static class TimeComparator implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            return o1.getTime().compareTo(o2.getTime());
        }
    }
}
