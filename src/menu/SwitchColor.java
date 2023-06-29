package menu;

import controller.State;
import java.awt.Color;
import javax.swing.JColorChooser;

public class SwitchColor implements Command {
    State state;
    Color color;

    public SwitchColor(State state)
    {
        this.state = state;
    }

    @Override
    public void execute() {
        color =  JColorChooser.showDialog(null,"Color",Color.BLACK);
        state.setColor(color);
    }
}
