/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import control.Metricas;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Asteroides;
import model.Bullets;
import model.nave;
import sons.ThreadSom;

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

    private JLabel labelLife1;
    private JLabel labelLife2;
    private JLabel labelLife3;

    private static Rectangle rectAstD;
    private static Rectangle rectTiroD = new Rectangle(0, 0, 0, 0);

    private ThreadSom tSom = new ThreadSom();

    public ThreadPrincipal(nave nave, Asteroides ast, JPanel jPanel, JLabel pontos, JLabel labelLife1, JLabel labelLife2, JLabel labelLife3, JLabel velocidade) {
        this.nave = nave;
        this.ast = ast;
        this.jPanel = jPanel;
        this.pontos = pontos;
        this.labelLife1 = labelLife1;
        this.labelLife2 = labelLife2;
        this.labelLife3 = labelLife3;

        this.tiro = new Bullets(nave.getX() + 20, nave.getY() - 13);
        start();
    }

    @Override
    public void run() {
        // aqui o booleano inGame está dentro do while para parar de executar quando for setado com false
        // dessa forma ele não gera dois jOptionPane
        while (Metricas.inGame) {
            ast.movAst();

            // Remove o asteroide ao atingir y = 420
            if (verLimiteAst()) {
                jPanel.remove(ast);
                stop();
            }
            // Funcao de colisao entre nave e asteroide
            if (colisaoNavAst()) {
                jPanel.remove(ast);
                jPanel.validate();
                jPanel.repaint();
                // contagem de vidas
                tSom.somExpNave();
                diminuiLife();
                stop();
            }
            // O rectAstD pega o asteroide para garantir que ele seja
            // tangivel apos geracao de um novo asteroide
            rectAstD = new Rectangle(ast.getBounds());

            if (rectTiroD.intersects(rectAstD)) {
                //System.out.println("funcionou");
                jPanel.remove(ast);
                jPanel.validate();
                jPanel.repaint();
                tSom.somTiroAst();
                somaScore();
                stop();
            }
            // Muda a imagem da nave de acordo com a quantidade de vidas
            mudaDanoNave();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public synchronized void getTiro(Bullets tiro) {
        this.tiro = tiro;

        new Thread() {
            @Override
            public void run() {
                while (Metricas.inGame) {
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
                        // Funcao que para a movimentacao do Asteroide thread principal
                        paraAst();
                        // contagem de pontos ao Tiro atingir Asteroide
                        tSom.somTiroAst();
                        somaScore();
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
        return tiro.getY() == -26;
    }

    // Funcao que remove o Asteroide ao atingir a posicao y = 420
    public boolean verLimiteAst() {
        return ast.getY() > 420;
    }

    // Funcao que para a Thread Principal de movimento do asteroide de acordo com o if
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
    public synchronized boolean colisaoTiroAst() {
        Rectangle rectTiro = new Rectangle(tiro.getBounds());
        Rectangle rectAst = new Rectangle(ast.getBounds());
        // rectTiroD recebe o tiro para garatir que seja verificada a colisao com
        // o asteroide gerado inicialmente antes da criacao de outro
        rectTiroD = new Rectangle(rectTiro);
        return rectTiro.intersects(rectAst);
    }

    // Muda a imagem da nave de acordo com a quantidade de vidas
    public synchronized void mudaDanoNave() {
        if (Metricas.escNave == 1) {
            if (Metricas.lifes == 2) {
                nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave1-d1.png")));
            } else if (Metricas.lifes == 1) {
                nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave1-d2.png")));
            } else if (Metricas.lifes == 0) {
                this.stop();
            }
        } else {
            if (Metricas.lifes == 2) {
                nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave2-d1.png")));
            } else if (Metricas.lifes == 1) {
                nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave2-d2.png")));
            } else if (Metricas.lifes == 0) {
                this.stop();
            }
        }
    }

    public synchronized void somaScore() {
        Metricas.score += 10;
        pontos.setText(String.valueOf(Metricas.score));
    }

    public void diminuiLife() {
        Metricas.lifes--;

        if (Metricas.lifes == 2) {
            labelLife3.setVisible(false);
        } else if (Metricas.lifes == 1) {
            labelLife2.setVisible(false);
        } else if (Metricas.lifes == 0) {
            labelLife1.setVisible(false);
        }

    }

    // final
}
