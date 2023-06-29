/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activity;

import java.awt.geom.Point2D;
import model.Model;

public class DrawActivity implements Activity{
    Point2D p[]=new Point2D[2];
    Model model;

    @Override
    public void press(Point2D p) {
        this.p[0]=p;
        model.createShape();
    }

    @Override
    public void dragg(Point2D p) {
        this.p[1]=p;
        model.setFrame(this.p);
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }
}
