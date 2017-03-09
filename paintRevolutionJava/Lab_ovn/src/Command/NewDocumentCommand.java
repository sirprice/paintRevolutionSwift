package Command;

import models.SPrototype;
import models.SceneModel;
import models.Shape;

import javax.imageio.event.IIOReadProgressListener;

/**
 * Created by cj on 2017-03-09.
 */
public class NewDocumentCommand implements IrreversibleCommand {

    private SceneModel sceneModel;
    private SPrototype prototype;

    public NewDocumentCommand(SceneModel sceneModel, SPrototype prototype) {
        this.sceneModel = sceneModel;
        this.prototype = prototype;
    }

    @Override
    public void execute(CommandTarget target) {
        sceneModel.totalAnnihilation();
    }
}
