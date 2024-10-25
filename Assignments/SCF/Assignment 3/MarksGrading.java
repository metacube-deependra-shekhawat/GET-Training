import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MarksGrading {
    int noOfStudents;
    ArrayList<Integer> marks = new ArrayList<>();

    /**
     * Constructor for the class which take an integer as input and then takes grades input from console
     * and store them into an ArrayList
     * @param noOfStudents
     */
    MarksGrading(int noOfStudents) {
        Scanner scn = new Scanner(System.in);
        this.noOfStudents = noOfStudents;
        for(int i = 0; i < noOfStudents; i++){
            int mark;
            while(true){
                try {
                    System.out.print("Please enter the marks of Student no. " + (i+1) + ": ");
                    mark = scn.nextInt();
                    if(mark < 0 || mark > 100){
                        throw new Exception();
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Not a valid input type");
                    scn.nextLine();
                } catch (Exception e) {
                    System.out.println("Not a valid grade, please enter a correct grade between 0 - 100");
                }
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
        double temp = ((double)total/noOfStudents);
        double roundOff = Math.round(temp * 100.0) / 100.0;
        return roundOff;
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
        double passingPercent = ((100 * (double)noOfPassedStudents) / noOfStudents);
        double roundOff = Math.round(passingPercent * 100.0) / 100.0;
        return roundOff;
    }
    public static void main(String[] args) {
        int n = 0;
        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter the number of students: ");
        n = scn.nextInt();
        MarksGrading grades = new MarksGrading(n);              
        System.out.println(grades.maximumGrade());
        System.out.println(grades.minimumGrade());
        System.out.println(grades.averageGrade());
        System.out.println(grades.passingPercent());
    }
}