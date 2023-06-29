package model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;
import shape.MyShape;
import shape.decorator.MyShapeInterface;

public class Model extends Observable {
    MyShape shape;
    ArrayList<MyShape> list;

    private static Model model = null;

    private Model(MyShape s) {
        list = new ArrayList<>();
        this.shape =  s;
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    private Model() {
        list = new ArrayList<>();
    }

    ///// тут Model

    public static Model getInstance(){

        if (model == null) { model = new Model();

        }
        return model;
    }

    public void createShape() {
        shape = shape.clone();
        list.add(shape);
    }

    public void setFrame(Point2D[] p) {
        shape.setFrameFromDiagonal(p);
        setChanged();
        notifyObservers();
    }

    public void draw(Graphics2D g2) {
        if(list != null)
            for(MyShapeInterface x:list)x.draw(g2);
    }

    public void findShape(Point2D p) {
        for(MyShape x:list){
            if(x.getShape().contains(p)){
                shape = x;
                break;
            }
        }
    }

    public void move(Point2D[] p) {
        double deltaX = p[0].getX()-p[1].getX();
        double deltaY = p[0].getY()-p[1].getY();
        if(shape!=null){
            double xMin = shape.getShape().getMinX()-deltaX;
            double yMin = shape.getShape().getMinY()-deltaY;
            double xMax = shape.getShape().getMaxX()-deltaX;
            double yMax = shape.getShape().getMaxY()-deltaY;
            shape.setShapeSize(xMin, yMin, xMax, yMax);
            p[0]=p[1];
            setChanged();
            notifyObservers();
        }
    }
}
