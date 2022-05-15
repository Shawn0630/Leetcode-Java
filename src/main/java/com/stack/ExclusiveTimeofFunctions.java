package com.stack;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];

        Stack<Node> stack = new Stack<>();

        for(String log : logs) {
            String[] parm = log.split(":");
            int functionId = Integer.parseInt(parm[0]);
            boolean isStart = parm[1].equals("start");
            int timeStamp = Integer.parseInt(parm[2]);
            if (isStart) {
                if (!stack.empty()) {
                    ans[stack.peek().functionId] += timeStamp - stack.peek().startTimeStamp;
                }
                stack.push(new Node(functionId, timeStamp));
            } else {
                if (!stack.empty()) {
                    Node task = stack.pop();
                    ans[functionId] += timeStamp - task.startTimeStamp + 1;
                }
                if (!stack.empty()) {
                    stack.peek().startTimeStamp = timeStamp + 1;
                }
            }

        }


        return ans;
    }

    //  n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
    // 0 start 0 1 end 4   1 start 2
    // 0 start 0 5 start 6 5 end 8  2 start 2   2 end 3

    //      0    1       2       3       4       5       6
    //      0    0       1       1       1       1       0
    // stack  (0, 0) => (0, 0), (0, 1), (1, 2) => (0, 0), (0, 1), (0, 6) => (0, 0), (0, 1), (0, 6), (0, 6)
    // Use a stack to track the function id
    // prev to track the start time of the taskId on the top of the stack
    // timestamp is increasing...
    // https://leetcode.com/problems/exclusive-time-of-functions/discuss/1388410/Java-Stack-solution-with-explanation
    public int[] exclusiveTime2(int n, List<String> logs) {
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        Stack<Integer> stack = new Stack<>(); // taskId

        int prev = 0;
        for(String log : logs) {
            String[] array = log.split(":");
            int taskId = Integer.parseInt(array[0]);
            boolean isStart = "start".equals(array[1]); // 1: start, 0: end
            int timeStamp = Integer.parseInt(array[2]);

            if (isStart) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += timeStamp - prev;
                }
                stack.push(taskId);
                prev = timeStamp;
            } else {
                if (!stack.isEmpty()) {
                    ans[stack.pop()] += timeStamp - prev + 1;
                }
                prev = timeStamp + 1;
            }
        }

        return ans;
    }

    // n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]


    // 0        1       2       3       4       5       6
    // 0        0       1       1       1       1       0

    //=> [3, 4]
    //stack, 0 => 0, 1 => 0

    // ["0:start:0","1:start:2","1:end:5","0:end:6"]

    // stack  0  => 0, 1 => 0 =>
    // prev   0 =>  2 => 6 =>
    // 0        1
    // 2        4
    // https://leetcode.com/problems/exclusive-time-of-functions/discuss/153497/Java-solution-using-stack-wrapper-class-and-calculation-when-pop-element-from-the-stack.
    // push to stack on start only, pop at end, then substract the parent timestamp
    public int[] exclusiveTime3(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, 0);
        int prevTimeStamp = 0;

        for(String log : logs) {
            String[] array = log.split(":");
            int taskId = Integer.parseInt(array[0]);
            boolean isStart = array[1].equals("start");
            int timeStamp = Integer.parseInt(array[2]);

            if (isStart) {
                if (!stack.empty()) {
                    ans[stack.peek()] += (timeStamp - prevTimeStamp); // 2 - 0
                }
                stack.push(taskId);
                prevTimeStamp = timeStamp; // start time
            } else { // end
                int id = stack.pop();
                ans[id] += (timeStamp - prevTimeStamp + 1);
                prevTimeStamp = timeStamp + 1;
            }
        }

        return ans;
    }

    private class Node {
        int functionId;
        int startTimeStamp;

        public Node(int functionId, int startTimeStamp) {
            this.functionId = functionId;
            this.startTimeStamp = startTimeStamp;
        }
    }


    public static void main(String[] args) {
        ExclusiveTimeofFunctions exclusiveTimeofFunctions = new ExclusiveTimeofFunctions();
        exclusiveTimeofFunctions.exclusiveTime2(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
    }
}
