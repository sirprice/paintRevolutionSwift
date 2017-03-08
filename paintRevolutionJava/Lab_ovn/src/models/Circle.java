package models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Created by o_0 on 2017-03-08.
 */
public class Circle extends Shape {

    private String name = getClass().getSimpleName();
    private int id;
    private double radius = 100.0;
    private double x = 250.0;
    private double y = 250.0;


    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    public Circle() {
    }

    public Circle(double x, double y,double radius) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    protected void drawShape(GraphicsContext g) {
//        g.setFill();
        g.setStroke(Color.BLACK);
        g.strokeOval(x - radius/2,y - radius/2,radius,radius);
        g.stroke();

    }

    @Override
    public String getName() {
        return name;
    }



    @Override
    public Shape createCopy() {
        return new Circle(x,y,radius);
    }
}
