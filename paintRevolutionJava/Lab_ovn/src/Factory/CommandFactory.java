package Factory;
import Command.Command;
import Command.*;
import Command.CreateShape;
import models.SPrototype;
import models.SceneModel;
import models.ShapeProperties;

/**
 * Created by o_0 on 2017-03-09.
 * This factory creates the different commands that are available in this program
 */
public class CommandFactory {
    private SceneModel sceneModel;
    private SPrototype prototype;

    public CommandFactory( SPrototype prototype, SceneModel sceneModel) {
        this.sceneModel = sceneModel;
        this.prototype = prototype;
    }
// ComandDeleteShape
    public Command getCreateComand() {
        return new CreateShape(sceneModel,prototype);
    }
    public Command getSelectComand() {return new CommandSelectShape(sceneModel,prototype);}
    public Command getChangePropertiesCommand(ShapeProperties shapeProperties){ return new CommandChangeProperties(sceneModel,shapeProperties);}
    public Command getDeleteCommand() {return new ComandDeleteShape(sceneModel,prototype);}


    public IrreversibleCommand getNewDocumentCommand(){return new NewDocumentCommand(sceneModel,prototype);}
    public IrreversibleCommand getNewGroupCommand(){return new NewGroupCommand(sceneModel,prototype);}



}
