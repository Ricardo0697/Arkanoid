/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Ricardo
 */
public class PowerUps {

    private Block block;
    public Point position = new Point(0, 0);
    private int PowerUp;
    private int width = 70;
    private int height = 30;
    private Color ColorPrincipal = Color.red.darker();
    private Player player;
    private Ball ball;
    private ArkanoidLogica lo;

    public PowerUps(Block block, int PowerUp, Player player, Ball ball, ArkanoidLogica lo) {
        this.block = block;
        this.PowerUp = PowerUp;
        this.player = player;
        this.ball = ball;
        this.lo = lo;
    }

    public PowerUps() {
    }

    /**
     * si llega a ciertos puntajes se rifan los power ups
     *
     * @param comienza si es true comienza si no no hace nada
     */
    public void Empezar(int comienza) {

        switch (comienza) {
            case 1:
                // BigBall
               // ball.renderup(g);
                break;
            case 2:
                //"MORE POINTS"
                ball.vidaExtra(1);
                break;
            case 3:
                //big player
                ball.AddPoint();
                break;
            case 4:
                //Vida Completa 
                //player.rederup(g);
                break;
            default:
                break;
        }

    }

//    /**
//     * ESTE ES UN METODOS EN EL CUAL SOLO se USA PARA VERIFICAR SI FUNCIONAn LOS
//     * POWER UPS
//     *
//     * @param numUP el numero se envia con el teclado
//     * @param g
//     */
//    public void escoge(int numUP, Graphics g) {
//        
//        switch (numUP) {
//            case 1:
//                
//                ball.renderup(g);
//                
//                break;
//            case 2:
//                //"MORE POINTS"
//
//                ball.AddPoint();
//                
//                break;
//            case 3:
//                
//                player.rederup(g);
//                
//                break;
//            case 4:
//                //Vida Completa 
//
//                ball.vidaExtra();
//                break;
//            
//        }
//        
//    }
    /**
     * pinta Capsula de los powerUPS
     *
     * @param g
     */
    public void potenciadorBarra(Graphics g) {
        g.setColor(new Color(250, 10, 124, 252));
        g.fillOval(390, 400, 30, 16);
        g.setColor(Color.ORANGE);
        g.fillOval(389, 400, 20, 15);

    }

    /**
     * pinta Capsula de los powerUPS
     *
     * @param g
     */
    public void PintaVidaExtra(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(430, 400, 30, 16);
        g.setColor(new Color(122, 143, 184, 152));
        g.fillOval(430, 400, 20, 15);

    }

    /**
     * pinta Capsula de los powerUPS
     *
     * @param g
     */
    public void PintarBolaGrande(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(350, 400, 30, 15);
        g.setColor(Color.BLUE);
        g.fillOval(350, 400, 19, 15);

    }

    /**
     * pinta Capsula de los powerUPS
     *
     * @param g
     */
    public void PintarPuntosEXTRA(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(520, 400, 30, 15);
        g.setColor(Color.BLUE);
        g.fillOval(520, 400, 19, 15);

    }

    /**
     * Solo pinta los poderes que estan en la partida
     *
     * @param g
     */
    public void podereshabilitados(Graphics g) {
        g.drawString("PowerUps ", 350, 390);
        PintarBolaGrande(g);
        PintaVidaExtra(g);
        potenciadorBarra(g);
        PintarPuntosEXTRA(g);
    }

    /**
     * Pinta los poderes en los bloques
     *
     * @param g
     */
    public void powerUp(Graphics g) {
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

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getPowerUp() {
        return PowerUp;
    }

    public void setPowerUp(int PowerUp) {
        this.PowerUp = PowerUp;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public ArkanoidLogica getLo() {
        return lo;
    }

    public void setLo(ArkanoidLogica lo) {
        this.lo = lo;
    }

}
