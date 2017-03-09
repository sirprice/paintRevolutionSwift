package SubjectObserver;

import javafx.scene.paint.Color;

/**
 * Created by cj on 2017-03-09.
 */
@FunctionalInterface
public interface ObserverShapeProperties {

    void changeProperties(Color color, boolean filled, double lineWidth);

}
