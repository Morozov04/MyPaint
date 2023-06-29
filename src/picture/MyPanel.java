package picture;

import controller.Controller;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Observer {

    Controller controller;

    public MyPanel(Controller c) {
        controller = c;

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