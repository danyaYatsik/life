package org.yatsiko.life.io;

import com.google.gson.Gson;
import org.yatsiko.life.model.Cell;
import org.yatsiko.life.model.InputModel;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*input example:
{
    width: 100,
    height: 70,
    iterationsQuantity: 1000,
    liveFields: [
        {x: 35, y: 35},
        {x: 36, y: 36},
        {x: 37, y: 36},
        {x: 37, y: 35},
        {x: 37, y: 34}
    ]
}
*/

public class JsonReader implements Reader {

    private final InputModel inputModel;

    public JsonReader(File file) throws IOException {
        if (!file.canRead()) throw new IOException();
        inputModel = new Gson().fromJson(new FileReader(file), InputModel.class);
    }

    @Override
    public boolean[][] getMatrix() {
        boolean[][] matrix = new boolean[inputModel.getWidth()][inputModel.getHeight()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (inputModel.getLiveFields().contains(new Cell(i, j))) {
                    matrix[i][j] = true;
                } else {
                    matrix[i][j] = false;
                }
            }
        }
        return matrix;
    }

    @Override
    public long getDelay() {
        return inputModel.getDelay();
    }

    @Override
    public Dimension getSceneDimension() {
        return new Dimension(inputModel.getWidth(), inputModel.getHeight());
    }

    @Override
    public int getIterationsQuantity() {
        return inputModel.getIterationsQuantity();
    }
}
