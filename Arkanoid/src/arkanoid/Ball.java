/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import static java.awt.image.ImageObserver.WIDTH;

/**
 *
 * @author Ricardo
 */
public class Ball {

    /**
     * posision inicial el momento en el cual el pega y cambia de direccion las
     * cantidades de bolas los puntos la inicializacion del radio de la bola la
     * inicializacion de la logica extra que es un powerup vida extra
     */
    private ArkanoidLogica game;
    private int radios = 10;

    private Point Posicion = new Point(0, 0);
    private Point momento = new Point(1, 1);
    private float VelocidadBall = 0.2f;
    private int balls = 3;
    private int puntos = 100;
    private PowerUps pw;
    private int extra = 1000;
    private int vidaEXTRA = 3;

    public Ball(ArkanoidLogica game, PowerUps pw) {
        this.game = game;
        this.pw = pw;
    }

    public ArkanoidLogica getGame() {
        return game;
    }

    public void setGame(ArkanoidLogica game) {
        this.game = game;
    }

    public int getRadios() {
        return radios;
    }

    public void setRadios(int radios) {
        this.radios = radios;
    }

    public Point getPosicion() {
        return Posicion;
    }

    public void setPosicion(Point Posicion) {
        this.Posicion = Posicion;
    }

    public Point getMomento() {
        return momento;
    }

    public void setMomento(Point momento) {
        this.momento = momento;
    }

    public float getVelocidadBall() {
        return VelocidadBall;
    }

    public void setVelocidadBall(float VelocidadBall) {
        this.VelocidadBall = VelocidadBall;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public PowerUps getPw() {
        return pw;
    }

    public void setPw(PowerUps pw) {
        this.pw = pw;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

    public int getVidaEXTRA() {
        return vidaEXTRA;
    }

    public void setVidaEXTRA(int vidaEXTRA) {
        this.vidaEXTRA = vidaEXTRA;
    }

    public Ball() {
    }

    /**
     * cuenta con la cantidad de bolas iniciales que son tres y si las pierde
     * regresa a la posision en la que inicia actualmente
     *
     * @param game es el llamado de la logica como parametro
     */
    public Ball(ArkanoidLogica game) {
        this.game = game;
        balls = 3;
    }

    /**
     * Bola perdida Un metodo que cuenta las vidas que le quedan y si al final
     * pierde todas las vidas usted quedara eliminidado o Bien GAMEOVER
     */
    public void BolaPerdida() {
        if (this.puntos == 1000) {
            balls += 1;

        }
        balls--;

        if (balls <= 0) {

            game.OnGameOver(false);
        } else {
            Posicion = new Point(0, 0);
        }
    }

    /**
     * chequea el moviento de la app si coliciona con un bloque este sera
     * removido y si pasa por debajo de la linea de la barra o Player
     *
     * @param Reboto es la velocidad cuando rebota o coliciona con la pared
     */
    public void Marca(double Reboto) {
        Posicion.translate((int) (momento.x * (VelocidadBall * Reboto)), (int) (momento.y * (VelocidadBall * Reboto)));
        if (Math.abs(Posicion.x) >= Math.abs(game.getWidth() / 2)) {
            momento.x = -momento.x;
        }
        if (Posicion.y <= -game.getHeight() / 2) {
            momento.y = -momento.y;
        }
        if (Posicion.y >= game.getHeight() / 2) {
            BolaPerdida();
        }

        Rectangle hitbox = new Rectangle(Posicion.x - radios, Posicion.y - radios, radios * 2, radios * 2);
        Point pv = game.getPlayer().bounceVector(hitbox);
        momento.x *= pv.x;
        momento.y *= pv.y;

        for (int i = 0; i < game.getBlocks().size(); i++) {
            Block b = game.getBlocks().get(i);
            pv = b.bounceVector(hitbox);
            momento.x *= pv.x;
            momento.y *= pv.y;
            if (pv.x < 0 || pv.y < 0) {
                game.OnBlockBroken(b);
                game.getBlocks().remove(b);
                puntos += 100;

            }
        }
    }

    /**
     * pinta la cantidad de puntos que se va generando y si los puntos llegan a
     * una respectiva cifra aumentan mil
     *
     * @param g graficos para el drawString
     */
    public void pintarPuntos(Graphics g) {
        if (puntos == 3000) {
            puntos += 1000;
        }
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Puntos " + puntos, WIDTH / 2, 390);

    }

//    public void comienzaELUP() {
//        if (puntos == 1000) {
//            pw.Empezar(1);
//
//        }
//        if (puntos == 5000) {
//            pw.Empezar(2);
//
//        }
//     if (puntos ==1000 ){
//      pw.Empezar(1,g);
//     
//     }if (puntos ==5000 ){
//      pw.Empezar(4,g);
//     
//     }}
    /**
     * Las Vidas las pinta en el juego mientras se va jugando el Usuario puede
     * Visualisar Cuantas Vidas Tiene o le quedan
     *
     * @param g los graficos que pintan las vidas
     */
    public void life(Graphics g) {

        g.setColor(Color.RED.darker());
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Vidas", 120, 400);
        switch (balls) {
            case 4:
                g.fillOval(127, 400, 15, 15);
                g.fillOval(145, 400, 15, 15);
                g.fillOval(162, 400, 15, 15);
                g.fillOval(150, 400, 15, 15);

                break;

            case 3:
                g.fillOval(127, 400, 15, 15);
                g.fillOval(145, 400, 15, 15);
                g.fillOval(162, 400, 15, 15);
                break;
            case 2:
                g.fillOval(127, 400, 15, 15);
                g.fillOval(145, 400, 15, 15);
                break;
            case 1:
                g.fillOval(127, 400, 15, 15);
                break;
            default:

                break;
        }

    }

    /**
     * EL RENDER CON simple
     *
     * @param g
     */
    public void renderBALL(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(Posicion.x - radios, Posicion.y - radios, radios * 2, radios * 2);

    }

    /**
     * el render pero con el POWERUP PUESTO
     *
     * @param g
     */
    public void renderup(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(Posicion.x - radios, Posicion.y - radios, radios * 4, radios * 4);

    }

    void AddPoint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void vidaExtra(int num) {
        this.setVidaEXTRA(num);
    }
}
