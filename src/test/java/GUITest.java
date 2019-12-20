import org.junit.Test;
import static org.junit.Assert.*;

public class GUITest {
    @Test
    public void nextPageTest() {
        GUI gui = new GUI();
        int expectedPage = gui.page + 1;
        gui.nextPage();
        assertEquals(expectedPage, gui.page);
    }
    @Test
    public void previousPageTest() {
        GUI gui = new GUI();
        int expectedPage = gui.page - 1;
        gui.previousPage();
        assertEquals(expectedPage, gui.page);
    }
}