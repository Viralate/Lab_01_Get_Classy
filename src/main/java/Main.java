package main.java;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Main class to create, save, read, and display Person and Product data
public class Main {
    public static void main(String[] args) {
        // Creating and saving Person data
        Person person1 = new Person("John", "Doe", "12345", "Mr.", 1990);
        Person person2 = new Person("Jane", "Smith", "67890", "Ms.", 1985);

        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        savePersonDataToCSV(people, "person_data.csv");

        // Creating and saving Product data
        Product product1 = new Product("Laptop", "High-end gaming laptop", "001", 1200.99);
        Product product2 = new Product("Phone", "Latest smartphone", "002", 999.49);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        saveProductDataToCSV(products, "product_data.csv");

        // Reading and displaying Person data from file
        readAndDisplayPersonData("person_data.csv");

        // Reading and displaying Product data from file
        readAndDisplayProductData("product_data.csv");

        // Test SafeInputObj methods
        SafeInputObjTest.runSafeInputTest();
    }

    // Method to save Person data to a CSV file
    public static void savePersonDataToCSV(ArrayList<Person> people, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (Person person : people) {
                fileWriter.write(person.toCSV() + "\n");
            }
            System.out.println("Person data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing person data to file: " + e.getMessage());
        }
    }

    // Method to save Product data to a CSV file
    public static void saveProductDataToCSV(ArrayList<Product> products, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (Product product : products) {
                fileWriter.write(product.toCSV() + "\n");
            }
            System.out.println("Product data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing product data to file: " + e.getMessage());
        }
    }

    // Method to read and display Person data from a CSV file
    public static void readAndDisplayPersonData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Person data: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading person data from file: " + e.getMessage());
        }
    }

    // Method to read and display Product data from a CSV file
    public static void readAndDisplayProductData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Product data: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading product data from file: " + e.getMessage());
        }
    }
}

// Class to represent a Person
class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB; // Year of Birth

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }
}

// Class to represent a Product
class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String toCSV() {
        return name + "," + description + "," + ID + "," + cost;
    }
}

// Class for testing SafeInputObj methods
class SafeInputObj {
    private Scanner pipe;

    public SafeInputObj() {
        pipe = new Scanner(System.in);
    }

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
}

// Class to test SafeInputObj methods
class SafeInputObjTest {
    public static void runSafeInputTest() {
        SafeInputObj input = new SafeInputObj();
        String name = input.getNonZeroLengthString("Enter your name");
        System.out.println("You entered: " + name);

        int age = input.getInt("Enter your age");
        System.out.println("You entered: " + age);
    }
}
