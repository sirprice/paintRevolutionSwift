package Command;

import StateHandler.ActiveSelections;

/**
 * Created by o_0 on 2017-03-09.
 */
public class CommandTarget {
    private double x;
    private double y;
    private String name;
    private ActiveSelections selections;

    public CommandTarget(double x, double y, String name, ActiveSelections selections) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.selections = selections;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public ActiveSelections getSelections() {
        return selections;
    }
}
