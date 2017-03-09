package models;

import SubjectObserver.*;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

/**
 * Created by o_0 on 2017-03-08.
 */
abstract public class Shape implements ToolDescription, Cloneable, Serializable {

    protected ShapeProperties shapeProperties;

    public Shape(ShapeProperties shapeProperties) {
        this.shapeProperties = shapeProperties;
    }

    final public  void draw(Canvas canvas) {
        GraphicsContext context2D = canvas.getGraphicsContext2D();
        context2D.setLineWidth(shapeProperties.getLineWidth());
        context2D.setStroke(shapeProperties.getColor());
        if (shapeProperties.isFilled())
            context2D.fill();

        drawShape(context2D);


    }

    public ShapeProperties getShapeProperties() {
        return shapeProperties;
    }

    abstract protected  void drawShape(GraphicsContext g);



    abstract public Shape createCopy();
    abstract public void setX(double x);
    abstract public void setY(double y);
    abstract public double getX();
    abstract public double getY();
    public abstract boolean containsPoint(double x, double y);

    public Shape clone() throws CloneNotSupportedException
    {
        try {
            Shape copy = (Shape)super.clone();
            copy.shapeProperties.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void updateShapeProperties(ShapeProperties shapeProperties){
        this.shapeProperties = shapeProperties;
    }

}
