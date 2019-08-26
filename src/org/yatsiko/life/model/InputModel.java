package org.yatsiko.life.model;

import java.util.Set;

public class InputModel {
    private int width;
    private int height;
    private long delay;
    private int iterationsQuantity;
    private Set<Cell> liveFields;

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIterationsQuantity() {
        return iterationsQuantity;
    }

    public void setIterationsQuantity(int iterationsQuantity) {
        this.iterationsQuantity = iterationsQuantity;
    }

    public Set<Cell> getLiveFields() {
        return liveFields;
    }

    public void setLiveFields(Set<Cell> liveFields) {
        this.liveFields = liveFields;
    }

}
