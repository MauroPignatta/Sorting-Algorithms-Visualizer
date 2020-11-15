package com.mauroPignatta;

import com.mauroPignatta.config.Configuration;
import com.mauroPignatta.states.MenuState;
import com.mpJavaGame.loop.Loop;
import com.mpJavaGame.state.StateManager;
import com.mpJavaGame.ui.window.Window;

import java.awt.*;

public class Visualizer extends Loop {

    public static final int SIZE = Configuration.SIZE;
    public static final int WIDTH = Configuration.WIDTH;
    public static final int HEIGHT = Configuration.HEIGHT;

    public static final int UPS = Configuration.UPS;

    private int[] array;
    private Window window;

    public Visualizer(int UPS) {
        super(UPS);
    }

    @Override
    protected void setup() {
        array = new int[SIZE];
        window = new Window("Sorting Algorithms Visualizer", WIDTH, HEIGHT);
        window.resize(Configuration.RES_WIDTH, Configuration.RES_HEIGHT);
        capFPS(144);

        StateManager.getManager().addState(new MenuState());
        StateManager.getManager().setCurrentState(MenuState.NAME);
    }

    @Override
    protected void inputs() {
        StateManager.getManager().inputs();
    }

    @Override
    protected void update() {
        StateManager.getManager().update();
    }

    @Override
    protected void render() {
        Graphics2D g = window.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, window.getWidth(), window.getHeight());

        StateManager.getManager().render(g);

        window.endDrawingGraphics();
    }
}
