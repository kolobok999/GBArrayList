import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GBArrayListTest {

    @Test
    void addTest() {
        GBList<Double> doubles = new GBArrayList<>();
        doubles.add(2.3);
        Assertions.assertEquals(2.3, doubles.get(0));
    }

    @Test
    void addNegativeTest() {
        GBList<Double> doubles = new GBArrayList<>();
        doubles.add(2.3);
        Assertions.assertNotEquals(2.2, doubles.get(0));
    }
}
