import org.junit.Before;
import org.junit.Test;
import test1.Formatter;

import static org.junit.Assert.assertEquals;

public class FormatterTest2 {
    private long inputNumber;
    private String expectedResult;
    private Formatter formatter;


    @Before
    public void initialize() {

        formatter = new Formatter();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFormatAsTimeLength() {
        formatter.formatAsTimeLength(-300);
    }

    @Test
    public void testFormatAsTimeLength2() {
        assertEquals("200 milli seconds", formatter.formatAsTimeLength(200));
    }

    @Test
    public void testFormatAsTimeLength3() { //-> plural s
        assertEquals("1 milli second", formatter.formatAsTimeLength(1));
    }

    @Test
    public void testFormatAsTimeLength4() {
        assertEquals("3 seconds 0 milli second", formatter.formatAsTimeLength(3000));
    }

    @Test
    public void testFormatAsTimeLength5() {
        assertEquals("3 seconds 200 milli seconds", formatter.formatAsTimeLength(3200));
    }

    @Test
    public void testFormatAsTimeLength6() {
        assertEquals("6 minutes 0 seconds 200 milli seconds", formatter.formatAsTimeLength(360200));
    }

    @Test
    public void testFormatAsTimeLength7() {
        assertEquals("1 hour 0 minutes 0 seconds 200 milli seconds", formatter.formatAsTimeLength(60 * 1000 * 60 + 200));
    }

    @Test
    public void testFormatAsTimeLength8() {
        assertEquals("2562047788015 hour 12 minutes 55 seconds 807 milli seconds", formatter.formatAsTimeLength(Long.MAX_VALUE));
    }

}