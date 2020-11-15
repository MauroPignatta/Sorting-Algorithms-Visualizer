package com.mauroPignatta.states;

import com.mauroPignatta.algoriths.SortingAlgorithm;
import com.mpJavaGame.state.State;
import com.mpJavaGame.state.StateManager;

import java.awt.*;

public class SortingState extends State {

    public static String NAME = "Sorting";

    private SortingAlgorithm algorithm;

    public SortingState(SortingAlgorithm algorithm) {
        super(NAME);
        this.algorithm = algorithm;
    }

    @Override
    public void inputs() {}

    @Override
    public void update() {
        if(!algorithm.isDone())
            algorithm.iterate();
        else{
            StateManager.getManager().removeState(ResultState.NAME);
            StateManager.getManager().addState(new ResultState(algorithm.getResult()));
            StateManager.getManager().setCurrentState(ResultState.NAME);
        }
    }

    @Override
    public void render(Graphics2D g) {
        algorithm.render(g);
    }
}
