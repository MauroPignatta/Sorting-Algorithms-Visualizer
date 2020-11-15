package com.mauroPignatta.algoriths;

import java.awt.*;

public class BubbleSort extends SortingAlgorithm {

    private int i = 0;
    private int j = 0;

    public BubbleSort(int[] array) {
        super(array);
    }

    public BubbleSort(int[] array, boolean desc) {
        super(array, desc);
    }

    @Override
    public void iterate() {
        if(!start){
            start();
        }

        if(i < size - 1){
            if (j < size - i - 1){
                if( !desc && array[j] > array[j + 1] ) {
                    swap(j , j + 1);
                } else if( desc && array[j] < array[j + 1] ){
                    swap(j, j + 1);
                }
                j++;
            } else {
                j = 0;
                i++;
            }
        } else {
            finish();
        }
    }

    public void render(Graphics2D g) {
        drawArray(g, i, j);
    }

}
