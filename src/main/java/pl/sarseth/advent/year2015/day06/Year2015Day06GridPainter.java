package pl.sarseth.advent.year2015.day06;

import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.PaintConsumer;

import java.awt.*;

class Year2015Day06GridPainter implements PaintConsumer {

    private int[][] grid;

    Year2015Day06GridPainter() {
        grid = new int[1000][1000];
    }

    void turnOn(int i, int j) {
        grid[i][j]++;
    }

    void turnOff(int i, int j) {
        grid[i][j]--;
        if (grid[i][j] < 0) {
            grid[i][j] = 0;
        }
    }

    void toggle(int i, int j) {
        grid[i][j] += 2;
    }

    void printHowManyLightsAreOn() {
        var counter = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                counter += grid[i][j];
            }
        }
        System.out.println(counter);
    }

    @Override
    public void accept(Graphics2D graphics2D) {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                Color color = new Color(grid[i][j] * 3, grid[i][j] * 3, grid[i][j]);
                graphics2D.setColor(color);
                graphics2D.drawRect(i, j, 1, 1);
            }
        }
    }

}
