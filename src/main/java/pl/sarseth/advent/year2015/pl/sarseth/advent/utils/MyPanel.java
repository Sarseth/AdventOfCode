package pl.sarseth.advent.year2015.pl.sarseth.advent.utils;

import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {

    private PaintConsumer paintConsumer;

    MyPanel(int width, int height, PaintConsumer consumer) {
        setPreferredSize(new Dimension(width, height));
        paintConsumer = consumer;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        paintConsumer.accept(g2d);
        repaint();
    }
}