package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import shape.decorator.MyShapeInterface;

public class MyShape implements MyShapeInterface {
    RectangularShape shape;
    Insides insides;
    Color color;

    public MyShape(RectangularShape shape, Insides insides) {
        this.shape = shape;
        this.insides = insides;
    }

    public MyShape(RectangularShape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public void setInsides(Insides insides) {
        this.insides = insides;
    }

    @Override
    public void setFrameFromDiagonal(Point2D[] p) {
        shape.setFrameFromDiagonal(p[0], p[1]);
    }

    @Override
    public void draw(Graphics2D g2) {
        insides.paint(g2,this);
    }

    public void setFrame(Point2D[] p) {
        shape.setFrameFromDiagonal(p[0], p[1]);
    }

    public MyShape() {
    }

    public MyShape(RectangularShape shape, Insides insides, Color color) {
        this.shape = shape;
        this.insides = insides;
        this.color = color;
    }

    public RectangularShape getShape() {
        return shape;
    }

    public Insides getInsides() {
        return insides;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyShape clone(){
        MyShape s = new MyShape();
        s.shape = (RectangularShape)shape.clone();
        s.insides = insides.clone();
        s.color  = color;
        return s;
    }



    @Override
    public void setParameter(int par) {
    }

    @Override
    public MyShapeInterface getMyShape() {
        return this;
    }

    public void setShapeSize(double xMin, double yMin, double xMax, double yMax) {
        shape.setFrameFromDiagonal(xMin, yMin, xMax, yMax);
    }
}