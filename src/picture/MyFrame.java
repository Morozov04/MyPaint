package picture;

import activity.DrawActivity;
import activity.MoveActivity;
import controller.State;
import java.awt.BorderLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import menu.SwitchAction;
import menu.SwitchColor;
import menu.SwitchPouring;
import menu.SwitchShape;
import menu.SwitchState;
import shape.Empty;
import shape.Fill;

public class MyFrame extends JFrame {

    MyPanel myPanel;
    State state;

    public MyFrame(MyPanel myPanel,State c) {
        state = c;

        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);
        JToolBar toolBar = new JToolBar();
        add(toolBar,BorderLayout.NORTH);

        ArrayList<JMenu> menu  = new ArrayList<>();
        menu.add(new JMenu("Shape"));

        ArrayList<ArrayList<Action>> bigList = new ArrayList<>();
        ArrayList<Action> shapeList = new ArrayList<>();

        shapeList.add(new SwitchState("rectangle",new ImageIcon("src\\res\\rectangle.PNG"),new SwitchShape(state,new Rectangle2D.Double())));
        shapeList.add(new SwitchState("ellipse",new ImageIcon("src\\res\\ellipse.PNG"),new SwitchShape(state,new Ellipse2D.Double())));

        ArrayList<Action> shapeList1 = new ArrayList<>();
        menu.add(new JMenu("Action"));
        shapeList1.add(new SwitchState("move",new ImageIcon("src\\res\\hand-paper.PNG"),new SwitchAction(state,new MoveActivity())));
        shapeList1.add(new SwitchState("draw",new ImageIcon("src\\res\\pen-fancy.PNG"),new SwitchAction(state,new DrawActivity())));

        ArrayList<Action> shapeList2 = new ArrayList<>();
        menu.add(new JMenu("Color"));
        shapeList2.add(new SwitchState("color",new ImageIcon("src\\res\\palette.PNG"),new SwitchColor(state)));

        ArrayList<Action> shapeList3 = new ArrayList<>();
        menu.add(new JMenu("Pouring"));
        shapeList3.add(new SwitchState("fill",new ImageIcon("src\\res\\fill.PNG"),new SwitchPouring(state, new Fill())));
        shapeList3.add(new SwitchState("empty",new ImageIcon("src\\res\\empty.PNG"),new SwitchPouring(state,new Empty())));

        bigList.add(shapeList);
        bigList.add(shapeList1);
        bigList.add(shapeList2);
        bigList.add(shapeList3);

        for(int i=0;i< menu.size();i++)
        {
            bar.add(menu.get(i));
            for(Action x:bigList.get(i))
            {
                menu.get(i).add(x);
                toolBar.add(x);
            }
        }

        this.myPanel = myPanel;
        add(this.myPanel);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
