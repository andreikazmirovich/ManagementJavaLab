import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileService {
    public String path;
    public String fullText;

    public FileService(String path) {
        this.path = path;
        this.getFullText();
    }

    public void getFullText() {
        String text = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.path));
            String str;
            while ((str = in.readLine()) != null) {
                text += str;
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        this.fullText = text;
    }

    public String getPartText(int page) {
        ArrayList<String> pages = new ArrayList<String>();
        for (int i = 0; i < (this.fullText.length() / 1000) + 1; i++) {
            if (i * 1000 + 1000 < this.fullText.length()) {
                pages.add(this.fullText.substring(i * 1000, i * 1000 + 1000));
            }
        }
        return pages.get(page);
    }
}
