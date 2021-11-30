/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author r
 */
public class Arkanoid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid  1280 * 720");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1280, 920);
        frame.setLocationRelativeTo(null);
        ArkanoidLogica game = new ArkanoidLogica(1280, 720);
        frame.add(game, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
}
