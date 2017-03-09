package models;

import javafx.scene.paint.Color;

/**
 * Created by cj on 2017-03-09.
 */
public class ShapeProperties implements Cloneable {
    private Color color;
    private boolean isFilled;
    private double lineWidth;

    public ShapeProperties(Color color, boolean isFilled, double lineWidth) {
        this.color = color;
        this.isFilled = isFilled;
        this.lineWidth = lineWidth;
    }

    public Color getColor() {
        return color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    @Override
    protected ShapeProperties clone() throws CloneNotSupportedException {
        return new ShapeProperties(color, isFilled, lineWidth);
    }
}
