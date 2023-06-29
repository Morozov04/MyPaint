package controller;

import java.awt.Color;
import java.awt.geom.RectangularShape;
import model.Model;
import shape.MyShape;
import activity.Activity;
import activity.DrawActivity;
import java.awt.geom.Ellipse2D;
import shape.Empty;
import shape.Insides;

public class State {

    Controller c;
    Activity activity;
    MyShape myShape;
    Model model;
    Color color;

    public State(RectangularShape shape, Activity y, Color color) {
        activity = y;
        myShape = new MyShape(shape, color);
        this.color = color;
    }

    public State() {
        myShape = new MyShape(new Ellipse2D.Double(), new Empty(), Color.BLACK);
        activity = new DrawActivity();
        this.color = Color.BLUE;
    }

    State(Activity action) {
        activity = action;
    }

    public MyShape getShape() {
        return myShape;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setShape(RectangularShape shape) {
        myShape.setShape(shape);
        myShape.setColor(color);
        model.setShape(myShape);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        activity.setModel(model);
    }

    public void setColor(Color color) {
        this.color  = color;
        myShape.setColor(color);
        model.setShape(myShape);
    }

    public void setModel(Model model) {
        this.model = model;
        activity.setModel(model);
        this.model.setShape(myShape);
    }

    public void setInsides(Insides insides) {
        myShape.setInsides(insides);
        model.setShape(myShape);
    }
}