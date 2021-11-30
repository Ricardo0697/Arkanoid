/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

/**
 * @version 2.2
 * @author Ricardo
 */
public class HiloJuego extends Thread {

    private ArkanoidLogica game;

    public HiloJuego(ArkanoidLogica game) {
        this.game = game;
    }

    /**
     * Run corre la aplicacion
     */
    @Override
    public void run() {

        game.isRunning = true;
        game.isPaused = false;
        game.UltimaActualizacion = System.nanoTime();

        while (game.isRunning) {
            try {
                if (game.isPaused) {
                    game.UltimaActualizacion = System.nanoTime();
                    Thread.sleep(1);
                } else {
                    game.Marca();
                    game.UltimaActualizacion = System.nanoTime();// similar al repaint que usamos en la clase pero este se ejecuta un poco mas complejo
                    Thread.sleep((long) (1000.0 / game.getFPS()));
                }
            } catch (Exception e) {
                e.printStackTrace();//le dice donde ocurre el error  y que sucedio por que se cae
            }

        }
    }

}
