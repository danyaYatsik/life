package org.yatsiko.life.view;

import org.yatsiko.life.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Scene extends JFrame {

    private Dimension fieldDimension;
    private List<Pair> pairList;
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
        for (int i = 0; i < pairList.size(); i++) {
            g.fillRect(pairList.get(i).getX() * fieldDimension.height + leftInset,
                    pairList.get(i).getY() * fieldDimension.width + topInset,
                    fieldDimension.width,
                    fieldDimension.height);
        }
    }

    public void setPairList(List<Pair> pairList) {
        this.pairList = pairList;
        repaint();
    }
}
