package com.mauroPignatta.algoriths;

import com.mauroPignatta.Visualizer;

import java.awt.*;

public class InsertionSort extends SortingAlgorithm {

    private int i, j, key;
    private boolean swapped;

    public InsertionSort(int[] array, boolean desc) {
        super(array, desc);
        i = 1;
        j = 0;
        key = array[i];
    }

    public InsertionSort(int[] array) {
        this(array, false);
    }

    @Override
    public void iterate() {
        if(!start)
            start();

        if(i < size){

            if(!swapped){
                key = array[i];
                j = i - 1;
            }

            if(j >= 0 && (!desc && array[j] < key || desc && array[j] > key )){
                array[j + 1] = array[j];
                j--;
                swapped = true;
                swaps++;
            } else if(swapped){
                array[j+1] = key;
                swapped = false;
            } else {
                i++;
            }
        } else {
            finish();
        }
    }

    @Override
    public void render(Graphics2D g) {
        drawArray(g, i ,j);
    }
}
