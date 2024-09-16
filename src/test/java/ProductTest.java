package test.java;
import org.junit.jupiter.api.Test;

import main.java.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testToCSV() {
        Product product = new Product("Laptop", "Gaming Laptop", "001", 1200.00);
        assertEquals("Laptop,Gaming Laptop,001,1200.0", product.toCSV());
    }

    @Test
    public void testToJSON() {
        Product product = new Product("Laptop", "Gaming Laptop", "001", 1200.00);
        assertEquals("{ \"name\": \"Laptop\", \"description\": \"Gaming Laptop\", \"ID\": \"001\", \"cost\": 1200.0 }", product.toJSON());
    }

    @Test
    public void testToXML() {
        Product product = new Product("Laptop", "Gaming Laptop", "001", 1200.00);
        assertEquals("<Product><name>Laptop</name><description>Gaming Laptop</description><ID>001</ID><cost>1200.0</cost></Product>", product.toXML());
    }
}
