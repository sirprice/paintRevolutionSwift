package Command;

/**
 * Created by o_0 on 2017-03-09.
 */
public class CommandTarget {
    private double x;
    private double y;
    private String name;

    public CommandTarget(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
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
}
