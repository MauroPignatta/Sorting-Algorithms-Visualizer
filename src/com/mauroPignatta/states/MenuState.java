package com.mauroPignatta.states;

import com.mauroPignatta.algoriths.*;
import com.mauroPignatta.config.Configuration;
import com.mpJavaGame.state.State;
import com.mpJavaGame.state.StateManager;
import com.mpJavaGame.ui.objects.TextButton;
import com.mpJavaGame.ui.objects.UIButton;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.mauroPignatta.Visualizer.*;

public class MenuState extends State {

    public static String NAME = "Menu";

    private List<UIButton> buttons;

    public MenuState() {
        super(NAME);
        initButtons();
    }

    private void initButtons() {
        int x = WIDTH / 2;
        int y = HEIGHT / 15;
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, WIDTH / 20);
        Color color = Color.white;
        Color hover = Color.green;
        hover.darker();

        UIButton bubbleSort = new TextButton(x, y, 0.5f,color, hover, font, "BubbleSort") {
            @Override
            protected void onClick() {
                start(new BubbleSort(initArray(), Configuration.DESC));
            }
        };

        UIButton IBubbleSort = new TextButton(x, y * 2, 0.5f, color, hover, font, "Improved Bubble Sort") {
            @Override
            protected void onClick() {
                start(new ImprovedBubbleSort(initArray(), Configuration.DESC));
            }
        };

        UIButton insertionSort = new TextButton(x, y * 3, 0.5f, color, hover, font, "Insertion Sort") {
            @Override
            protected void onClick() {
                start(new InsertionSort(initArray(), Configuration.DESC));
            }
        };

        UIButton selectionSort = new TextButton(x, y * 4, 0.5f, color, hover, font, "Selection Sort") {
            @Override
            protected void onClick() {
                start(new SelectionSort(initArray(), Configuration.DESC));
            }
        };

        UIButton gnomeSort = new TextButton(x, y * 5, 0.5f, color, hover, font, "Gnome Sort") {
            @Override
            protected void onClick() {
                start(new GnomeSort(initArray(), Configuration.DESC));
            }
        };

        UIButton cocktailSort = new TextButton(x, y * 6, 0.5f, color, hover, font, "Cocktail Sort") {
            @Override
            protected void onClick() {
                start(new CocktailSort(initArray(), Configuration.DESC));
            }
        };

        UIButton exit = new TextButton(x, HEIGHT - y, 0.5f, color, hover, font, "Exit") {
            @Override
            protected void onClick() {
                System.exit(0);
            }
        };


        buttons = new LinkedList<>();
        buttons.add(bubbleSort);
        buttons.add(IBubbleSort);
        buttons.add(insertionSort);
        buttons.add(selectionSort);
        buttons.add(gnomeSort);
        buttons.add(cocktailSort);
        buttons.add(exit);

    }

    @Override
    public void inputs() {}

    @Override
    public void update(double delta) {
        for(UIButton  button : buttons)
            button.update();
    }

    @Override
    public void render(Graphics2D g) {
        for(UIButton  button : buttons)
            button.render(g);
    }

    private int[] initArray() {
        List<Integer> list = new ArrayList<>();
        int[] array = new int[SIZE];

        for(int i = 0; i < SIZE; ++i){
            list.add(i * HEIGHT / SIZE + 1);
        }

        Collections.shuffle(list);
        for(int i = 0; i < SIZE; ++i){
            array[i] = list.get(i);
        }
        return array;
    }

    private void start(SortingAlgorithm sort){
        StateManager.getManager().removeState(SortingState.NAME);
        StateManager.getManager().addState(new SortingState(sort));
        StateManager.getManager().setCurrentState(SortingState.NAME);
    }
}
