import java.util.*;

public class TestFindSafe {
    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(Arrays.asList(1,1,1,1,1));
        findSafeWalkThorughGrid3286 solver = new findSafeWalkThorughGrid3286();
        System.out.println(solver.canReachEnd(grid, 4));
    }
}
