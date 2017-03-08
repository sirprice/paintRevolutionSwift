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
//        g.setFill();
        g.setStroke(Color.BLACK);
        g.strokeRect(x,y, width, height);
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
