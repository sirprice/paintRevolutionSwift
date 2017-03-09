package Command;

/**
 * Created by o_0 on 2017-03-09.
 */
public interface Command {
    abstract void execute(CommandTarget target);
    abstract void undo();
    abstract void redo();
}
