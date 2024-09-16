package main.java;
import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;

    // Constructor
    public SafeInputObj() {
        pipe = new Scanner(System.in);
    }

    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    // Methods
    public String getNonZeroLengthString(String prompt) {
        String retString = "";
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public int getInt(String prompt) {
        int retVal = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
            }
            pipe.nextLine(); // clear input buffer
        } while (!valid);
        return retVal;
    }

    // Add more methods as needed, such as getDouble, getRangedInt, etc.
}
