/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picture;

import controller.Controller;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import shape.Empty;
import shape.Fill;
import shape.MyShape;

public class MyPanel extends JPanel implements Observer{
Point2D[] p;
    MyShape shape;
    JButton button;
JButton button1;
JButton button2;
JButton button3;
    Controller controller;

    public MyPanel(Controller c) {
        controller = c;
       shape = new  MyShape ( new Rectangle2D.Double(), new Empty());
        button = new JButton("Elipse");
        button1 = new JButton ("Rectangle");
        button2 = new JButton ("Filled");
        button3 = new JButton ("Empty");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape.setShape(new Ellipse2D.Double());
            }
        });
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape.setShape(new Rectangle2D.Double());
            }
        });
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape.setInsides(new Fill());
            }
        });
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape.setInsides(new Empty());
            }
        });
        add(button);
        add(button1);
        add(button2);
        add(button3);

        p = new Point2D[2];

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                controller.setPress((Point2D) e.getPoint());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                controller.setDragg((Point2D) e.getPoint());

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        controller.draw(g2);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}