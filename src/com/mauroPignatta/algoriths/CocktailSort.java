package com.mauroPignatta.algoriths;

import java.awt.*;

public class CocktailSort extends SortingAlgorithm {

    private int i, j;
    private int begin;
    private int end = size - 1;

    boolean goingRight = true;

    private boolean swapped = false;

    public CocktailSort(int[] array) {
        super(array);
    }

    public CocktailSort(int[] array, boolean desc) {
        super(array, desc);
    }

    @Override
    public void iterate() {

        if(!start)
            start();

        if(goingRight){
            if(i < end){
                if(!desc && array[i + 1] < array[i] || desc && array[i + 1] > array[i]){
                    swapped = true;
                    swap(i, i + 1);
                }
                i++;
            } else if (!swapped) {
                finish();
            } else {
                swapped = false;
                end--;
                i = end;
                goingRight = false;
            }
        } else {
            if(i > begin){
                if(!desc && array[i] < array[i - 1] || desc && array[i] > array[i - 1]){
                    swapped = true;
                    swap(i, i - 1);
                }
                i--;
            } else if (!swapped) {
                finish();
            } else {
                swapped = false;
                begin++;
                i = begin;
                goingRight = true;
            }
        }


    }

    @Override
    public void render(Graphics2D g) {
        drawArray(g, i, i + (goingRight? 1 : -1)  );
    }
}
