package shape;

import java.awt.Graphics2D;
import java.awt.Paint;

public class Empty implements Insides {

    @Override
    public void paint(Graphics2D g, MyShape shape) {
        Paint p = g.getPaint();
        g.setColor(shape.getColor());
        g.draw(shape.getShape());
        g.setPaint(p);

    }
    @Override
    public Insides clone() {
        return new Empty();
    }
}
