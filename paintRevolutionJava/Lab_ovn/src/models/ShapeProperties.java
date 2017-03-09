package models;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by cj on 2017-03-09.
 */
public class ShapeProperties implements Cloneable,Serializable {
    private double red,green,blue,opacity;
    private boolean isFilled;
    private double lineWidth;

    public ShapeProperties(Color color, boolean isFilled, double lineWidth) {
        this.isFilled = isFilled;
        this.lineWidth = lineWidth;
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        this.opacity = color.getOpacity();
    }

    public Color getColor() {
        return new Color(red,green,blue,opacity);
    }
    public boolean isFilled() {
        return isFilled;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    @Override
    protected ShapeProperties clone() throws CloneNotSupportedException {
        return new ShapeProperties(new Color(red,green,blue,opacity), isFilled, lineWidth);
    }
}
