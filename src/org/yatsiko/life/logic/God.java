package org.yatsiko.life.logic;

import org.yatsiko.life.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

public class God {

    private byte[][] data;
    private List<Pair> liveFields;
    private Set<Pair> toAdd;
    private Set<Pair> toRemove;

    public God(byte[][] data) {
        this.data = data;
        liveFields = countLiveFields();
        toAdd = new HashSet<>();
        toRemove = new HashSet<>();
    }

    public List<Pair> getLiveFields() {
        return liveFields;
    }

    public void nextGeneration() {
        for (int i = 0; i < liveFields.size(); i++) {
            int x = liveFields.get(i).getX();
            int y = liveFields.get(i).getY();
            visitNeighbours(() -> checkNeighbour(x, y));
            byte neighbours = 0;
            if (checkNeighbour(x + 1, y - 1)) neighbours++;
            if (checkNeighbour(x + 1, y)) neighbours++;
            if (checkNeighbour(x + 1, y + 1)) neighbours++;
            if (checkNeighbour(x, y + 1)) neighbours++;
            if (checkNeighbour(x, y - 1)) neighbours++;
            if (checkNeighbour(x - 1, y - 1)) neighbours++;
            if (checkNeighbour(x - 1, y)) neighbours++;
            if (checkNeighbour(x - 1, y + 1)) neighbours++;
            if (neighbours > 3 || neighbours < 2) {
                toRemove.add(liveFields.get(i));
            }
        }
        liveFields.removeAll(toRemove);
        liveFields.addAll(toAdd);
        toRemove.forEach(pair -> {
            data[pair.getX()][pair.getY()] = 0;
        });
        toAdd.forEach(pair -> {
            data[pair.getX()][pair.getY()] = 1;
        });
        toAdd.clear();
        toRemove.clear();
    }

    private boolean checkNeighbour(int x, int y) {
        if (data[x][y] == 1) {
            return true;
        } else {
            if (countNeighbours1(x, y) == 3) {
                toAdd.add(new Pair(x, y));
            }
            return false;
        }
    }


    private byte countNeighbours1(int x, int y) {
        byte neighbours = 0;
        if (data[x + 1][y - 1] == 1) neighbours++;
        if (data[x + 1][y] == 1) neighbours++;
        if (data[x + 1][y + 1] == 1) neighbours++;
        if (data[x][y + 1] == 1) neighbours++;
        if (data[x][y - 1] == 1) neighbours++;
        if (data[x - 1][y - 1] == 1) neighbours++;
        if (data[x - 1][y] == 1) neighbours++;
        if (data[x - 1][y + 1] == 1) neighbours++;
        return neighbours;
    }

    public List<Pair> countLiveFields() {
        List<Pair> liveFields = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 1) {
                    liveFields.add(new Pair(i, j));
                }
            }
        }
        return liveFields;
    }
}
