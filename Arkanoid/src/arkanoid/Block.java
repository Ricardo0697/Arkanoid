/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @version 2.2
 * @author Ricardo
 */
public class Block {

    Point position = new Point(0, 0);
    private int width = 70;
    private int height = 30;
    public Color ColorPrincipal = Color.red.darker();
    public int dureza;
    public Block() {
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColorPrincipal() {
        return ColorPrincipal;
    }

    public void setColorPrincipal(Color ColorPrincipal) {
        this.ColorPrincipal = ColorPrincipal;
    }
    
    /**
     * Calcula Cuando Choca la Pelota En que momento y en que posision
     *
     * @param hitbox el parametro que resibe donde pega la pelota
     * @return devuelve los puntos donde pega la pelota y luego los elimina pero
     * esto en Otro metodo le da la velocicidad cada vez que pega en un bloque
     */
    public Point bounceVector(Rectangle hitbox) {

        Point p = new Point(1, 1);
        Rectangle hitboxDefrente = new Rectangle(position.x, position.y, width, height / 3);
        Rectangle hitboxDeAtras = new Rectangle(position.x, position.y + height - height / 3, width, height / 3);
        Rectangle hitboxIzq = new Rectangle(position.x, position.y, width / 10, height);
        Rectangle hitboxDER = new Rectangle(position.x + width - width / 10, position.y, width / 10, height);
        if (hitboxDefrente.intersects(hitbox) || hitboxDeAtras.intersects(hitbox)) {
            p.y = -1;
        }
        if (hitboxDER.intersects(hitbox) || hitboxIzq.intersects(hitbox)) {
            p.x = -1;
        }

        return p;
    }

    /**
     * pinta los cubos o ladrillos
     *
     * @param g el metodo grafico que ayuda a pintar
     */
    public void renderBlock(Graphics g) {
        g.setColor(ColorPrincipal);
        g.fillRect(position.x, position.y, width, height);

        for (int i = 0; i < height / 4; i++) {
            g.setColor(ColorPrincipal.darker());
            g.drawLine(position.x + i, position.y + height - i, position.x + width - 1, position.y + height - i);
            g.drawLine(position.x + width - 1 - i, position.y + i, position.x + width - 1 - i, position.y + height);
            g.setColor(ColorPrincipal.brighter());
            g.drawLine(position.x, position.y + i, position.x + width - 1 - i, position.y + i);
            g.drawLine(position.x + i, position.y + height - i, position.x + i, position.y);
        }

    }

    @Override
    public String toString() {
        return "Block{" + "position=" + position + ", width=" + width + ", height=" + height + ", ColorPrincipal=" + ColorPrincipal + '}';
    }

}
