package models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by cj on 2017-03-08.
 */
public class Rectangle extends Shape {

    private String name = getClass().getSimpleName();
    private int id;
    private double width = 100.0;
    private double height = 100.0;
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

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    public Rectangle() {
    }

    public Rectangle(double x, double y,double width, double height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    protected void drawShape(GraphicsContext g) {
        g.setStroke(Color.BLACK);
        g.strokeRect(x - width/2, y - height/2, width, height);
        g.stroke();

    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public Shape createCopy() {
        return new Rectangle(x,y,width,height);
    }
}
