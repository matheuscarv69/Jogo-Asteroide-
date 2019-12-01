/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Metricas;
import javax.swing.JLabel;

/**
 *
 * @author mathe
 */
public class nave extends JLabel {

    private int x;
    private int y;

    private static int andar = 25;

    private static int width = 50;//85
    private static int height = 62;//79

    public nave(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, width, height);
        
        if (Metricas.escNave == 1) {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave1.png")));
        } else {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave2.png")));
        }
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
