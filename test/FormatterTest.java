import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test1.Formatter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FormatterTest {
    private long inputNumber;
    private String expectedResult;
    private Formatter formatter;


    public FormatterTest(long inputNumber, String expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {-7, "error"},
                {0, "0 B"},
                {500, "500 B"},
                {2048, "2.0 KB"},
                {2000, "1.95 KB"},
                {2047, "2.00 KB"},//round kardan -> 1.999 KB
                {1048576, "1.0 MB"},
                {2097150, "2.0 MB"},//round -> 1.999
                {Long.MAX_VALUE, "8589934592.0 GB"}, //8589934591.999 because of string conversion
                {1073741824, "1.0 GB"},//1024 * 1024 + 1024
                {2000000000, "1.86 GB"}
        });
    }

    @Before
    public void initialize() {
        formatter = new Formatter();
    }

    @Test
    public void testFormatAsFileSize() {
        System.out.println("Parameterized Number is : " + inputNumber);
        assertEquals(expectedResult,
                formatter.formatAsFileSize(inputNumber));
    }
}