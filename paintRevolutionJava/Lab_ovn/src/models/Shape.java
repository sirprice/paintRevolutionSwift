package models;

import SubjectObserver.*;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by o_0 on 2017-03-08.
 */
abstract public class Shape implements ToolDescription, Cloneable {

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

    abstract protected  void drawShape(GraphicsContext g);



    abstract public Shape createCopy();
    abstract public void setX(double x);
    abstract public void setY(double y);
    abstract public double getX();
    abstract public double getY();
    public abstract boolean containsPoint(double x, double y);

    public void updateShapeProperties(ShapeProperties shapeProperties){
        this.shapeProperties = shapeProperties;
    }

}
