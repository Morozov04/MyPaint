package activity;

import java.awt.geom.Point2D;
import model.Model;

public interface Activity {

    void press(Point2D p);
    void dragg(Point2D p);

    public void setModel(Model model);
}
