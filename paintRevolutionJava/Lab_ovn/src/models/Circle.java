package models;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

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
        super(new ShapeProperties(Color.BLACK,false,5));
    }

    public Circle(double x, double y,double radius) {
        super(new ShapeProperties(Color.BLACK,false,5));
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public Circle(double x, double y, double radius, ShapeProperties shapeProperties) {
        super(shapeProperties);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    protected void drawShape(GraphicsContext g) {

//        g.setLineWidth(shapeProperties.getLineWidth());
//        g.setStroke(shapeProperties.getColor());
//        if (shapeProperties.isFilled())
//            g.fill();
//
        g.strokeOval(x - radius/2,y - radius/2,radius,radius);
        g.stroke();

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Shape createCopy() {
        try {
            return new Circle(x,y,radius,shapeProperties.clone());
        } catch (CloneNotSupportedException e) {
            return new Circle(x,y,radius);
        }
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        Circle copy = (Circle)super.clone();

        copy.shapeProperties = copy.shapeProperties.clone();

        return copy;
    }

    @Override
    void propertySet(ShapeProperties shapeProperties) {

    }

    @Override
    public boolean containsPoint(double x, double y) {
        Point2D p = new Point2D(x,y);
        if (p.distance(this.x,this.y)>radius/2)
            return false;
        System.out.println("Circle selected");
        return true;

    }
}
