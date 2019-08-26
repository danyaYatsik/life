package org.yatsiko.life.io;

import java.awt.*;

public interface Reader {

    long getDelay();
    boolean[][] getMatrix();
    Dimension getSceneDimension();
    int getIterationsQuantity();

}
