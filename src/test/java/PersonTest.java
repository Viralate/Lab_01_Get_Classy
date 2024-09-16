package test.java;
import org.junit.jupiter.api.Test;

import main.java.Person;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testFullName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1990);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1990);
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1990);
        assertEquals(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - 1990, person.getAge());
    }

    @Test
    public void testToCSV() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1990);
        assertEquals("John,Doe,12345,Mr.,1990", person.toCSV());
    }

    @Test
    public void testToJSON() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1990);
        assertEquals("{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"ID\": \"12345\", \"title\": \"Mr.\", \"YOB\": 1990 }", person.toJSON());
    }

    @Test
    public void testToXML() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1990);
        assertEquals("<Person><firstName>John</firstName><lastName>Doe</lastName><ID>12345</ID><title>Mr.</title><YOB>1990</YOB></Person>", person.toXML());
    }
}
