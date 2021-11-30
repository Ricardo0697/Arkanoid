/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.accessibility.AccessibleContext;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author r
 */
class ArkanoidLogica extends JPanel {
    private int width, height;
    private int FPS = 30;
    public Player player;
    private Ball ball;
    private PowerUps pw;
    public boolean isRunning = false, isPaused = false;
    private int nivel = 1;

    private Color[] filaColores = new Color[]{new Color(252, 25, 125, 252), new Color(152, 162, 224, 120).darker(), new Color(35, 152, 120).darker(), new Color(46, 134, 193).darker(), new Color(146, 134, 203), Color.green.darker()};
    private ArrayList<Block> blocks;

    public long UltimaActualizacion;

    private HiloJuego hilodeJuego;

    public ArkanoidUTNLogica(int width, int height, Player player, Ball ball, PowerUps pw, ArrayList<Block> blocks, long UltimaActualizacion, HiloJuego hilodeJuego) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.ball = ball;
        this.pw = pw;
        this.blocks = blocks;
        this.UltimaActualizacion = UltimaActualizacion;
        this.hilodeJuego = hilodeJuego;
    }

    /**
     *
     * @return
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public int getFPS() {
        return FPS;
    }

    /**
     *
     * @param FPS
     */
    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     *
     * @return
     */
    public Ball getBall() {
        return ball;
    }

    /**
     *
     * @param ball
     */
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    /**
     *
     * @return
     */
    public PowerUps getPw() {
        return pw;
    }

    /**
     *
     * @param pw
     */
    public void setPw(PowerUps pw) {
        this.pw = pw;
    }

    /**
     *
     * @return
     */
    public boolean isIsRunning() {
        return isRunning;
    }

    /**
     *
     * @param isRunning
     */
    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     *
     * @return
     */
    public boolean isIsPaused() {
        return isPaused;
    }

    /**
     *
     * @param isPaused
     */
    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    /**
     *
     * @return
     */
    public int getNivel() {
        return nivel;
    }

    /**
     *
     * @param nivel
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     *
     * @return
     */
    public Color[] getFilaColores() {
        return filaColores;
    }

    /**
     *
     * @param filaColores
     */
    public void setFilaColores(Color[] filaColores) {
        this.filaColores = filaColores;
    }

    /**
     *
     * @return
     */
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    /**
     *
     * @param blocks
     */
    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    /**
     *
     * @return
     */
    public long getUltimaActualizacion() {
        return UltimaActualizacion;
    }

    /**
     *
     * @param UltimaActualizacion
     */
    public void setUltimaActualizacion(long UltimaActualizacion) {
        this.UltimaActualizacion = UltimaActualizacion;
    }

    /**
     *
     * @return
     */
    public HiloJuego getHilodeJuego() {
        return hilodeJuego;
    }

    /**
     *
     * @param hilodeJuego
     */
    public void setHilodeJuego(HiloJuego hilodeJuego) {
        this.hilodeJuego = hilodeJuego;
    }

    /**
     *
     * @return
     */
    public ComponentUI getUi() {
        return ui;
    }

    /**
     *
     * @param ui
     */
    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    /**
     *
     * @return
     */
    public EventListenerList getListenerList() {
        return listenerList;
    }

    /**
     *
     * @param listenerList
     */
    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    /**
     *
     * @return
     */
    @Override
    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    /**
     *
     * @param accessibleContext
     */
    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public ArkanoidUTNLogica() {
    }

    public ArkanoidUTNLogica(int width, int height) {
        this.width = width;
        this.height = height;

        reset(nivel);// aqui recetea el nivel 

        this.setFocusable(true);// que funcione el keyListener 
        /**
         * el metodo del key listener unicamente usando el keyPressed que es el
         * unico que en este caso necesito
         */
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setMover(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setMover(2);

                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !isRunning) {
                    run();
                }
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    nivel = 1;
                    reset(nivel);

                }
                if (e.getKeyCode() == KeyEvent.VK_V) {
                    nivel++;
                    reset(nivel);

                }
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    Pause();

                }
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    quit();

                }
            }
        });
    }

    /**
     * Resetea el jugador y la bola el nivel en el que se encuentre y pasa de
     * nivel al mismo tiempo
     *
     * @param nivel resibe el nivel en que el jugador va, si el gana un nivel
     * pasa al siguiente y asi de esa manera
     */
    public void reset(int nivel) {
        if (this.nivel == 1) {
            player = new Player(this);
            ball = new Ball(this);
            pw = new PowerUps();
            creaBloque(6, 10);

        }
        if (this.nivel == 2) {
            player = new Player(this);
            ball = new Ball(this);
            pw = new PowerUps();
            creaBloque(5, 9);
        }
        if (this.nivel == 3) {
            player = new Player(this);
            ball = new Ball(this);
            pw = new PowerUps();
            creaBloque(6, 7);
        }
        if (this.nivel == 4) {
            player = new Player(this);
            ball = new Ball(this);
            pw = new PowerUps();
            creaBloque(8, 12);

        }
        if (this.nivel == 5) {
            player = new Player(this);
            ball = new Ball(this);
            pw = new PowerUps();
            creaBloque(8, 13);

        }
        if (this.nivel >= 6) {
            this.nivel = 1;
            reset(this.nivel);
        }
    }

    /**
     * Corre el programa se ejecuta el gametread y se inicia el nivel
     *
     */
    public void run() {
        if (hilodeJuego != null) {
            if (hilodeJuego.isAlive()) {
                hilodeJuego.interrupt();
            }
        }
        reset(nivel);
        hilodeJuego = new HiloJuego(this);
        hilodeJuego.start();
    }

    /**
     * Pausa el juego
     */
    public void Pause() {
        isPaused = !isPaused;
    }

    /**
     * Quita el juego un boolean que se pone en tru una vez que uno aprieta el Q
     * o ESC del teclado
     *
     */
    public void quit() {
        isRunning = false;
    }

    /**
     * genera los ladrillos en el juego recoriendo un for en el cual recorre
     * columnas y sus respectivas posisiones tambien se crean espacios entre los
     * bloques tambien aqui es donde el arreglo de colores que se hace por
     * defecto se implementa
     *
     * @param filas filas de la matriz
     * @param columnas columndas de la matriz
     */
    private void creaBloque(int filas, int columnas) {
        blocks = new ArrayList<>();//new Block[rows*columns];
        int espacioDeBloque = 10;
        float w = (((float) width - 10) / columnas) - 10;
        float h = 30;
        for (int x = 0; x < columnas; x++) {
            for (int y = 0; y < filas; y++) {
                Block b = new Block();
                b.ColorPrincipal = filaColores[y % filaColores.length];
                b.position.x = (int) (x * (w + espacioDeBloque) + espacioDeBloque) - width / 2;
                b.position.y = (int) (y * (h + espacioDeBloque) + espacioDeBloque) - height / 2;
                b.setHeight((int) h);
                b.setWidth((int) w);
                blocks.add(b);//blocks[y*columns+x] = b;

            }
        }
    }

    /**
     *
     *
     * no finalizado aqui se tomaba el color de las columnas y se le decian
     * cuanta dureza tenian
     *
     * @param b Los Bloques Que se Van Destruyendo este es un arreglo de los
     * bloques
     */
    public void OnBlockBroken(Block b) {
//         for (int i = 0; i < filaColores.length; i++) {
//             int dureza = 3;
//             if(filaColores.equals(Color.GRAY)){
//               dureza = 3;
//            }if(filaColores.equals(Color.BLUE)){
//               dureza = 2;
//            }if(filaColores.equals(Color.PINK)){
//               dureza = 3;
//            }
//        }
    }

    /**
     * Aun Sin Terminar a medias El Nivel Por ahora es unico pero si ud gana el
     * nivel uno deberia de construir otros niveles
     *
     * @param won si gano mandara true y si no false y se acaba el juego
     */
    public void OnGameOver(boolean won) {
        if (won == true) {
            this.nivel++;
        }
        quit();
    }

    /**
     * pinta el numero del nivel en el que esta jugando el jugador
     *
     * @param g
     */
    public void numeronivel(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(0, 370, 220, 370);
        g.drawString("Nivel " + nivel, WIDTH / 2, 410);

    }

    /**
     * llama cuando el juego "marca"/ que esta en cada ciclo ejemplo que la
     * pelota pega cada vez elimina un bloque y el juego continua tambien si
     * todo esta vacio el juego termina
     */
    public void Marca() {
        double ElTiempoESPERA = (System.nanoTime() - UltimaActualizacion) / 1000000.0;
        ball.Marca(ElTiempoESPERA);
        if (blocks.isEmpty()) {
            OnGameOver(true);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate((getWidth() - width) / 2, (getHeight() - height) / 2);
        g.translate((int) (width / 2), (int) (height / 2));
        g.setColor(new Color(236, 240, 241));
        g.fillRect(0, 0, getWidth(), getHeight());
        ball.pintarPuntos(g);
        player.renderPlayer(g);
        ball.renderBALL(g);
        ball.life(g);
        pw.podereshabilitados(g);
        player.mover();
        numeronivel(g);
        if (blocks != null) {
            for (int i = 0; i < blocks.size(); i++) {
                blocks.get(i).renderBlock(g);
            }
        }

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        String msg = "";
        if (!isRunning) {
            msg = "(Espacio) para empezar el juego \n ";
            g.drawString("\n (P) Pausa \n (V) Pasa Niveles \n", 2, 300);
        } else if (isPaused) {
            msg = "Juego en Pausa";
        }

        FontMetrics fm = g.getFontMetrics();
        g.drawString(msg, -fm.stringWidth(msg) / 2, fm.getHeight() / 2);

    }
}
