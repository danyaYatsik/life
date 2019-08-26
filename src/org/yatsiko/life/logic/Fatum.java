package org.yatsiko.life.logic;

import org.yatsiko.life.model.Cell;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

public class Fatum {

    private boolean[][] matrix;
    private List<Cell> liveFields;
    private Set<Cell> toAdd;
    private Set<Cell> toRemove;

    public Fatum(boolean[][] matrix) {
        this.matrix = matrix;
        liveFields = countLiveFields();
        toAdd = new HashSet<>();
        toRemove = new HashSet<>();
    }

    public List<Cell> getLiveFields() {
        return liveFields;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void nextGeneration() {
        liveFields.forEach(pair -> {
            int x = pair.getX();
            int y = pair.getY();
            byte neighbours = visitNeighbours(this::checkNeighbour, x, y);
            if (neighbours > 3 || neighbours < 2) {
                toRemove.add(pair);
            }
        });
        liveFields.removeAll(toRemove);
        liveFields.addAll(toAdd);
        toRemove.forEach(pair -> {
            matrix[pair.getX()][pair.getY()] = false;
        });
        toAdd.forEach(pair -> {
            matrix[pair.getX()][pair.getY()] = true;
        });
        toAdd.clear();
        toRemove.clear();
    }

    private boolean checkNeighbour(int baseX, int baseY) {
        if (matrix[baseX][baseY] == true) {//Выглядит тупо, но мне кажется, так легче читать
            return true;
        } else {
            if (visitNeighbours((x, y) -> matrix[x][y] == true, baseX, baseY) == 3) {
                toAdd.add(new Cell(baseX, baseY));
            }
            return false;
        }
    }

    private byte visitNeighbours(BiPredicate<Integer, Integer> predicate, int x, int y) {
        byte neighbours = 0;
        if (x + 1 < matrix.length && y > 0)
            if (predicate.test(x + 1, y - 1))
                neighbours++;
        if (x + 1 < matrix.length)
            if (predicate.test(x + 1, y))
                neighbours++;
        if (x + 1 < matrix.length && y + 1 < matrix[0].length)
            if (predicate.test(x + 1, y + 1))
                neighbours++;
        if (y > 0)
            if (predicate.test(x, y - 1))
                neighbours++;
        if (y + 1 < matrix[0].length)
            if (predicate.test(x, y + 1))
                neighbours++;
        if (x > 0 && y > 0)
            if (predicate.test(x - 1, y - 1))
                neighbours++;
        if (x > 0)
            if (predicate.test(x - 1, y))
                neighbours++;
        if (x > 0 && y + 1 < matrix[0].length)
            if (predicate.test(x - 1, y + 1))
                neighbours++;
        return neighbours;
    }

    private List<Cell> countLiveFields() {
        List<Cell> liveFields = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == true) {
                    liveFields.add(new Cell(i, j));
                }
            }
        }
        return liveFields;
    }
}
