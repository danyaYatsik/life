package org.yatsiko.life.io;

import java.awt.*;

public class MockReader implements Reader {
    private boolean[][] matrix = new boolean[70][70];

    @Override
    public long getDelay() {
        return 100;
    }

    @Override
    public boolean[][] getMatrix() {
        matrix[35][35] = true;
        matrix[36][36] = true;
        matrix[37][36] = true;
        matrix[37][35] = true;
        matrix[37][34] = true;
        return matrix;
    }

    @Override
    public Dimension getSceneDimension() {
        return new Dimension(matrix.length, matrix[0].length);
    }

    @Override
    public int getIterationsQuantity() {
        return 500;
    }
}
