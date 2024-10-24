// The objective of this assignment is to design FCFS(First Come First Serve) algorithm based job scheduling program

import java.util.ArrayList;
import java.util.Arrays;

class JobScheduler {
    private int[][] tasks;
    private int currentTime = 0;
    private int totalWaitingTime = 0;
    private int averageWaitingTime = 0;
    private ArrayList<Integer> completionTimes = new ArrayList<>();
    private ArrayList<Integer> waitingTimes = new ArrayList<>();
    private ArrayList<Integer> turnAroundTimes = new ArrayList<>();
    
    JobScheduler(int[][] tasks){
        this.tasks = tasks;
        Arrays.sort(this.tasks,(x,y) -> Integer.compare(x[0], y[0]));
        for (int[] task : this.tasks) {
            int startingTimeForProcess = Math.max(currentTime, task[0]);
            int endingTimeForProcess = startingTimeForProcess + task[1];
            waitingTimes.add(Math.max(0, currentTime - task[0]));
            completionTimes.add(endingTimeForProcess);
            turnAroundTimes.add(endingTimeForProcess - task[0]);
            currentTime = endingTimeForProcess;
        }
        averageWaitingTime = totalWaitingTime / tasks.length;
    }

    // This method will print the completion time for all the processes
    public void showCompletionTime(){
        System.out.println("The completion time for each process is:- ");
        for (int completionTime : completionTimes) {
            System.out.print(completionTime + " ");
        }
        System.out.println();
    }

    // This method will print the turnaround time for all the processes
    public void showTurnAroundTime(){
        System.out.println("The turnaround time for each process is:- ");
        for (int turnAroundTime : turnAroundTimes) {
            System.out.print(turnAroundTime + " ");
        }
        System.out.println();
    }    

    // This method will print the waiting time for all the processes
    public void showWaitingTime(){
        System.out.println("The waiting time for each process is:- ");
        for (int waitingTime : waitingTimes) {
            System.out.print(waitingTime + " ");
        }
        System.out.println();
    }    

    // This method will print the average waiting time for all the tasks
    public void showAverageWaitingTime(){
        System.out.println("The average waiting time for all the processes is:- ");
        System.out.println(averageWaitingTime);
    }

    // This method will print the longest waiting time for any process in the tasks
    public void showLongestWaitingTime(){
        System.out.println("The longest waiting time for any process is:- ");
        int maxWaitingPeriod = waitingTimes.stream().max(Integer::compare).orElse(0);
        System.out.println(maxWaitingPeriod);
    }

}        

public class Assignment2B {
    public static void main(String[] args) {
        int[][] tasks = {{0,10,},{6,20},{60,10},{110,5}};
        JobScheduler scheduler = new JobScheduler(tasks);
        scheduler.showAverageWaitingTime();
        scheduler.showCompletionTime();
        scheduler.showTurnAroundTime();
        scheduler.showWaitingTime();
        scheduler.showAverageWaitingTime();
        scheduler.showLongestWaitingTime();
    }
}