package org.yatsiko.life.input;

import java.awt.*;

public class MockInputProvider implements InputProvider {
    private byte[][] matrix;

    @Override
    public byte[][] getMatrix() {
        matrix = new byte[70][70];
        matrix[35][35] = 1;
        matrix[36][36] = 1;
        matrix[37][36] = 1;
        matrix[37][35] = 1;
        matrix[37][34] = 1;
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
