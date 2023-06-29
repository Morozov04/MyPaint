package menu;

import activity.Activity;
import controller.State;

public class SwitchAction  implements Command {

    State state;
    Activity action;

    public SwitchAction(State state,Activity action) {
        this.state = state;
        this.action = action;
    }

    @Override
    public void execute() {
        state.setActivity(action);
    }
}
