
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {

    public static Scanner in = new Scanner(System.in);

     private final ArrayList<Score> scores = new ArrayList<>();

    public ArrayList<Score> getScores() {
        return scores;
    }

    public void studentScoreMenu() {
        boolean goToMainMenu = false;
        while (!goToMainMenu) {
            System.out.println("\n|-----------------------------------------|\n" +
                                 "| Type the letter with the needed option: |\n" +
                                 "| a) Show All Scores                      |\n" +
                                 "| b) Insert a New Score                   |\n" +
                                 "| c) Show Average Score                   |\n" +
                                 "| d) Return to the Main Menu              |\n" +
                                 "|-----------------------------------------|\n");
            char c = in.next().toLowerCase().charAt(0);

            switch (c) {
                case 'a':
                    showAllScores();
                    break;
                case 'b':
                    setScore();
                    break;
                case 'c':
                    if (getAverageScore() == null) {
                        System.out.println("No scores for student " + this.firstName + " " + this.lastName);
                    } else {
                        System.out.println("Average score: " + getAverageScore());
                    }
                    break;
                case 'd':
                    goToMainMenu = true;
                    break;
                default:
                    System.out.println("Wrong input. pleas type again");
                    break;
            }

        }
    }

    private void showAllScores() {
        if (scores.size() == 0)
            System.out.println("No scores for student " + this.firstName + " " + this.lastName);
        scores.forEach(System.out::println);
    }

    private void setScore() {
        System.out.println("Enter course name: ");
        String course = in.next();
        int value;
        while (true) {
            System.out.println("Enter course mark, whole numbers in the range: (0 - 100): ");
            if (in.hasNextInt()) {
                value = in.nextInt();
                break;
            } else {
                System.out.println("Wrong input, Pleas type again");
                in.next();
            }
        }
        scores.add(new Score(course, value));
    }

    public Integer getAverageScore() {
        Integer sumGrades = 0;
        for (Score score : scores) {
            sumGrades += score.getValue();
        }
        if (scores.size() == 0) {
            return null;
        }
        return sumGrades / scores.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", averageScore=" + getAverageScore() +
                '}';
    }
}
