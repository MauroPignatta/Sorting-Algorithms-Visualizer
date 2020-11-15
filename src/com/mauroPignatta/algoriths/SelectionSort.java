package com.mauroPignatta.algoriths;

import java.awt.*;

public class SelectionSort extends SortingAlgorithm {

    private int i = 0;
    private int j = 1;
    private int min_idx = 0;

    public SelectionSort(int[] array) {
        super(array);
    }

    public SelectionSort(int[] array, boolean desc) {
        super(array, desc);
    }

    @Override
    public void iterate() {
        if(!start)
            start();

        if (i < size - 1)
        {
            if(j < size){
                if(!desc && array[j] < array[min_idx] || desc && array[j] > array[min_idx]){
                    min_idx = j;
                }
                j++;
            } else {
                swap(i , min_idx);
                i ++;
                min_idx = i;
                j = i + 1;
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
