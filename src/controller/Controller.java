/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import model.Model;
import picture.MyFrame;
import picture.MyPanel;
import shape.MyShape;

public class Controller {
    Model model;
    MyShape shape;
    MyPanel panel ;
    MyFrame frame;
    Point2D [] p;

    public void setPress(Point2D point2D) {
        p[0]=point2D;
        model.createShape();
    }

    public void setDragg(Point2D point2D) {
        p[1]=point2D;
        model.setFrame(p);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }

    public Controller() {
        model = new Model();
        panel = new MyPanel(this);
        model.addObserver(panel);
        frame = new MyFrame(panel);
        p = new Point2D[2];
    }

}
