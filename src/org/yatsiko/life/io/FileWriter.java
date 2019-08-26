package org.yatsiko.life.io;

import java.io.File;
import java.io.IOException;

public class FileWriter implements Writer {

    private final File file;
    private java.io.FileWriter fileWriter;

    public FileWriter(File file) throws IOException {
        this.file = file;
        if (!file.exists()) file.createNewFile();
        if (!file.canWrite()) throw new IOException();
        fileWriter = new java.io.FileWriter(file);
    }

    @Override
    public void write(boolean[][] matrix) throws IOException {
        boolean[][] copy = new boolean[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copy[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if (copy[i][j]) fileWriter.append("X");
                else fileWriter.append("-");
            }
            fileWriter.append("\n");
            fileWriter.flush();
        }
        fileWriter.close();
    }
}
