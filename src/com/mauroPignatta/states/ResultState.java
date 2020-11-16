package com.mauroPignatta.states;

import com.mauroPignatta.algoriths.SortResult;
import com.mpJavaGame.state.State;
import com.mpJavaGame.state.StateManager;
import com.mpJavaGame.ui.objects.TextButton;
import com.mpJavaGame.ui.objects.TextLabel;
import com.mpJavaGame.ui.objects.UIButton;

import java.util.LinkedList;
import java.util.List;

import java.awt.*;

import static com.mauroPignatta.Visualizer.HEIGHT;
import static com.mauroPignatta.Visualizer.WIDTH;

public class ResultState extends State {

    public static String NAME = "Result";

    private SortResult results;

    private List<TextLabel> labels;
    private UIButton backButton;

    public ResultState(SortResult results) {
        super(NAME);
        this.results = results;
        initLabels();
    }

    @Override
    public void inputs() {}

    @Override
    public void update(double delta) {
        backButton.update();
    }

    @Override
    public void render(Graphics2D g) {
        for(TextLabel label : labels){
            label.render(g);
        }
        backButton.render(g);
    }


    private void initLabels() {
        labels = new LinkedList<>();

        int column1 = WIDTH / 10;
        int column2 = WIDTH - WIDTH / 10;

        int y = HEIGHT / 7;
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, WIDTH / 25);
        Color color = Color.white;

        TextLabel result = new TextLabel(WIDTH / 2, HEIGHT / 20, 0.5f, color, font, "Results");
        
        TextLabel algorithm = new TextLabel(column1, y, 0f, color, font, "Algorithm used:");
        TextLabel algorithmResult = new TextLabel(column2, y, 1f, color, font, "" + results.getAlgorithm());

        TextLabel size = new TextLabel(column1, y * 2, 0f, color, font, "Array size:");
        TextLabel sizeResult = new TextLabel(column2, y * 2, 1f, color, font, "" + results.getArraySize());

        TextLabel ups = new TextLabel(column1, y * 3, 0f, color, font, "Iterations per second:");
        TextLabel upsResult = new TextLabel(column2, y * 3, 1f, color, font, "" + results.getIterationsPerSecond());

        TextLabel time = new TextLabel(column1, y * 4, 0f, color, font, "Total time spent:");
        TextLabel timeResult = new TextLabel(column2, y * 4, 1f, color, font, "" + Math.round(results.getTimeSpent()) + " second/s");

        TextLabel swaps = new TextLabel(column1, y * 5, 0f, color, font, "Swaps:");
        TextLabel swapsResult = new TextLabel(column2, y * 5, 1f, color, font, "" + results.getTotalSwaps());

        labels.add(result);
        labels.add(algorithm);
        labels.add(algorithmResult);
        labels.add(size);
        labels.add(sizeResult);
        labels.add(ups);
        labels.add(upsResult);
        labels.add(time);
        labels.add(timeResult);
        labels.add(swaps);
        labels.add(swapsResult);

        backButton = new TextButton(WIDTH / 2, HEIGHT - y,0.5f, color, Color.YELLOW, font, "Back to menu") {
            @Override
            protected void onClick() {
                StateManager.getManager().setCurrentState(MenuState.NAME);
            }
        };
    }

}
