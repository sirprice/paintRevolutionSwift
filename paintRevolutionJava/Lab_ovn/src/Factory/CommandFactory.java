package Factory;
import Command.Command;
import Command.*;
import Command.CreateShape;
import models.SPrototype;
import models.SceneModel;

/**
 * Created by o_0 on 2017-03-09.
 */
public class CommandFactory {
    private SceneModel sceneModel;
    private SPrototype prototype;

    public CommandFactory( SPrototype prototype, SceneModel sceneModel) {
        this.sceneModel = sceneModel;
        this.prototype = prototype;
    }

    public Command getCreateComand() {
        return new CreateShape(sceneModel,prototype);
    }
    public IrreversibleCommand getNewDocumentCommand(){return new NewDocumentCommand(sceneModel,prototype);}



}
