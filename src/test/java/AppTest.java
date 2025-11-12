import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testAdd() {
        App app = new App();
        assertEquals(5, app.add(2, 3), "2 + 3 should be 5");
    }

    @Test
    public void testMultiply() {
        App app = new App();
        assertEquals(6, app.multiply(2, 3), "2 * 3 should be 6");
    }
}