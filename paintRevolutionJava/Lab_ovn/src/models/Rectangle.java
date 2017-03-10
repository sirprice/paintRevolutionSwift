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

    public Rectangle(double x, double y, double width, double height, ShapeProperties properties) {
        super(properties);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

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
        super(new ShapeProperties(Color.BLACK,false,5));
    }

    public Rectangle(double x, double y,double width, double height) {
        super(new ShapeProperties(Color.BLACK,false,5));
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    protected void drawShape(GraphicsContext g) {
        //g.setStroke(Color.BLACK);


        if (shapeProperties.isFilled()) {
            g.fillRect(x - width / 2, y - height / 2, width, height);
        }else {
            g.strokeRect(x - width / 2, y - height / 2, width, height);
        }
        g.stroke();

    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public Shape createCopy() {
        try {
            return new Rectangle(x,y,width,height,shapeProperties.clone());
        } catch (CloneNotSupportedException e) {
            return new Rectangle(x,y,width,height);
        }
//        return new Rectangle(x,y,width,height);
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {

        Rectangle copy = (Rectangle)super.clone();

        copy.shapeProperties = copy.shapeProperties.clone();

        return copy;

//        return new Rectangle(x,y,width,height);
    }

    @Override
    void propertySet(ShapeProperties shapeProperties) {

    }

    @Override
    public boolean containsPoint(double x, double y) {
        double dx = x - this.x + width/2;
        double dy = this.y - y + height/2;
        if (dx < 0 || dy < 0) {
            return false;
        }
        if (dx > width || dy > height) {
            return false;
        }
        return true;
    }
}
