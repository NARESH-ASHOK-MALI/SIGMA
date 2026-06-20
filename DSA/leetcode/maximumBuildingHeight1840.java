// You want to build n new buildings in a city. The new buildings will be built in a line and are labeled from 1 to n.

// However, there are city restrictions on the heights of the new buildings:

// The height of each building must be a non-negative integer.
// The height of the first building must be 0.
// The height difference between any two adjacent buildings cannot exceed 1.
// Additionally, there are city restrictions on the maximum height of specific buildings. These restrictions are given as a 2D integer array restrictions where restrictions[i] = [idi, maxHeighti] indicates that building idi must have a height less than or equal to maxHeighti.

// It is guaranteed that each building will appear at most once in restrictions, and building 1 will not be in restrictions.

// Return the maximum possible height of the tallest building.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class maximumBuildingHeight1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> buildings = new ArrayList<>();
        buildings.add(new int[]{1, 0});

        for (int[] restriction : restrictions) {
            buildings.add(new int[]{restriction[0], restriction[1]});
        }
        buildings.add(new int[]{n, n - 1});

        Collections.sort(buildings, (left, right) -> Integer.compare(left[0], right[0]));

        for (int i = 1; i < buildings.size(); i++) {
            long allowed = (long) buildings.get(i - 1)[1] + (buildings.get(i)[0] - buildings.get(i - 1)[0]);
            if (buildings.get(i)[1] > allowed) {
                buildings.get(i)[1] = (int) allowed;
            }
        }

        for (int i = buildings.size() - 2; i >= 0; i--) {
            long allowed = (long) buildings.get(i + 1)[1] + (buildings.get(i + 1)[0] - buildings.get(i)[0]);
            if (buildings.get(i)[1] > allowed) {
                buildings.get(i)[1] = (int) allowed;
            }
        }

        long answer = 0;
        for (int i = 1; i < buildings.size(); i++) {
            long leftIndex = buildings.get(i - 1)[0];
            long leftHeight = buildings.get(i - 1)[1];
            long rightIndex = buildings.get(i)[0];
            long rightHeight = buildings.get(i)[1];
            long distance = rightIndex - leftIndex;
            long peak = Math.max(leftHeight, rightHeight) + (distance - Math.abs(leftHeight - rightHeight)) / 2;
            answer = Math.max(answer, peak);
        }

        return (int) answer;
    }
}