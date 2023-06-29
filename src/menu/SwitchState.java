/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package menu;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

public class SwitchState extends AbstractAction {
    Command command;
    public SwitchState(String name, Icon icon, Command c) {
        super(name, icon);
        command = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        command.execute();
    }
}
