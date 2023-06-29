/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape.decorator;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public class Border extends ShapeDecorator {

    int width=10;

    public Border(MyShapeInterface myShapeInterface) {

        super(myShapeInterface);
    }

    @Override

    public void draw(Graphics2D g2) {

        this.myShapeInterface.draw(g2);

        RectangularShape helpShape = myShapeInterface.getShape();

        Point2D pointLeft = new Point2D.Double(helpShape.getMinX()-width,

                helpShape.getMinY()-width );

        Point2D pointRight = new Point2D.Double(helpShape.getMaxX()+width,

                helpShape.getMaxY()+width);

        RectangularShape helpShape1 = (RectangularShape) helpShape.clone();

        helpShape1.setFrameFromDiagonal(pointLeft, pointRight);

        g2.draw(helpShape1);
    }

    @Override

    public void setFrameFromDiagonal(Point2D[] p) {        myShapeInterface.setFrameFromDiagonal(p);    }

    @Override

    public RectangularShape getShape() {   return myShapeInterface.getShape();   }

    @Override
    public void setParameter(int par){    width = par;    }

    @Override
    public MyShapeInterface clone() {
        MyShapeInterface shape = (MyShapeInterface) myShapeInterface.getMyShape().clone();
        return new Border(shape);
    }

    @Override
    public MyShapeInterface getMyShape() {
        return this;
    }

    @Override
    public void setShape(RectangularShape aDouble) {
        myShapeInterface.setShape(aDouble);
    }
}
