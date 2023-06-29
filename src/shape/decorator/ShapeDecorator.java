/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape.decorator;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public abstract class ShapeDecorator implements MyShapeInterface {

    MyShapeInterface myShapeInterface;

    public ShapeDecorator(MyShapeInterface myShapeInterface) {

        this.myShapeInterface = myShapeInterface;
    }

    @Override

    abstract public void draw(Graphics2D g2);

    @Override

    abstract public void setFrameFromDiagonal(Point2D []p);

    @Override

    abstract public RectangularShape getShape();

    @Override
    public void setParameter(int k) {}

    @Override
    abstract public MyShapeInterface clone();
}