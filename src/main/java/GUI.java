package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public JButton next;
    public JButton previous;
    public JLabel text = new JLabel();
    private int page = 0;
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
        this.next = new JButton(">");
        this.previous = new JButton("<");
        this.next.setBounds(215,320,50,30);
        this.previous.setBounds(155,320,50,30);
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

    private void nextPage() {
        this.page++;
        System.out.println(this.page);
        this.setText(this.fileService.getPartText(this.page));
    }

    private void previousPage() {
        this.page--;
        this.setText(this.fileService.getPartText(this.page));
    }

}
