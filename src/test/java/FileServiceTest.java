import org.junit.Test;

import static org.junit.Assert.*;

public class FileServiceTest {

    @Test
    public void checkIfPathIsUpdated() {
        String expectedPath = "src/main/java/resources/text.txt";
        FileService fs = new FileService(expectedPath);
        assertEquals(expectedPath, fs.path);
    }

    @Test
    public void checkIfTextExists() {
        FileService fs = new FileService("src/main/java/resources/text.txt");
        assertTrue(fs.fullText.length() > 0);
    }
}