package com.mauroPignatta.algoriths;

public class SortResult {

    private String algorithm;
    private float timeSpent;
    private int arraySize;
    private long totalSwaps;
    private long iterationsPerSecond;

    public long getIterationsPerSecond() {
        return iterationsPerSecond;
    }

    public void setIterationsPerSecond(long iterationsPerSecond) {
        this.iterationsPerSecond = iterationsPerSecond;
    }

    public long getTotalSwaps() {
        return totalSwaps;
    }

    public void setTotalSwaps(long totalSwaps) {
        this.totalSwaps = totalSwaps;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public float getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(float timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
}
