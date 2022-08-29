package aJan22.misc;

import java.util.Arrays;

public class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {

        int[][] dirs =  new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] pos = {0,0};
        int currDir = 0;

        char[] insArr =  instructions.toCharArray();
        int i = 0;
        while(i < insArr.length) {
            switch (insArr[i]) {
                case 'G':
                    pos[0] = pos[0] + dirs[currDir][0];
                    pos[1] = pos[1] + dirs[currDir][1];
                    break;
                case 'L':
                    currDir = currDir == 0 ? 3: currDir - 1;
                    break;
                case 'R':
                    currDir = currDir == 3 ? 0 : currDir + 1;
                    break;
            }
            i++;
        }

        // if not facing north or if back to square 0.
        return currDir != 0 || (pos[0] == 0 && pos[1] == 0);
    }


    public static void main(String[] args) {
        RobotBoundedInCircle rbc = new RobotBoundedInCircle();
        rbc.isRobotBounded("GGLLGG");

    }

}
