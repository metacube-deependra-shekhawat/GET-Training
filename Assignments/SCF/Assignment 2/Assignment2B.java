// The objective of this assignment is to design FCFS(First Come First Serve) algorithm based job scheduling program

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment2B {
    public static void main(String[] args) {
        int[][] tasks = {{6, 20},{0, 10},  {60, 10}, {110, 5}};
        Arrays.sort(tasks,(x,y) -> Integer.compare(x[0], y[0]));
        int currentTime = 0;
        ArrayList<Integer> completionTimes = new ArrayList<>();
        ArrayList<Integer> waitingTimes = new ArrayList<>();
        ArrayList<Integer> turnAroundTimes = new ArrayList<>();

        for (int[] task : tasks) {
            int startingTimeForProcess = Math.max(currentTime, task[0]);
            int endingTimeForProcess = startingTimeForProcess + task[1];
            waitingTimes.add(Math.max(0, currentTime - task[0]));
            completionTimes.add(endingTimeForProcess);
            turnAroundTimes.add(endingTimeForProcess - task[0]);
            currentTime = endingTimeForProcess;
        }

        System.out.println("The completion time for each process is:- ");
        for (int completionTime : completionTimes) {
            System.out.print(completionTime + " ");
        }
        System.out.println();

        System.out.println("The turnaround time for each process is:- ");
        for (int turnAroundTime : turnAroundTimes) {
            System.out.print(turnAroundTime + " ");
        }
        System.out.println();

        System.out.println("The waiting time for each process is:- ");
        for (int waitingTime : waitingTimes) {
            System.out.print(waitingTime + " ");
        }
        System.out.println();

        int totalWaitingTime = waitingTimes.stream().mapToInt(Integer::intValue).sum();
        int averageWaitingTime = totalWaitingTime / tasks.length;
        System.out.println("The average waiting time for all the processes is:- ");
        System.out.println(averageWaitingTime);

        System.out.println("The longest waiting time for any process is:- ");
        int maxWaitingPeriod = waitingTimes.stream().max(Integer::compare).orElse(0);
        System.out.println(maxWaitingPeriod);
    }
}