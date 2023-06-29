/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape;

import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;
import picture.MyPanel;

public class Empty implements Insides{

    public Empty() {
    }

    @Override
    public void paint(Graphics2D g, RectangularShape shape) {
        g.draw(shape);
    }
}
