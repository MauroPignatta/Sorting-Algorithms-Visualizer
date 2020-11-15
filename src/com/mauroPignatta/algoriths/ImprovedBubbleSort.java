package com.mauroPignatta.algoriths;

import java.awt.*;

public class ImprovedBubbleSort extends SortingAlgorithm {

    private int i = 0;
    private int j = 0;
    private boolean swapped;

    public ImprovedBubbleSort(int[] array) {
        super(array);
    }

    public ImprovedBubbleSort(int[] array, boolean desc) {
        super(array, desc);
    }

    @Override
    public void iterate() {
        if(done){
            return;
        }

        if(!start){
            start();
        }

        if(i < size - 1){
            if (j < size - i - 1){
                if( !desc && array[j] > array[j + 1] ) {
                    swap(j , j + 1);
                    swapped = true;
                } else if( desc && array[j] < array[j + 1] ){
                    swap(j, j + 1);
                    swapped = true;
                }
                j++;
            } else if (!swapped) {
                finish();
            } else {
                j = 0;
                i++;
                swapped = false;
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
