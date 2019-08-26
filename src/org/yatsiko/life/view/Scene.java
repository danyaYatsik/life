package org.yatsiko.life.view;

import org.yatsiko.life.model.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Scene extends JFrame {

    private Dimension fieldDimension;
    private List<Cell> cellList;
    private int topInset;
    private int leftInset;

    public Scene(Dimension sceneDimension) throws HeadlessException {
        super("LIFE");
        fieldDimension = new Dimension(10, 10);
        topInset = 20;
        leftInset = -2;
        setSize(sceneDimension.width * fieldDimension.width,
                sceneDimension.height * fieldDimension.height);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < cellList.size(); i++) {
            g.fillRect(cellList.get(i).getX() * fieldDimension.height + leftInset,
                    cellList.get(i).getY() * fieldDimension.width + topInset,
                    fieldDimension.width,
                    fieldDimension.height);
        }
    }

    public void update(List<Cell> cellList) {
        this.cellList = cellList;
        repaint();
    }
}
