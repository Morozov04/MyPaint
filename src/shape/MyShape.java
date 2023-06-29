/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public class MyShape {
    RectangularShape shape;
    Insides insides;

    public MyShape(RectangularShape shape, Insides insides) {
        this.shape = shape;
        this.insides = insides;
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public void setInsides(Insides insides) {
        this.insides = insides;
    }

    public void setFrameFromDiagonal(Point2D point2D, Point2D point2D0) {
        shape.setFrameFromDiagonal(point2D, point2D0);
    }

    public void draw(Graphics2D g2) {
        insides.paint(g2, shape);
    }

    public void setFrame(Point2D[] p) {
        shape.setFrameFromDiagonal(p[0], p[1]);
    }

    public MyShape() {
        insides = new Empty();
    }
}