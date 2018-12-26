package pl.sarseth.advent.year2015.day03;

import pl.sarseth.advent.year2015.pl.sarseth.advent.utils.InputReader;

public class Year2015Day03 {

    public static void main(String[] args) {
        var input = InputReader.readInput("201503");
        var gridSize = 4136;

        var twoDimensionalGrid = new boolean[gridSize][gridSize];

        var santaPosX = gridSize / 2;
        var santaPosY = gridSize / 2;
        var roboPosX = gridSize / 2;
        var roboPosY = gridSize / 2;
        twoDimensionalGrid[santaPosX][santaPosY] = true;

        for (var i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                switch (input.charAt(i)) {
                    case '>':
                        santaPosX++;
                        break;
                    case '<':
                        santaPosX--;
                        break;
                    case '^':
                        santaPosY++;
                        break;
                    case 'v':
                        santaPosY--;
                        break;
                    default:
                        break;
                }
                twoDimensionalGrid[santaPosX][santaPosY] = true;
            } else {
                switch (input.charAt(i)) {
                    case '>':
                        roboPosX++;
                        break;
                    case '<':
                        roboPosX--;
                        break;
                    case '^':
                        roboPosY++;
                        break;
                    case 'v':
                        roboPosY--;
                        break;
                    default:
                        break;
                }
                twoDimensionalGrid[roboPosX][roboPosY] = true;
            }
        }

        var counter = 0;
        for (var x = 0; x < gridSize; x++) {
            for (var y = 0; y < gridSize; y++) {
                counter += twoDimensionalGrid[x][y] ? 1 : 0;
            }
        }
        System.out.println(counter);
    }

}
