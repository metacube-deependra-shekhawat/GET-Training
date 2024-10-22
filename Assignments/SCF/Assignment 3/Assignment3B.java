import java.util.ArrayList;
import java.util.Scanner;

public class Assignment3B {
    int noOfStudents;
    ArrayList<Integer> marks = new ArrayList<>();
    public Assignment3B(int noOfStudents) {
        Scanner scn = new Scanner(System.in);
        this.noOfStudents = noOfStudents;
        for(int i = 0; i < noOfStudents; i++){
            System.out.print("Please enter the marks of Student no. " + (i+1) + ": ");
            int mark = scn.nextInt();
            while(mark > 100 || mark < 0){
                System.out.println("Not a valid grade, please enter a correct grade between 0 - 100");
                mark = scn.nextInt();
            }
            marks.add(mark);
        }
    }

    /**
     * This function will iterate over the marks of the students and and calculate the Average marks/grade
     * @return double
     */
    public double averageGrade(){
        int total = 0;
        for(int i = 0 ; i < noOfStudents; i++) total += marks.get(i);
        return (double)(total/noOfStudents);
    }

    /**
     *  This function will find out the maximum marks in the marks list and return the maximum achieved marks
     * @return int
     */
    public int maximumGrade(){
        int maximum = 0;
        for(int i = 0; i < noOfStudents; i++) maximum = Math.max(maximum, marks.get(i));
        return maximum;
    }

    /**
     *  This function will find out the minimum marks in the marks list and return the minimum achieved marks
     * @return int
     */
    public int minimumGrade(){
        int minimum = 100;
        for(int i = 0; i < noOfStudents; i++) minimum = Math.min(minimum, marks.get(i));
        return minimum;
    }

    /**
     * This method will iterate over the marks list and count the number of students whose marks are greater
     * than 40 and than will return the percentage of students who grades are greater than 40 (i.e: passed)
     * @return double
     */
    public double passingPercent(){
        int noOfPassedStudents = 0;
        for(int i = 0; i < noOfStudents; i++){
            if(marks.get(i) >= 40) noOfPassedStudents++;
        }
        double passingPercent = (double)((100 * noOfPassedStudents) / noOfStudents);
        return passingPercent;
    }
    public static void main(String[] args) {
        Assignment3B grades = new Assignment3B(10);              
        System.out.println(grades.maximumGrade());
        System.out.println(grades.minimumGrade());
        System.out.println(grades.averageGrade());
        System.out.println(grades.passingPercent());
    }
}