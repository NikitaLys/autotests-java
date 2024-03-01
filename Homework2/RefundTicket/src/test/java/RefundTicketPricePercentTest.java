import jdk.jfr.Name;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RefundTicketPricePercentTest {
    private static final Logger logger = LoggerFactory.getLogger(RefundTicketPricePercentTest.class);

    public Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        if (wasConcertCancelled && wasConcertRescheduled) return 100;
        if (hoursBeforeConcert > 240) return 100;
        if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if (hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }

    @Test
    @Name("100% refund")
    public void testFullRefund() {
        int expectedResult = 100;
        String[][] testCases = {
                {"11 days before concert refund", "264", "false", "false"},
                {"more than 10 days before concert refund", "241", "false", "false"},
                {"Canceled concert refund", "0", "true", "false"},
                {"Rescheduled concert refund", "0", "true", "true"}
        };

        for (String[] testCase : testCases) {
            String description = testCase[0];
            int actualResult = getRefundTicketPricePercent(
                    Integer.parseInt(testCase[1]),
                    Boolean.parseBoolean(testCase[2]),
                    Boolean.parseBoolean(testCase[3]));

            try {
                Assert.assertEquals(description, expectedResult, actualResult);
            } catch (AssertionError e) {
                logger.error("Assertion failed for '{}':{}", description, e.toString());
            }
        }
    }

    @Test
    @Name("50% refund")
    public void testHalfRefund() {
        int expectedResult = 50;
        String[][] testCases = {
                {"10 days before concert refund", "240", "false", "false"},
                {"6 days before concert refund", "144", "false", "false"}
        };
        for (String[] testCase : testCases) {
            String description = testCase[0];
            int actualResult = getRefundTicketPricePercent(
                    Integer.parseInt(testCase[1]),
                    Boolean.parseBoolean(testCase[2]),
                    Boolean.parseBoolean(testCase[3]));

            try {
                Assert.assertEquals(description, expectedResult, actualResult);
            } catch (AssertionError e) {
                logger.error("Assertion failed for '{}':{}", description, e.toString());
            }
        }
    }

    @Test
    @Name("30% refund")
    public void testThirdRefund() {
        int expectedResult = 30;
        String[][] testCases = {
                {"5 days before concert refund", "120", "false", "false"},
                {"more than 3 days before concert refund", "73", "false", "false"}
        };
        for (String[] testCase : testCases) {
            String description = testCase[0];
            int actualResult = getRefundTicketPricePercent(
                    Integer.parseInt(testCase[1]),
                    Boolean.parseBoolean(testCase[2]),
                    Boolean.parseBoolean(testCase[3]));

            try {
                Assert.assertEquals(description, expectedResult, actualResult);
            } catch (AssertionError e) {
                logger.error("Assertion failed for '{}':{}", description, e.toString());
            }
        }

    }

    @Test
    @Name("0% refund")
    public void testZeroRefund() {
        int expectedResult = 0;
        String[][] testCases = {
                {"72 hours before concert refund", "72", "false", "false"},
                {"0 hours before concert refund", "0", "false", "false"}
        };
        for (String[] testCase : testCases) {
            String description = testCase[0];
            int actualResult = getRefundTicketPricePercent(
                    Integer.parseInt(testCase[1]),
                    Boolean.parseBoolean(testCase[2]),
                    Boolean.parseBoolean(testCase[3]));

            try {
                Assert.assertEquals(description, expectedResult, actualResult);
            } catch (AssertionError e) {
                logger.error("Assertion failed for '{}':{}", description, e.toString());
            }
        }
    }
}
