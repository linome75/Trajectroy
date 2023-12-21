package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrajectorySorterTest {

    Trajectory sortedTrajectory = new Trajectory("src\\Source\\traject1.txt");
    Trajectory unsortedTrajectory = new Trajectory("src\\Source\\traject2.txt");

    @Test
    void sortByTime() {
        TrajectorySorter sorter = new TrajectorySorter(unsortedTrajectory);
        Trajectory result = sorter.sortByTime();
        Assertions.assertEquals(sortedTrajectory, result);
    }
}