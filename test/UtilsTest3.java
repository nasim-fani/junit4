import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test1.Utils;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(Parameterized.class)
public class UtilsTest3 {
    private String inputString1;
    private String inputString2;
    private String expectedResult;
    private Utils utils;


    public UtilsTest3(String inputString1, String inputString2, String expectedResult) {
        this.inputString1 = inputString1;
        this.inputString2 = inputString2;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection strings() {
        return Arrays.asList(new Object[][]{
                {null, null, ""},
                {null, "ab", ""},
                {"ab", null, ""},
                {"abc", "ab", "ab"},
                {"abcabc123aabc", "pabcd", "abc"},
                {"abc", "ee", ""},
                {"kaDss", "adk", "a"}
        });
    }

    @Before
    public void initialize() {
        utils = new Utils();
    }

    @Test
    public void testLongestCommonSubstring() {
        boolean thrown = false;
        try {
            System.out.println("Parameterized String is : " + inputString1 + " & " + inputString2);
            assertEquals(expectedResult,
                    utils.longestCommonSubstring(inputString1, inputString2));
        } catch (Exception e) {
            thrown = true;
            assertFalse("An exception is thrown: " + e.toString(), thrown);
        }


    }
}