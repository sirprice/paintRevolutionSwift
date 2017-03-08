package models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Created by o_0 on 2017-03-08.
 */
public class Circle extends Shape {

    private double radius = 100.0;
    private double x = 250.0;
    private double y = 250.0;

    public Circle() {
    }

    public Circle(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    protected void drawShape(GraphicsContext g) {
//        g.setFill();
        g.setStroke(Color.BLACK);
        g.strokeOval(x,y,radius,radius);
        g.stroke();

    }
}