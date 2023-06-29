package menu;

import controller.State;
import shape.Insides;
import shape.MyShape;

public class SwitchPouring implements Command {

    State state;
    Insides insides;

    public SwitchPouring(State state, Insides insides) {
        this.state = state;
        this.insides = insides;
    }

    @Override
    public void execute() {
        state.setInsides(insides);
    }
}
