package test.java;
import org.junit.jupiter.api.Test;

import main.java.SafeInputObj;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class SafeInputObjTest {

    @Test
    public void testGetNonZeroLengthString() {
        Scanner scanner = new Scanner("Hello\n");
        SafeInputObj safeInput = new SafeInputObj(scanner);
        assertEquals("Hello", safeInput.getNonZeroLengthString("Enter a string"));
    }

    @Test
    public void testGetInt() {
        Scanner scanner = new Scanner("10\n");
        SafeInputObj safeInput = new SafeInputObj(scanner);
        assertEquals(10, safeInput.getInt("Enter an integer"));
    }
}
