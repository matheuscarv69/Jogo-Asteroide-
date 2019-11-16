/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import control.Metricas;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Asteroides;
import model.Bullets;
import model.nave;
import javax.swing.JOptionPane;

/**
 *
 * @author mathe
 */
public class ThreadPrincipal extends Thread {

    private nave nave;
    private Bullets tiro;
    private Asteroides ast;
    private JPanel jPanel;
    private JLabel pontos;
    private JLabel vidas;
    private JLabel explosao;

    public ThreadPrincipal(nave nave, Asteroides ast, JPanel jPanel, JLabel pontos, JLabel vidas) {
        this.nave = nave;
        this.ast = ast;
        this.jPanel = jPanel;
        this.pontos = pontos;
        this.vidas = vidas;
        start();
    }

    //@Override
    public void run() {
        // aqui o booleano inGame está dentro do while para parar de executar quando for setado com false
        // dessa forma ele não gera dois jOptionPane
        while (Metricas.inGame) {
            ast.movAst();

            // Remove o asteroide ao atingir y = 420
            if (verLimiteAst()) {
                jPanel.remove(ast);
                // colocar outro metodos de jpanel
                stop();
            }

            // Funcao de colisao entre nave e asteroide
            if (colisaoNavAst()) {
                jPanel.remove(ast);
                jPanel.validate();
                jPanel.repaint();

                // contagem de vidas
                Metricas.lifes--;
                vidas.setText(String.valueOf(Metricas.lifes));

                stop();
            }
            // Muda a imagem da nave de acordo com a quantidade de vidas
            mudaNave();

            /* para movimentos dos asteroides se vida zerar
            if (Metricas.lifes == 0) {
                stop();
            }
             */
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void getTiro(Bullets tiro) {
        this.tiro = tiro;

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    tiro.movBullet();

                    // Funcao para remover o tiro caso ele atinge y = -26
                    if (verLimiteTiro()) {
                        jPanel.remove(tiro);
                        jPanel.validate();
                        jPanel.repaint();
                        stop();
                    }

                    if (colisaoTiroAst()) {
                        jPanel.remove(ast);
                        jPanel.remove(tiro);
                        jPanel.validate();
                        jPanel.repaint();

                        // Funcao que para a movimentacao do Asteroide
                        paraAst();

                        // contagem de pontos ao Tiro atingir Asteroide
                        Metricas.score += 10;
                        pontos.setText(String.valueOf(Metricas.score));
                        stop();

                    }

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        }.start();

    }

    // Funcao que remove o tiro caso atinja a posicao y = -26 
    public boolean verLimiteTiro() {
        if (tiro.getY() == -26) {
            return true;
        } else {
            return false;
        }
    }

    // Funcao que remove o Asteroide ao atingir a posicao y = 420
    public boolean verLimiteAst() {
        if (ast.getY() > 420) {
            return true;
        } else {
            return false;
        }
    }

    // Funcao que para a Thread de movimento do asteroide de acordo com o if
    public void paraAst() {
        // funciona como se tivesse um this na frente do stop;
        this.stop();
    }

    // Funcao de colisao entre Nave e Asteroides
    public boolean colisaoNavAst() {
        Rectangle rectNave = new Rectangle(nave.getBounds());
        Rectangle rectAst = new Rectangle(ast.getBounds());

        return rectAst.intersects(rectNave);
    }

    // Funcao de colisao entre Tiro e Asteroides
    public boolean colisaoTiroAst() {
        Rectangle rectTiro = new Rectangle(tiro.getBounds());
        Rectangle rectAst = new Rectangle(ast.getBounds());

        return rectTiro.intersects(rectAst);
    }

    // Muda a imagem da nave de acordo com a quantidade de vidas
    public void mudaNave() {
        if (Metricas.lifes == 2) {
            nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nave2.png")));
        } else if (Metricas.lifes == 1) {
            nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nave3.png")));
        } else if (Metricas.lifes == 0) {

            jPanel.remove(nave);
            jPanel.validate();
            jPanel.repaint();

            // aqui seta o booleano inGame como falso para parar o while da Thread que movimenta o asteroide
            // dessa forma ele não gera dois jOptionPane
            Metricas.inGame = false;

            // OptionPane
            Icon figura = new javax.swing.ImageIcon(getClass().getResource("/images/facepalm2.png"));
            JOptionPane.showMessageDialog(null, "Já morreu fera? Ruimzão hein? affs!\nSó fez " + Metricas.score + " pontos!", "Asteroides", JOptionPane.PLAIN_MESSAGE, figura);
            // this para parar a thread principal 

            this.stop();
        }

    }
    // final
}
