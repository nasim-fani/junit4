import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test1.Utils;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class UtilsTest {
    private String inputString;
    private boolean expectedResult;
    private Utils utils;


    public UtilsTest(String inputString, boolean expectedResult) {
        this.inputString = inputString;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection strings() {
        return Arrays.asList(new Object[][]{
                {"@", false},
                {"a@", false},
                {"a@b", false},
                {"a", false},
                {"a.", false},
                {"a@a.", false},
                {".", false},
                {"@a.", false},
                {"", false},
                {"a..b@c.com", false},
                {"..b@c.com", false},
                {"b!@c.com", false},
                {"b@c.com!", false},
                {"a.a.b@c.com", true},
                {"a-a+b@c.com", true},
                {"a@a.com", true},

        });
    }

    @Before
    public void initialize() {
        utils = new Utils();
    }

    @Test
    public void testIsValidEmailAddress() {
        System.out.println("Parameterized String is : " + inputString);
        assertEquals(expectedResult,
                utils.isValidEmailAddress(inputString));
    }
}