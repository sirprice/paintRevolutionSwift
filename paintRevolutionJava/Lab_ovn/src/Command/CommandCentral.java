package Command;

import java.lang.annotation.Target;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by o_0 on 2017-03-09.
 */
public class CommandCentral {
    private Deque<Command> redoStack = new LinkedList();
    private Deque<Command> undoStack = new LinkedList();

    public CommandCentral() {
    }

    public void doCommand(Command command, CommandTarget target) {
        System.out.println("CommandCentral: cmd doCommand: size: r: " + redoStack.size() + " u: " +  undoStack.size());
        command.execute(target);
        undoStack.addLast(command);
        redoStack = new LinkedList();
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }
        Command last = redoStack.removeLast();
        System.out.println("CommandCentral: cmd redo: size: r: " + redoStack.size() + " u: " +  undoStack.size());

        last.redo();
        undoStack.addLast(last);
    }

    public void undo() {
        System.out.println("CommandCentral: cmd undo: size: r: " + redoStack.size() + " u: " +  undoStack.size());
        if (undoStack.isEmpty()) {
            return;
        }
        Command last = undoStack.removeLast();
        last.undo();
        redoStack.addLast(last);
    }
}
