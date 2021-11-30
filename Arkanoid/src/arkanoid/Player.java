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
 *
 * @author Ricardo
 */
public class Player {

    private ArkanoidUTNLogica game;
    private int height = 10;
    private int width = 100;
    Point position = new Point(0, 0);
    private int mover;
    private int velocidad = 11;

    public Player() {
    }

    public Player(ArkanoidUTNLogica game, int mover) {
        this.game = game;
        this.mover = mover;
    }

    public Player(ArkanoidUTNLogica game) {
        this.game = game;
        position = new Point(0, game.getHeight() / 2 - height - 20);
    }

    /**
     * CalCula La Direcion De Donde Pega la pelota con respecto a la Barra
     *
     * @param hitbox el Golpe que Da la Pelota con respecto a la barra
     * @return los puntos de cada rebote con la pelota y la barra
     */
    public Point bounceVector(Rectangle hitbox) {
        Point p = new Point(1, 1);
        Rectangle hitboxtabla = new Rectangle(position.x - width / 2, position.y - height / 2, width, height / 3);
        Rectangle hitboxbola = new Rectangle(position.x - width / 2, position.y + height / 2 - height / 3, width, height / 3);
        Rectangle hitboxIzq = new Rectangle(position.x - width / 2, position.y - height / 2, width / 10, height);
        Rectangle hitboxDer = new Rectangle(position.x + width / 2 - width / 10, position.y - height / 2, width / 10, height);
        if (hitboxtabla.intersects(hitbox) || hitboxbola.intersects(hitbox)) {
            p.y = -1;
        }
        if (hitboxDer.intersects(hitbox) || hitboxIzq.intersects(hitbox)) {
            p.x = -1;
        }
        return p;
    }

    public int getMover() {
        return mover;
    }

    public void setMover(int mover) {
        this.mover = mover;
    }

    /**
     * envia el mivimiento del juego si se dirige a la izq o a la derecha con la
     * velocidad respectiva
     */
    public void mover() {
        if (mover == 1) {
            position.x += velocidad;

        } else if (mover == 2) {
            position.x -= velocidad;

        }

    }

    /**
     * cuando los puntos lleguen a una cifra x ya estipulada el jugador va
     * experimentar que la velocidad de la nabe arkanoid se aumenta haciendo mas
     * complicado el manejo
     */
    public void velocidadaumentada() {
        Ball bal = new Ball();
        if (bal.getPuntos() == 5000) {
            velocidad += 14;

        }
    }

    public void rederup(Graphics g) {

    }

    /**
     * pinta la barra y le da el rebote a cada parte o seccion de ella misma
     *
     * @param g Graphics que le da forma y color a la paleta
     */
    public void renderPlayer(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(position.x - width / 2, position.y - height / 2, width, height);
        Rectangle hitBola = new Rectangle(game.player.position.x - game.player.width / 2, game.player.position.y - game.player.height / 2, game.player.width, height / 3);
        Rectangle hittabla = new Rectangle(game.player.position.x - game.player.width / 2, game.player.position.y + game.player.height / 2 - height / 3, game.player.width, height / 3);
        Rectangle hitIzq = new Rectangle(game.player.position.x - game.player.width / 2, game.player.position.y - game.player.height / 2, width / 10, game.player.height);
        Rectangle hitDer = new Rectangle(game.player.position.x + game.player.width / 2 - width / 10, game.player.position.y - game.player.height / 2, width / 10, game.player.height);
        g.setColor(Color.RED);
        g.fillRect(hitBola.x, hitBola.y, hitBola.width, hitBola.height);
        g.setColor(Color.ORANGE);
        g.fillRect(hittabla.x, hittabla.y, hittabla.width, hittabla.height);
        g.setColor(Color.RED);
        g.fillRect(hitIzq.x, hitIzq.y, hitIzq.width, hitIzq.height);
        g.setColor(Color.PINK);
        g.fillRect(hitDer.x, hitDer.y, hitDer.width, hitDer.height);

    }

    public ArkanoidUTNLogica getGame() {
        return game;
    }

    public void setGame(ArkanoidUTNLogica game) {
        this.game = game;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Player{" + "game=" + game + ", height=" + height + ", width=" + width + ", position=" + position + ", mover=" + mover + ", velocidad=" + velocidad + '}';
    }

}
