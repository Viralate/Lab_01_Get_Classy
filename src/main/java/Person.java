package main.java;
public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB; // Year of Birth

    // Constructor
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public int getYOB() { return YOB; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setTitle(String title) { this.title = title; }

    // Methods
    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    public String toJSON() {
        return "{ \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"ID\": \"" + ID + "\", \"title\": \"" + title + "\", \"YOB\": " + YOB + " }";
    }

    public String toXML() {
        return "<Person><firstName>" + firstName + "</firstName><lastName>" + lastName + "</lastName><ID>" + ID + "</ID><title>" + title + "</title><YOB>" + YOB + "</YOB></Person>";
    }

    @Override
    public String toString() {
        return formalName() + " (" + YOB + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return YOB == person.YOB && firstName.equals(person.firstName) && lastName.equals(person.lastName) && ID.equals(person.ID) && title.equals(person.title);
    }
}
