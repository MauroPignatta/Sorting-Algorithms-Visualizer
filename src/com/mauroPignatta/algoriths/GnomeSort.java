package com.mauroPignatta.algoriths;

import java.awt.*;

public class GnomeSort extends SortingAlgorithm {

    private int i = 1;

    public GnomeSort(int[] array) {
        super(array);
    }

    public GnomeSort(int[] array, boolean desc) {
        super(array, desc);
    }

    @Override
    public void iterate() {

        if(!start)
            start();

        if(i < size){
            if(i == 0)
                i++;
            if(!desc && array[i - 1] < array[i] || desc && array[i - 1] > array[i]){
                i++;
            }else {
                swap(i, i - 1);
                i--;
            }
        } else {
            finish();
        }
    }

    @Override
    public void render(Graphics2D g) {
        drawArray(g, i, i -1);
    }
}
