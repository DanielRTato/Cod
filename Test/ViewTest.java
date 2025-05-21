import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewTest {

    @Test
    public void test_displays_license_plate_and_speed_correctly() {
        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Test data
        String licensePlate = "1234ABC";
        Integer speed = 120;

        // Call the method
        boolean result = View.muestraVelocidad(licensePlate, speed);

        // Restore original System.out
        System.setOut(originalOut);

        // Verify the output contains the expected text
        String expectedOutput = "1234ABC: 120km/hr";
        assertEquals(expectedOutput, outputStream.toString().trim());

        // Verify the method returns true
        assertTrue(result);
    }

}
