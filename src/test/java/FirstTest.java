import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTest {
    //throws IOException {
        // String[] testData = { "0975156900", "(097)5156900", "(097)515-69-00", "(097)51-56-900", "+380975156900",
        //         "+38 097 515 69 00" };
        //test1_isPhone();
        //test2_isPhone();
    //}

    public static boolean isPhone(String text) {
        String regex = "(?:\\+38)? ?(?:0\\d{2}|\\(0\\d{2}\\)) ?\\d{2}(?:\\d{3}|\\d[- ]\\d{2}[- ]|[ -]\\d{2}[ -]\\d)\\d{2}";
        return text.matches(regex);
    }

    @Test
    public static void test1_isPhone() {
        String testData = "0975156900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "Test Number_short");
    }
    @Test
    public static void test2_isPhone() {
        String testData = "asdaddasds";
        //String testData = "0975156900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test Abracadabra");
    }
    @Test
    public static void test3_isPhone() {
        //if special characters exist => fail
        String testData = "097515690.";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test Spec_char");
    }
    @Test
    public static void test4_isPhone() {
        //if number less then 10 characters => false
        String testData = "097515690";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test Less_10_char");
    }
    @Test
    public static void test5_isPhone() {
        //if number more then 10 characters => false
        String testData = "09751569000";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test More_10_char");
    }
    @Test
    public static void test6_isPhone() {
        String testData = "+38 097 51 56-900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "Test Number_long");
    }
}
