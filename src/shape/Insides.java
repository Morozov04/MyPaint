/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape;

import java.awt.Graphics2D;

public interface Insides {
    void paint( Graphics2D g, MyShape s);
    Insides clone();
}