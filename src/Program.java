
import java.util.ArrayList;
import java.util.Scanner;


public class Program {

    public static Scanner in = new Scanner(System.in);

    public static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        try{
            menu();
        } catch (Exception e){
            System.out.println("UNEXPECTED ERROR !!! \n" + e);
        }

    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        int option = 10;
        while (option != 0) {
            System.out.println("\n|=========================================|\n" +
                                 "| Type the number with the needed option: |\n" +
                                 "| 1) Add Teacher                          |\n" +
                                 "| 2) Add Student                          |\n" +
                                 "| 3) Show All People                      |\n" +
                                 "| 4) Show All Teachers                    |\n" +
                                 "| 5) Show All Students                    |\n" +
                                 "| 6) Show Teacher by ID                   |\n" +
                                 "| 7) Show Student by ID                   |\n" +
                                 "| 8) Show Students by Score Range         |\n" +
                                 "| 0) Quit                                 |\n" +
                                 "|=========================================|\n"
            );
            System.out.println();
            if (in.hasNextInt()) {
                option = in.nextInt();

                switch (option) {
                    case 0:
                        System.out.println("\nGOODBYE!");
                        break;
                    case 1:
                        addTeacher();
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        showAllPeople();
                        break;
                    case 4:
                        showAllTeachers();
                        break;
                    case 5:
                        showAllStudents();
                        break;
                    case 6:
                        showTeacherByID();
                        break;
                    case 7:
                        showStudentByID();
                        break;
                    case 8:
                        showStudentsByScoreRange();
                        break;
                    default:
                        System.out.println("\nWrong input. Pleas type a single digit (0-8)");
                        break;
                }
            } else {
                System.out.println("\nWrong input. Pleas type a single digit (0-8)");
                in.next();
            }
        }
    }


    private static void addTeacher() {
        Person t = new Teacher();
        t.input();
        people.add(t);
    }

    private static void addStudent() {
        Person s = new Student();
        s.input();
        people.add(s);
    }

    private static void showAllPeople() {
        people.forEach(System.out::println);
        if (people.size() == 0)
            System.out.println("There are no teachers nor students in the system.");
    }

    private static void showAllTeachers() {
//        for (int i = 0; i < people.size(); i++){
//            if(people.get(i) instanceof Teacher ){
//                System.out.println(people.get(i));
//            }
//        }
        int teacherCount = 0;
        for (Person person : people) {
            if (person instanceof Teacher) {
                System.out.println(person);
                teacherCount++;
            }
        }
        if (teacherCount == 0) System.out.println("There are no teachers in the system.");

    }

    private static void showAllStudents() {
        int studentCount = 0;
        for (Person person : people) {
            if (person instanceof Student) {
                System.out.println(person.toString());
                studentCount++;
            }
        }
        if (studentCount == 0) System.out.println("There are no students in the system.");
    }


    private static void showTeacherByID() {

        // Checking input to avoid InputMismatchException
        Integer teachersId;
        while (true) {
            System.out.println("\nType teachers id: ");
            if (in.hasNextInt()) {
                teachersId = in.nextInt();
                break;
            } else {
                System.out.println("Id can contain only numbers.");
                in.next();
            }
        }
        // Fetching values if they exist
        for (Person person : people) {
            if (person instanceof Teacher && (((Teacher) person).id.equals(teachersId))) {
                System.out.println(person);
                return;
            } else if (person instanceof Student && ((Student) person).id.equals(teachersId)) {
                System.out.println("\nNot a teacher");
                return;
            }
        }
        System.out.println("Doesn't exists");
    }

    private static void showStudentByID() {
        // Checking input
        Integer studentsId;
        while (true) {
            System.out.println("\nType students id: ");
            if (in.hasNextInt()) {
                studentsId = in.nextInt();
                break;
            } else {
                System.out.println("Id can contain only numbers.");
                in.next();
            }
        }
        // Fetching values if they exist
        for (Person person : people) {
            if (person instanceof Student && (((Student) person).id.equals(studentsId))) {
                System.out.println(person);

                // Opening a menu for students score manipulation
                ((Student) person).studentScoreMenu();

                return;
            } else if (person instanceof Teacher && ((Teacher) person).id.equals(studentsId)) {
                System.out.println("\nNot a student");
                return;
            }
        }
        System.out.println("Doesn't exists");
    }

    private static void showStudentsByScoreRange() {

        // Checking input to avoid InputMismatchException
        if (people.size() == 0) {
            System.out.println("There are no scores in the system.");
            return;
        }
        // Checking output to avoid nullPointerException
        int scoreCount = 0;
        for (Person person : people) {
            if (person instanceof Student) {
                if (((Student) person).getScores().size() > 0) scoreCount++;
            }
        }
        if (scoreCount == 0) {
            System.out.println("There are no scores in the system.");
            return;
        }
        // Make sure that maxScore >= minScore.
        int minScore = -2, maxScore = -1;
        boolean isComplete = false;
        while (!isComplete) {
            while (true) {
                System.out.println("\nType min score: ");
                if (in.hasNextInt()) {
                    minScore = in.nextInt();
                    if(minScore >= 0 && minScore <= 100){
                        break;
                    } else {
                        System.out.println("Score value can contain only whole numbers (0 - 100).");
                    }
                } else {
                    System.out.println("Score value can contain only whole numbers (0 - 100).");
                    in.next();
                }
            }
            while (true) {
                System.out.println("\nType max score: ");
                if (in.hasNextInt()) {
                    maxScore = in.nextInt();
                    if(maxScore >= 0 && maxScore <= 100){
                        break;
                    } else {
                        System.out.println("Score value can contain only whole numbers (0 - 100).");
                    }
                } else {
                    System.out.println("Score value can contain only numbers.");
                    in.next();
                }
            }
            if (maxScore >= minScore) {
                isComplete = true;
            } else {
                System.out.println("Max score must be greater then or equal to min score. Type again");
            }
        }


        // Fetching values if they exist
        int studentCount = 0;
        for (Object person : people) {
            if (person instanceof Student) {
                Integer averageScore = ((Student) person).getAverageScore();
                if (averageScore >= minScore && averageScore <= maxScore) {
                    System.out.println(person);
                    studentCount++;
                }
            }
            if (studentCount == 0) System.out.println("No student has an average score in that range");
        }
    }
}



