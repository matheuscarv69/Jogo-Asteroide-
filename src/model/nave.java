/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JLabel;

/**
 *
 * @author mathe
 */
public class nave extends JLabel {

    private int x;
    private int y;

    private static int andar = 25;

    private static int width = 85;
    private static int height = 72;

    public nave() {
        this.x = 280;
        this.y = 330;
        setBounds(x, y, width, height);
        //setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/Nave.png")));
    }

    public nave(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, width, height);

        setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nave.png")));
    }

    public void andarDireita() {
        x = getX();
        y = getY();
        x += andar;

        setBounds(x, y, width, height);
    }

    public void andarEsquerda() {
        x = getX();
        y = getY();
        x -= andar;

        setBounds(x, y, width, height);
    }

    public void verDireita() {
        if (getX() > 580) {
            int a = -40;
            int b = getY();

            setBounds(a, b, width, height);
        }
    }

    public void verEsquerda() {
        if (getX() < -60) {
            int a = 580;
            int b = getY();

            setBounds(a, b, width, height);
        }
    }

}
