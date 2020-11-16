package com.mauroPignatta.algoriths;

import com.mauroPignatta.Visualizer;
import com.sun.istack.internal.NotNull;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class SortingAlgorithm {

    protected int array[];
    protected int size;
    protected boolean desc;
    protected boolean start;
    protected boolean done;
    protected long startTimeMs;
    protected long finishTimeMs;
    protected long swaps;

    public SortingAlgorithm(@NotNull int[] array) {
        this.array = array;
        this.size = array.length;
    }

    public SortingAlgorithm(@NotNull int[] array, boolean desc) {
        this(array);
        this.desc = desc;
    }

    public float getCompletionTime() {
        float completion = (finishTimeMs - startTimeMs) / 100f;
        return completion / 10f + completion % 10f / 10f;
    }

    public boolean isDone() {
        return done;
    }

    protected void start(){
        startTimeMs = System.currentTimeMillis();
        start = true;
    }

    protected void finish(){
        finishTimeMs = System.currentTimeMillis();
        done = true;
    }

    protected void swap(int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
        swaps++;
    }

    public abstract void iterate();

    public abstract void render(Graphics2D g);

    public void saveInFile(String filePath){
        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("[SIZE = "+ size +"]\n" +
                    "[SORT = "+ getClass().getSimpleName() +"]\n"+
                    "\n[DATA]\n"
            );
            for(int number : array){
                writer.write("" + number + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getArraySize() {
        return size;
    }

    public SortResult getResult(){

        if(!isDone())
            return null;

        SortResult results = new SortResult();

        results.setAlgorithm(getClass().getSimpleName());
        results.setArraySize(size);
        results.setTimeSpent(getCompletionTime());
        results.setTotalSwaps(swaps);
        results.setIterationsPerSecond(Visualizer.UPS);

        return results;
    }

    protected void drawArray(Graphics2D g, int i, int j){
        for(int x = 0; x < size; ++x){
            int height = array[x];

            if(x == j || isDone()){
                g.setColor(Color.GREEN);
            } else if(x == i){
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }

            g.fillRect(x, Visualizer.HEIGHT - height, 1, height);
        }
    }

}
