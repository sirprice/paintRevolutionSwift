package models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by o_0 on 2017-03-08.
 */
public class ShapeGroup extends Shape {

    private String name = getClass().getSimpleName();
    ArrayList<Shape> shapes;
    private double size = 100.0;


    private double x = 0.0;
    private double y = 0.0;

    public ShapeGroup() {
        super(new ShapeProperties(Color.BLACK, false, 5));
        this.shapes = new ArrayList<Shape>();
    }

    public ShapeGroup(double x, double y, ArrayList<Shape> shapes, String name) {
//        super(shapeProperties);
        this(x, y, shapes);
        this.name = name;
    }

    public ShapeGroup(double x, double y, ArrayList<Shape> shapes) {
        super(new ShapeProperties(Color.BLACK, false, 5));
        this.shapes = shapes;
        this.x = x;
        this.y = y;
        double middleX = 0.0;
        double middleY = 0.0;
        for (Shape s : shapes) {
            middleX += s.getX();
            middleY += s.getY();
        }
        middleX = middleX / shapes.size();
        middleY = middleY / shapes.size();
        for (Shape s : shapes) {
            s.setX(s.getX() - middleX + x);
            s.setY(s.getY() - middleY + y);
        }
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double posX) {
        double diffX = posX - x;
        for (Shape s : shapes) {
            s.setX(s.getX() + diffX);
        }
        this.x = posX;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double posY) {
        double diffY = posY - y;
        for (Shape s : shapes) {
            s.setY(s.getY() + diffY);
        }
        this.y = posY;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void drawShape(GraphicsContext g) {
        for (Shape s : shapes) {
            s.drawShape(g);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Shape createCopy() {
        ArrayList<Shape> newShape = new ArrayList<>();
        for (Shape s : shapes) {
            newShape.add(s.createCopy());
        }
        return new ShapeGroup(x, y, newShape);
    }

    @Override
    public ShapeGroup clone() throws CloneNotSupportedException {
        ShapeGroup copy = (ShapeGroup)super.clone();
//        ShapeGroup copy = new ShapeGroup()
        ArrayList<Shape> newShape = new ArrayList<>();
        ShapeProperties prop = shapeProperties.clone();
        for (Shape s : shapes) {
            newShape.add(s.clone());
        }
//        ShapeGroup copy = new ShapeGroup(x, y, newShape, name);
        copy.shapes = newShape;
        copy.updateShapeProperties(prop);
        return copy;
    }

    @Override
    void propertySet(ShapeProperties shapeProperties) {
        for (Shape s : shapes) {
            s.updateShapeProperties(shapeProperties);
        }
    }

    @Override
    public boolean containsPoint(double x, double y) {
        for (Shape s : shapes) {
            if (s.containsPoint(x, y))
                return true;
        }
        return false;
    }
}
