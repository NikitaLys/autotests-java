import jdk.jfr.Name;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class ScoreToMarkTest {
    private static final Logger logger =
            LoggerFactory.getLogger(ScoreToMarkTest.class);

    private String getMarkResult(Integer mark) {
        if (mark >= 0 && mark <= 35) return "2";
        if (mark > 35 && mark <= 56) return "3";
        if (mark > 56 && mark < 71) return "4";
        if (mark > 72 && mark < 100) return "5";
        return "no mark result";
    }

    @Test
    @DisplayName("Test mark 2")
    public void TestMarkTwo() {
        Integer[] testCases = {
                0, 34, 35
        };
        String expectedResult = "2";
        for (int testData : testCases) {
            String actualResult = getMarkResult(testData);
            try {
                Assert.assertEquals("Test failed with data: " + testData ,expectedResult, actualResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("Test mark 3")
    public void TestMarkThree() {
        Integer[] testCases = {
                36, 56
        };
        String expectedResult = "3";
        for (int testData : testCases) {
            String actualResult = getMarkResult(testData);
            try {
                Assert.assertEquals("Test failed with data: " + testData ,expectedResult, actualResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("Test mark 4")
    public void TestMarkFour() {
        Integer[] testCases = {
                57, 71
        };
        String expectedResult = "4";
        for (int testData : testCases) {
            String actualResult = getMarkResult(testData);
            try {
                Assert.assertEquals("Test failed with data: " + testData ,expectedResult, actualResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("Test mark 5")
    public void TestMarkFive() {
        Integer[] testCases = {
                72, 100
        };
        String expectedResult = "5";
        for (int testData : testCases) {
            String actualResult = getMarkResult(testData);
            try {
                Assert.assertEquals("Test failed with data: " + testData ,expectedResult, actualResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
