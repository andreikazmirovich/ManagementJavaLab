import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public JButton next;
    public JButton previous;
    public JLabel text = new JLabel();
    public int page = 2;
    private FileService fileService;

    public GUI() {
        setLayout(null);
        setSize(420, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createButtons();

        this.fileService = new FileService("src/main/java/resources/text.txt");

        this.setText(this.fileService.getPartText(0));
        this.text.setBounds(10, 10, this.text.getPreferredSize().width, this.text.getPreferredSize().height);
        add(this.text);

        setVisible(true);
    }

    private void createButtons() {
        this.next = new JButton("Next");
        this.previous = new JButton("Previous");
        this.next.setBounds(215,320,90,30);
        this.previous.setBounds(115,320,90,30);
        this.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage();
            }
        });
        this.previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousPage();
            }
        });
        add(this.next);
        add(this.previous);
    }

    private void setText(String text) {
        this.text.setText(String.format("<html><div WIDTH=%d>%s</div></html>", 350, text));
    }

    public void nextPage() {
        this.page++;
        System.out.println(this.page);
        this.setText(this.fileService.getPartText(this.page));
    }

    public void previousPage() {
        this.page--;
        this.setText(this.fileService.getPartText(this.page));
    }

}
