import java.util.Scanner;

public abstract class Person {

    public enum MaterialStatus {SINGLE, MARRIED, DIVORCED}

    protected Integer id;
    protected String firstName;
    protected String lastName;
    protected MaterialStatus status;


    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    public void input() {
        Scanner in = new Scanner(System.in);

        boolean isCompleted = false;
        while (!isCompleted) {

            System.out.print("Enter id number: ");
            if (in.hasNextInt()) {
                this.id = in.nextInt();
                isCompleted = true;
            } else {
                System.out.println("Incorrect input: id needs to contain only numbers");
                in.next();
            }
        }
        System.out.print("Enter first name: ");
        setFirstName(in.next());

        System.out.print("Enter last name: ");
        setLastName(in.next());


        boolean statusCompleted = false;
        while (!statusCompleted) {
            System.out.print("Enter material status (type \"s\" for single / \"m\" for married / \"d\" for divorced): ");
            String statusTemp = in.next().toLowerCase();

            switch (statusTemp) {
                case "s":
                    status = MaterialStatus.valueOf("SINGLE");
                    statusCompleted = true;
                    break;
                case "m":
                    status = MaterialStatus.valueOf("MARRIED");
                    statusCompleted = true;
                    break;
                case "d":
                    status = MaterialStatus.valueOf("DIVORCED");
                    statusCompleted = true;
                    break;
                default:
                    System.out.println("the status was typed incorrectly.");
                    break;
            }
        }

    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                '}';
    }


}
