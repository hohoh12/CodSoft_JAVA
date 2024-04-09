package guii;

import java.util.Scanner;
public class TASK2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //prompt the user to enter the number of subjects
        System.out.println("Enter the number of subjects");
        int subs = sc.nextInt();

        //prompt the user to enter marks out of 100
        System.out.println("Enter your marks out of 100 for subjects");
        float totalMarks =0;
        for(int  i = 0; i < subs; i++)
        {
            System.out.println("Enter the marks for Subject"+(i+1));
            float marks = sc.nextFloat();
            // TOTAL MARKS
            totalMarks += marks;
        }
        //AVERAGE PERCENTAGE
        float AP = totalMarks / subs;

        //GRADE CALCULATIONS
        String grade;//USED STRING BC IT ACCEPTS +
        if(AP >= 90.0){
            grade = "O";
        }
        else if(80 <= AP && AP < 89.99) {
            grade = "A+";
        }
        else if (70 <= AP && AP < 79.99){
            grade = "A";
        }
        else if (60 <= AP && AP < 69.99){
            grade = "B+";
        }
        else if (55 <= AP && AP < 59.99){
            grade = "B";
        }
        else if (50 <= AP && AP < 54.99){
            grade = "C+";
        }
        else if (45 <= AP && AP < 49.99){
            grade = "C";
        }
        else if (40 <= AP && AP < 44.99){
            grade = "D";
        }
        else {
            grade = "F";
        }

        //FINAL OUTPUT
        System.out.println("Your Total Marks are: "+totalMarks);
        System.out.println("Your Average Percentage is: "+AP+"%");
        System.out.println("Your Grade is: "+grade);

        //close the scanner
        sc.close();
    }
}
