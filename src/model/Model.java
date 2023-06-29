/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;

import shape.MyShape;

public class Model extends Observable{
    MyShape shape;

    public Model() {
        this.shape =  new MyShape();
    }

    public void createShape() {
        shape.setShape( new Rectangle2D.Double());
    }

    public void setFrame(Point2D[] p) {
        shape.setFrame(p);
        extracted();
        notifyObservers();
    }

    private void extracted() {
        setChanged();
    }

    public void draw(Graphics2D g2) {
        if (shape != null) shape.draw(g2);
    }
}
