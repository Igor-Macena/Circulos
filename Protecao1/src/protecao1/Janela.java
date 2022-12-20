/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protecao1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author elio_alves
 */
public class Janela extends JFrame {

    public List<Bola> bolas = new ArrayList<>();
    BufferedImage img;

    public Janela() {
        super("Protecao1");

        setSize(640, 480);
        setVisible(true);

        for (int elio = 0; elio < 100; elio++) {
            Bola bola = new Bola();
            bola.x = (int) (600 * Math.random());
            bola.y = (int) (400 * Math.random());
            bola.dia = 10 + ((int) (90 * Math.random()));
            int vardx = (int) (Math.random() * 1);
            if (vardx == 0) {
                vardx = -1;
            }
            int vardy = (int) (Math.random() * 1);
            if (vardy == 0) {
                vardy = -1;
            }
            bola.dirx = vardx;
            bola.diry = vardy;
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            bola.cor = new Color(r, g, b);
            bola.velx = 5 + (int) (Math.random() * 10);
            bola.vely = 5 + (int) (Math.random() * 10);
            bola.pai = this;

            bolas.add(bola);
        }

        img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (img.getWidth() != getWidth() || img.getHeight() != getHeight()) {
            img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            System.out.println("oiiii");
        }

        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        for (Bola b : bolas) {
            b.draw(g2);
        }

        g.drawImage(img, 0, 0, null);
    }

}
