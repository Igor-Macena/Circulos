/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protecao1;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author elio_alves
 */
public class Bola {
    public int x;
    public int y;
    public Color cor;
    public int dia;
    public int velx;
    public int vely;
    public int dirx;
    public int diry;
    public Janela pai;
    
    public void draw(Graphics g2){
        g2.setColor(cor);
        g2.fillOval(x, y, dia, dia);
        
        mover();
    }
    
    public void mover(){
        if (dirx == 1) {
            // indo para direita
            x = x + velx;

            // se bola encostar do lado direito, volta
            if (x >= pai.getWidth() - dia) {
                dirx = -1;
            }
        } else if (dirx == -1) {
            // indo para esquerda
            x = x - velx;

            // se a bola encostar no lado esquerdo, ir para direito
            if (x <= 0) {
                dirx = 1;
            }
        }

        if (diry == 1) {
            // indo para direita
            y = y + vely;

            // se bola encostar do lado direito, volta
            if (y >= pai.getHeight() - dia) {
                diry = -1;
            }
        } else if (diry == -1) {
            // indo para esquerda
            y = y - vely;

            // se a bola encostar no lado esquerdo, ir para direito
            if (y <= 0) {
                diry = 1;
            }
        }
    }
}
