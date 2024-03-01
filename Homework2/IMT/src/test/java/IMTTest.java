import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Random;

public class IMTTest {
    @Test
    @DisplayName("Normal weight")
    public void testNormalWeight() {
        var actualResult = getIMTResult(180f, 75f);

        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    @DisplayName("Deficit IMT")
    public void testDeficitIMT() {
        var actualResult = getIMTResult(180f, 40f);

        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    @DisplayName("Not enough IMT")
    public void testNotEnoughIMT() {
        var actualResult = getIMTResult(190f, 70f);

        Assert.assertEquals("недостаточная масса тела", actualResult);
    }

    @Test
    @DisplayName("Overweight IMT")
    public void testOverweightIMT() {
        var actualResult = getIMTResult(190f,100f);

        Assert.assertEquals("избыточная масса тела", actualResult);
    }

    @Test
    @DisplayName("Zero height")
    public void testZeroHeight() {
        var actualResult = getIMTResult(0f, 100f);

        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    @DisplayName("Zero weight")
    public void testZeroWeight() {
        var actualResult = getIMTResult(190f, 0f);

        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    @DisplayName("Not correct height")
    public void testNotCorrectHeight(){
        var actualResult = getIMTResult(350f,100f);

        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    @DisplayName("Not correct weight")
    public void testNotCorrectWeight(){
        var actualResult = getIMTResult(150f,1001f);

        Assert.assertEquals("указан некорректный вес", actualResult);
    }


    private String getIMTResult(Float heightCm, Float weightKg) {

        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));

        String userResult = null;

        if (userIndex <= 16) {

            userResult = "выраженному дефициту массы тела";

        } else if (userIndex > 16 && userIndex < 19) {

            userResult = "недостаточной массе тела";

        } else if (userIndex > 19 && userIndex < 25) {

            userResult = "нормальной массе тела";

        } else if (userIndex > 25) {

            userResult = "избыточной массе тела";

        }

        if (heightCm.equals(0.0f)) userResult += "указан некорректный рост";

        return userResult;

    }

}
