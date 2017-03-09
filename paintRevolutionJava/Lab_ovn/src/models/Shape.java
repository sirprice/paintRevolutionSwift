package models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by o_0 on 2017-03-08.
 */
abstract public class Shape implements ToolDescription, Cloneable {



    final public  void draw(Canvas canvas) {
        GraphicsContext context2D = canvas.getGraphicsContext2D();
        drawShape(context2D);
    }

    abstract protected  void drawShape(GraphicsContext g);

    abstract public Shape createCopy();

    abstract public void setX(double x);
    abstract public void setY(double y);
    abstract public double getX();
    abstract public double getY();


}
