package controller;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import model.Model;
import picture.MyFrame;
import picture.MyPanel;

public class Controller {
    Model model;
    MyPanel panel ;
    MyFrame frame;
    State state;

    private static Controller controller = null;

    public void setPress(Point2D point2D) {
        state.getActivity().press(point2D);

    }
    public void setDragg(Point2D point2D) {
        state.getActivity().dragg(point2D);

    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }

    private Controller() {
        state = new State();
        model = model.getInstance();
        state.setModel(model);
        panel = new MyPanel(this);
        model.addObserver(panel);
        frame = new MyFrame(panel,state);
    }

    public static Controller getIntance(){
        if (controller == null) { controller = new Controller();

        }
        return controller;

    }
}