package activity;

import java.awt.geom.Point2D;
import model.Model;

public class MoveActivity implements Activity{
    Point2D p[]= new Point2D[2];
    Model model;

    public MoveActivity() {

    }
    @Override
    public void press(Point2D p) {
        this.p[0] = p;
        model.findShape(p);
    }

    @Override
    public void dragg(Point2D p) {
        this.p[1]=p;
        model.move(this.p);
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }
}
