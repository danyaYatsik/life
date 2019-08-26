package org.yatsiko.life.io;

import java.io.IOException;

public interface Writer {

    void write(boolean[][] matrix) throws IOException;
}
