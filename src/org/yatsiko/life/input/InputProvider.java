package org.yatsiko.life.input;

import java.awt.*;

public interface InputProvider {

    byte[][] getMatrix();
    Dimension getSceneDimension();
    int getIterationsQuantity();

}
