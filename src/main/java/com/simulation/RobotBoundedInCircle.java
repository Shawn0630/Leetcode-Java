package com.simulation;

public class RobotBoundedInCircle {
    // https://leetcode.com/problems/robot-bounded-in-circle/discuss/731267/Easy-JAVA-Accepted-Solution
    // https://leetcode.com/problems/robot-bounded-in-circle/discuss/1676710/Well-Detailed-Explaination-JAVA-C%2B%2B-oror-Easy-for-mind-to-Accept-it
    public boolean isRobotBounded(String instructions) {
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int i = 0;
        int x = 0;
        int y = 0;

        for(int s = 0; s < instructions.length(); s++){
            if(instructions.charAt(s) == 'L'){
                i = (i + 1) % 4;
            }
            else if(instructions.charAt(s) == 'R'){
                i = (i + 3) % 4;
            }
            else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        return x == 0 && y == 0 || i != 0;
    }
}
