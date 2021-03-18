import java.util.Scanner;

public class Teacher extends Person {

    private Integer wage;

    public void setWage(Integer wage) {
        if (wage < 1000) {
            this.wage = 1000;
        } else if (wage > 70000) {
            this.wage = 70000;
        } else {
            this.wage = wage;
        }
    }

    @Override
    public void input() {

        super.input();

        Scanner in = new Scanner(System.in);


        boolean isComplete = false;
        while (!isComplete) {

            System.out.print("Enter teacher wage, whole numbers in the range: (1000 - 70000): ");

            if (in.hasNextInt()) {
                setWage(in.nextInt());
                isComplete = true;
            } else {
                System.out.println("Incorrect input: wage needs to contain only numbers");
                isComplete = false;
                in.next();
            }
        }

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", wage=" + wage +
                '}';
    }
}
