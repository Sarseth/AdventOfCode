package pl.sarseth.advent.year2015.pl.sarseth.advent.utils;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(int width, int height, PaintConsumer paintConsumer) {
        super("Advent");
        JPanel panel = new MyPanel(width, height, paintConsumer);

        add(panel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}